package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.TestHistoryDTO;
import biz.spring.core.service.TestHistoryService;
import biz.spring.core.view.*;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для истории тестов")
@RequestMapping(value = "/api/testhistory",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TestHistoryController {

    @Autowired
    private TestHistoryService testHistoryService;


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Истории тестов\"")
    @CrossOrigin
    public List<TestHistoryView> getList(String id){
        return testHistoryService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"История тестов\" по его идентификатору")
    @CheckAnyRole
    public TestHistoryDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new TestHistoryDTO();
        } else {
            TestHistoryView view = testHistoryService.getOne(id);
            TestHistoryDTO dto = new TestHistoryDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Истории тестов\"")
    public List<TestHistoryView> save(@RequestBody TestHistoryDTO testHistoryDTO){
        testHistoryService.save(testHistoryDTO.toEntity());
        return testHistoryService.getAll();
    }
}