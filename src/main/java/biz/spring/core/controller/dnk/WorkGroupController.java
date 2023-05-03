package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.WorkGroupDTO;
import biz.spring.core.model.dnk.WorkGroup;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.WorkGroupService;
import biz.spring.core.view.dnk.WorkGroupView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Контроллер для учебных групп", description = "Контроллер для работы с таблицей \"Учебная группа\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class WorkGroupController {

    @Autowired
    private WorkGroupService workGroupService;

    @RequestMapping(value = "/workgroup/get", method = RequestMethod.POST)
    @Operation(summary = "Возвращает объект \"Учебная группа\"",
            description = "Возвращает объект \"Учебная группа\" по его идентификатору. При отсутствии идентификатора - " +
                    "возвращается объект с полями по умолчанию")
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
    @RequestMapping(value = "/workgroup/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Учебная группа\"",
            description = "Запись с заполненным идентификатором обновляется, а с пустым вставляется")
    public WorkGroupView save(@RequestBody WorkGroupDTO workGroupDTO){
        WorkGroup workGroup;
        if(workGroupDTO.getWorkGroupId()==null){
            workGroup = workGroupService.add(workGroupDTO.toEntity());
        }else {
            workGroup = workGroupService.edit(workGroupDTO.toEntity());
        }
        return workGroupService.getOne(workGroup.getWorkGroupId());
    }

    @RequestMapping(value = "/workgroup/delete", method = RequestMethod.POST)
    @Operation(summary = "Метод для удаления объекта \"Учебная группа\"",
            description = "Удаляются записи с переданными идентификаторами")
    public String delete(@RequestBody int[] ids){
        workGroupService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
