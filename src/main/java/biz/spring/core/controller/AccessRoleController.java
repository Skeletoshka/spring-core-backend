package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.config.Config;
import biz.spring.core.dto.AccessRoleDTO;
import biz.spring.core.service.AccessRoleService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.AccessRoleView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Контроллер для ролей", description = "Контроллер для получения ролей, доступ только админу")
@RequestMapping(value = "/api",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class AccessRoleController {

    static class GridDataOptionAccessRole extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private AccessRoleService accessRoleService;

    @Operation(summary = "Возвращает список объектов \"Роль\"",
                    description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/accessrole/getlist", method = RequestMethod.POST)
    public List<AccessRoleView> getList(@RequestBody GridDataOptionAccessRole gridDataOptionAccessRole){
        return accessRoleService.getAll();
    }

    @RequestMapping(value = "/accessrole/get", method = RequestMethod.POST)
    @Operation(summary = "Возвращает объект \"Роль\"",
            description = "Вовзращает список объект \"Роль\" по его идентификатору. Если идентификатора нет - " +
                    "возвращается пустой объект")
    @CheckAnyRole
    public AccessRoleDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new AccessRoleDTO();
        } else {
            AccessRoleView view = accessRoleService.getOne(id);
            AccessRoleDTO dto = new AccessRoleDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/accessrole/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Роль\"",
            description = "Запись с заполненным идентификатором обновляется, с пустым - вставляется")
    public List<AccessRoleView> save(@RequestBody AccessRoleDTO accessRoleDTO){
        //todo добавить ветвление
        accessRoleService.save(accessRoleDTO.toEntity());
        return accessRoleService.getAll();
    }
}
