package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.AccessRoleDTO;
import biz.spring.core.service.AccessRoleService;
import biz.spring.core.view.AccessRoleView;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для пользователей")
@RequestMapping(value = "/api/people",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Пользователь\"")
    @CrossOrigin
    public List<PeopleView> getList(String id){
        return peopleService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Пользователь\" по его идентификатору")
    @CheckAnyRole
    public PeopleDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new PeopleDTO();
        } else {
            PeopleView view = peopleService.getOne(id);
            PeopleDTO dto = new PeopleDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Пользователь\"")
    public List<PeopleView> save(@RequestBody PeopleDTO peopleDTO){
        peopleService.save(peopleDTO.toEntity());
        return peopleService.getAll();
    }
}
