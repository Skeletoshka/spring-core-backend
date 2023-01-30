package biz.spring.core.controller;


import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.StudyProgramDTO;
import biz.spring.core.model.StudyProgram;
import biz.spring.core.repository.StudyProgramRepository;
import biz.spring.core.service.StudyProgramService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.StudyProgramView;
import org.junit.jupiter.api.Tag;
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
@Tag(value = "Контроллер для программы обучения" )
@RequestMapping(value = "/api/studyprogram",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class StudyProgramController {

    @Autowired
    private StudyProgramService studyProgramService;

    @Autowired
    private StudyProgramRepository studyProgramRepository;

    static class GridDataOptionStudyProgram extends GridDataOption {
        public GridDataOptionStudyProgram(){
            super("" +
                    "studyProgramId - ИД должности");
        }
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Программа обучения\"")
    @CheckAdminRole
    public List<StudyProgramView> getList(@RequestBody StudyProgramController.GridDataOptionStudyProgram gridDataOptionStudyProgram){
        boolean findStudyProgram = gridDataOptionStudyProgram.getParams().get("studyProgramId") != null;
        if(!findStudyProgram){
            gridDataOptionStudyProgram.getParams().put("studyProgramId", -1);
        }
        return studyProgramService.getAll(gridDataOptionStudyProgram);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Программа обучения\" по его идентификатору")
    @CheckAnyRole
    public StudyProgramDTO get(@RequestBody(required = false ) int id){
        if (id == 0){
            return new StudyProgramDTO();
        } else{
            StudyProgramView view = studyProgramService.getOne(id);
            StudyProgramDTO dto = new StudyProgramDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Программа обучения\"")
    public StudyProgramView save(@RequestBody StudyProgramDTO studyProgramDTO){
        if(studyProgramDTO.getStudyProgramId() == null) {
            Integer id = studyProgramRepository.insert(studyProgramDTO.toEntity());
            studyProgramDTO.setStudyProgramId(id);

        }else{
            studyProgramRepository.update(studyProgramDTO.toEntity());
        }
        return studyProgramService.getOne(studyProgramDTO.getStudyProgramId());
    }


}
