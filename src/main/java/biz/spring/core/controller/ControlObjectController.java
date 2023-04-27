package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.dto.ControlObjectRoleDTO;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.ControlObjectService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.ControlObjectView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Tag(name = "Контроллер для контроллируемых объектов", description = "Контроллер для получения контроллируемых объектов, доступ только админу")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class ControlObjectController {
    static class GridDataOptionControlObject extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                    "<li> accessRoleId - Роль пользователя" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private ControlObjectService controlObjectService;

    @Operation(summary = "Возвращает список объектов \"Контроллируемый объект\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/controlobject/getlist", method = RequestMethod.POST)
    public DataResponse<ControlObjectView> getlist(@RequestBody GridDataOptionControlObject gridDataOption){
        if (gridDataOption.getNamedFilters().stream().noneMatch(filter -> "accessRoleId".equals(filter.getName()))){
            throw new RuntimeException("Выберите роль");
        }
        List<ControlObjectView> result = controlObjectService.getAll(gridDataOption);
        Integer count = controlObjectService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Добавляет права у \"Роль доступа\"",
            description = "Добавляет права, доступные определенной роли.")
    @RequestMapping(value = "/controlobjectrole/bind", method = RequestMethod.POST)
    public String bind(@RequestBody ControlObjectRoleDTO dto){
        controlObjectService.insertAccess(dto);
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Добавляет права у \"Роль доступа\"",
            description = "Добавляет права, доступные определенной роли.")
    @RequestMapping(value = "/controlobjectrole/unbind", method = RequestMethod.POST)
    public String unbind(@RequestBody ControlObjectRoleDTO dto){
        controlObjectService.deleteAccess(dto);
        return BaseService.STANDARD_SUCCESS;
    }

}
