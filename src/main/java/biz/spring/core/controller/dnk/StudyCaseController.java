package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.StudyCaseDTO;
import biz.spring.core.model.dnk.StudyCase;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.StudyCaseService;
import biz.spring.core.view.dnk.StudyCaseView;
import io.swagger.v3.oas.annotations.Operation;
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
@Tag(name = "Контроллер для кейсов обучения", description = "Контроллер для работы с таблицей \"Кейсы\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class StudyCaseController {

    @Autowired
    private StudyCaseService studyCaseService;


    @RequestMapping(value = "/studycase/get", method = RequestMethod.POST)
    @Operation(summary = "Возвращает объект \"Кейсы\"",
            description = "Возвращает объект \"Кейсы\" по его идентификатору. При отсутствии идентификатора - " +
                    "возвращается объект с полями по умолчанию")
    public StudyCaseDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new StudyCaseDTO();
        } else {
            StudyCaseView view = studyCaseService.getOne(id);
            StudyCaseDTO dto = new StudyCaseDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }
    @RequestMapping(value = "/studycase/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Кейсы\"",
            description = "Запись с заполненным идентификатором обновляется, а с пустым вставляется")
    public StudyCaseView save(@RequestBody StudyCaseDTO studyCaseDTO){
        StudyCase studyCase;
        if(studyCaseDTO.getStudyCaseId()==null){
            studyCase = studyCaseService.add(studyCaseDTO.toEntity());
        }else {
            studyCase = studyCaseService.edit(studyCaseDTO.toEntity());
        }
        return studyCaseService.getOne(studyCase.getStudyCaseId());
    }

    @RequestMapping(value = "/studycase/delete", method = RequestMethod.POST)
    @Operation(summary = "Метод для удаления объекта \"Кейсы\"",
            description = "Удаляются записи с переданными идентификаторами")
    public String delete(@RequestBody int[] ids){
        studyCaseService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
