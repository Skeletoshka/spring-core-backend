package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.TestQuestionDTO;
import biz.spring.core.service.TestQuestionService;
import biz.spring.core.view.*;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для вопросов теста")
@RequestMapping(value = "/api/testquestion",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class TestQuestionController {

    @Autowired
    private TestQuestionService testQuestionService;


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Вопрос теста\"")
    @CrossOrigin
    public List<TestQuestionView> getList(String id){
        return testQuestionService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Вопрос теста\" по его идентификатору")
    @CheckAnyRole
    public TestQuestionDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new TestQuestionDTO();
        } else {
            TestQuestionView view = testQuestionService.getOne(id);
            TestQuestionDTO dto = new TestQuestionDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Вопрос теста\"")
    public List<TestQuestionView> save(@RequestBody TestQuestionDTO testQuestionDTO){
        testQuestionService.save(testQuestionDTO.toEntity());
        return testQuestionService.getAll();
    }
}