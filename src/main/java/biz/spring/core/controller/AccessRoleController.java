package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.AccessRoleDTO;
import biz.spring.core.service.AccessRoleService;
import biz.spring.core.view.AccessRoleView;
import io.swagger.v3.oas.annotations.Operation;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для ролей")
@RequestMapping(value = "/api/accessrole",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class AccessRoleController {

    @Autowired
    private AccessRoleService accessRoleService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @CrossOrigin
    @Operation(summary = "Возвращает список объектов \"Роль\"",
                    description = "Вовзращает список объектов согласно переданным фильтрам")
    public List<AccessRoleView> getList(String id){
        return accessRoleService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Роль\" по его идентификатору")
    @CheckAnyRole
    public AccessRoleDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new AccessRoleDTO();
        } else {
            AccessRoleView view = accessRoleService.getOne(id);
            AccessRoleDTO dto = new AccessRoleDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Роль\"")
    public List<AccessRoleView> save(@RequestBody AccessRoleDTO accessRoleDTO){
        accessRoleService.save(accessRoleDTO.toEntity());
        return accessRoleService.getAll();
    }
}
