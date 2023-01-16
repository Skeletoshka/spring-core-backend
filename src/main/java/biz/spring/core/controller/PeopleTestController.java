package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.PeopleTestDTO;
import biz.spring.core.service.PeopleTestService;
import biz.spring.core.view.PeopleTestView;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для теста пользователя")
@RequestMapping(value = "/api/peopletest",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleTestController {

    @Autowired
    private PeopleTestService peopleTestService;


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Тест пользователя\"")
    @CrossOrigin
    public List<PeopleTestView> getList(String id){
        return peopleTestService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Тест пользователя\" по его идентификатору")
    @CheckAnyRole
    public PeopleTestDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new PeopleTestDTO();
        } else {
            PeopleTestView view = peopleTestService.getOne(id);
            PeopleTestDTO dto = new PeopleTestDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Тест пользователя\"")
    public List<PeopleTestView> save(@RequestBody PeopleTestDTO peopleTestDTO){
        peopleTestService.save(peopleTestDTO.toEntity());
        return peopleTestService.getAll();
    }
}