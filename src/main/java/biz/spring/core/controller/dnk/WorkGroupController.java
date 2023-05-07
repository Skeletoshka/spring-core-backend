package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.WorkGroupDTO;
import biz.spring.core.model.dnk.WorkGroup;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.WorkGroupService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.WorkGroupView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Контроллер для учебных групп", description = "Контроллер для работы с таблицей \"Учебная группа\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class WorkGroupController {

    @Autowired
    private WorkGroupService workGroupService;

    public static class GridDataOptionWorkGroup extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li> directionId - ИД направления " +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Учебная группа\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/workgroup/getlist", method = RequestMethod.POST)
    public DataResponse<WorkGroupView> getList(@RequestBody GridDataOptionWorkGroup gridDataOption){
        boolean directionFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("directionId"));
        if(!directionFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("directionId", -1));
        }
        List<WorkGroupView> result = workGroupService.getAll(gridDataOption);
        Integer count = workGroupService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Учебная группа\"",
            description = "Возвращает объект \"Учебная группа\" по его идентификатору. При отсутствии идентификатора - " +
                    "возвращается объект с полями по умолчанию")
    @RequestMapping(value = "/workgroup/get", method = RequestMethod.POST)
    public WorkGroupDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new WorkGroupDTO();
        } else {
            WorkGroupView view = workGroupService.getOne(id);
            WorkGroupDTO dto = new WorkGroupDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Метод для сохранения объекта \"Учебная группа\"",
            description = "Запись с заполненным идентификатором обновляется, а с пустым вставляется")
    @RequestMapping(value = "/workgroup/save", method = RequestMethod.POST)
    public WorkGroupView save(@RequestBody WorkGroupDTO workGroupDTO){
        WorkGroup workGroup;
        if(workGroupDTO.getWorkGroupId()==null){
            workGroup = workGroupService.add(workGroupDTO.toEntity());
        }else {
            workGroup = workGroupService.edit(workGroupDTO.toEntity());
        }
        return workGroupService.getOne(workGroup.getWorkGroupId());
    }

    @Operation(summary = "Метод для удаления объекта \"Учебная группа\"",
            description = "Удаляются записи с переданными идентификаторами")
    @RequestMapping(value = "/workgroup/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        workGroupService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Метод для связывания объекта \"Учебная группа\" с объектом \"Ученик\"",
            description = "Создается запись в таблице связи группа-ученик")
    @RequestMapping(value = "/workgroup/bind", method = RequestMethod.POST)
    public String bind(@RequestBody PeopleGroup workGroupBind){
        workGroupService.bindWithPeople(workGroupBind.workGroupId, workGroupBind.peopleId);
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Метод для удаления связи объекта \"Учебная группа\" с объектом \"Ученик\"",
            description = "Удаляется запись в таблице связи группа-ученик")
    @RequestMapping(value = "/workgroup/unbind", method = RequestMethod.POST)
    public String unbind(@RequestBody PeopleGroup workGroupBind){
        workGroupService.unBindWithPeople(workGroupBind.workGroupId, workGroupBind.peopleId);
        return BaseService.STANDARD_SUCCESS;
    }

    public static class PeopleGroup{

        @Schema(description = "ИД учебной группы")
        private Integer workGroupId;

        @Schema(description = "ИД человека")
        private Integer peopleId;

        public PeopleGroup() {
        }

        public PeopleGroup(Integer workGroupId, Integer peopleId) {
            this.workGroupId = workGroupId;
            this.peopleId = peopleId;
        }

        public Integer getWorkGroupId() {
            return workGroupId;
        }

        public void setWorkGroupId(Integer workGroupId) {
            this.workGroupId = workGroupId;
        }

        public Integer getPeopleId() {
            return peopleId;
        }

        public void setPeopleId(Integer peopleId) {
            this.peopleId = peopleId;
        }
    }
}
