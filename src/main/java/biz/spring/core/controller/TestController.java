package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.TestDTO;
import biz.spring.core.view.TestView;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для тестов")
@RequestMapping(value = "/api/test",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController {

    @Autowired
    private TestService testService;


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Тест\"")
    @CrossOrigin
    public List<TestView> getList(String id){
        return testService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Тест\" по его идентификатору")
    @CheckAnyRole
    public TestDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new TestDTO();
        } else {
            TestView view = testService.getOne(id);
            TestDTO dto = new TestDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Тест\"")
    public List<TestView> save(@RequestBody TestDTO testDTO){
        testService.save(testDTO.toEntity());
        return testService.getAll();
    }
}