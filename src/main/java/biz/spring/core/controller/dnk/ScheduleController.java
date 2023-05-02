package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.ScheduleDTO;
import biz.spring.core.model.dnk.Schedule;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.ScheduleService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.ScheduleView;
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
@Tag(name = "Контроллер для расписания", description = "Контроллер для работы с таблицей \"Расписание\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    public static class GridDataOptionSchedule extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li> studyProgramId - ИД программы обучения " +
                "<li> workGroupId - ИД учебной группы " +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Расписание\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/schedule/getlist", method = RequestMethod.POST)
    public DataResponse<ScheduleView> getList(@RequestBody GridDataOptionSchedule gridDataOption){
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("studyProgramId"));
        if(!studyProgramFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("studyProgramId", -1));
        }
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("workGroupId"));
        if(!workGroupFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("workGroupId", -1));
        }
        List<ScheduleView> result = scheduleService.getAll(gridDataOption);
        Integer count = scheduleService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Расписание\"",
            description = "Вовзращает объект согласно переданному идентификатору. " +
                    "Если идентификатор пуст, то возвращает объект по умолчанию")
    @RequestMapping(value = "/schedule/get", method = RequestMethod.POST)
    public ScheduleDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new ScheduleDTO();
        }else{
            ScheduleDTO dto = new ScheduleDTO();
            ScheduleView view = scheduleService.getOne(id);
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Сохраняет объект \"Расписание\"",
            description = "Сохраняет объект в базу данных. " +
                    "Если идентификатор пуст, то объект вставляется, иначе обновляется")
    @RequestMapping(value = "/schedule/save", method = RequestMethod.POST)
    public ScheduleView save(@RequestBody ScheduleDTO dto){
        Schedule result;
        if(dto.getScheduleId() == null){
            result = scheduleService.add(dto.toEntity());
        }else{
            result = scheduleService.edit(dto.toEntity());
        }
        return scheduleService.getOne(result.getScheduleId());
    }

    @Operation(summary = "Удаляет объекты \"Расписание\"",
            description = "Удаляет объекты с переданными идентификаторами")
    @RequestMapping(value = "/schedule/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        scheduleService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
