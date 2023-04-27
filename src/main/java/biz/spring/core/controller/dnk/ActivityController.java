package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.ActivityDTO;
import biz.spring.core.model.dnk.Activity;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.ActivityService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.ActivityView;
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
@Tag(name = "Контроллер для активностей", description = "Контроллер для работы с таблицей \"Активность\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    public static class GridDataOptionActivity extends GridDataOption{
        @Schema(description = "" +
                "<ul>" +
                    "<li> companyId - ИД партнёра " +
                    "<li> directionId - ИД направления " +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Активность\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/activity/getlist", method = RequestMethod.POST)
    public DataResponse<ActivityView> getList(@RequestBody GridDataOptionActivity gridDataOption){
        List<ActivityView> result = activityService.getAll(gridDataOption);
        Integer count = activityService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Активность\"",
            description = "Вовзращает объект согласно переданному идентификатору. " +
                    "Если идентификатор пуст, то возвращает объект по умолчанию")
    @RequestMapping(value = "/activity/get", method = RequestMethod.POST)
    public ActivityDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new ActivityDTO();
        }else{
            ActivityDTO dto = new ActivityDTO();
            ActivityView view = activityService.getOne(id);
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Сохраняет объект \"Активность\"",
            description = "Сохраняет объект в базу данных. " +
                    "Если идентификатор пуст, то объект вставляется, иначе обновляется")
    @RequestMapping(value = "/activity/save", method = RequestMethod.POST)
    public ActivityView save(@RequestBody ActivityDTO dto){
        Activity result;
        if(dto.getActivityId() == null){
            result = activityService.add(dto.toEntity());
        }else{
            result = activityService.edit(dto.toEntity());
        }
        return activityService.getOne(result.getActivityId());
    }

    @Operation(summary = "Удаляет объекты \"Активность\"",
            description = "Удаляет объекты с переданными идентификаторами")
    @RequestMapping(value = "/activity/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        activityService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
