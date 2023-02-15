package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.AnswerDTO;
import biz.spring.core.service.AnswerService;
import biz.spring.core.view.AnswerView;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для вопросов")
@RequestMapping(value = "/api/answer",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AnswerController {

    @Autowired
    private AnswerService answerService;


    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Ответ\"")
    @CrossOrigin
    public List<AnswerView> getList(String id){
        return answerService.getAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Ответ\" по его идентификатору")
    @CheckAnyRole
    public AnswerDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new AnswerDTO();
        } else {
            AnswerView view = answerService.getOne(id);
            AnswerDTO dto = new AnswerDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Тест\"")
    public List<AnswerView> save(@RequestBody AnswerDTO answerDTO){
        answerService.save(answerDTO.toEntity());
        return answerService.getAll();
    }
}