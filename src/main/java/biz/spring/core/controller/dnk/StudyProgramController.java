package biz.spring.core.controller.dnk;


import biz.spring.core.annotations.CheckAdminRole;
import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.dnk.StudyProgramDTO;
import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.StudyProgram;
import biz.spring.core.repository.DocumentRealRepository;
import biz.spring.core.repository.dnk.StudyProgramRepository;
import biz.spring.core.service.DocumentRealService;
import biz.spring.core.service.dnk.StudyProgramService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.StudyProgramView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Tag(name = "Контроллер для программы обучения",
        description = "Контроллер для взаимодействий с объектом \"Программа обучения\"")
@RequestMapping(value = "/api/studyprogram",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class StudyProgramController {

    @Autowired
    private StudyProgramService studyProgramService;
    @Autowired
    private DocumentRealService documentRealService;

    @Autowired
    private StudyProgramRepository studyProgramRepository;
    @Autowired
    private DocumentRealRepository documentRealRepository;

    static class GridDataOptionStudyProgram extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                    "<li>directionId - Направление "+
                    "<li>teacherId - Преподаватель " +
                    "<li>assistantId - Ассистент "+
                "</ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения списка объектов \"Программа обучения\"",
        description = "Возвращает список объектов \"Программа обучения\" согласно переданным фильтрам")
    @CheckAdminRole
    public List<StudyProgramView> getList(@RequestBody StudyProgramController.GridDataOptionStudyProgram gridDataOption){
        boolean directionFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "directionId".equals(nf.getName()));
        if(!directionFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("directionId", -1));
        }
        boolean teacherFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "teacherId".equals(nf.getName()));
        if(!teacherFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("teacherId", -1));
        }
        boolean assistantFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "assistantId".equals(nf.getName()));
        if(!assistantFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("assistantId", -1));
        }
        return studyProgramService.getAll(gridDataOption);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения объекта \"Программа обучения\" по его идентификатору",
        description = "Возвращает объект \"Программа обучения\" по его идентификатору." +
                " Если идентификатор пуст, возращает объект по умолчанию")
    @CheckAnyRole
    public StudyProgramDTO get(@RequestBody(required = false ) Integer id){
        if (id == null){
            return new StudyProgramDTO();
        } else{
            StudyProgramView view = studyProgramService.getOne(id);
            StudyProgramDTO dto = new StudyProgramDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Программа обучения\"", description = "Сохраняет объект в базе данных. " +
            "Если идентификатор пуст, то происходит добавление, иначе обновление записи")
    public StudyProgramView save(@RequestBody StudyProgramDTO studyProgramDTO){
        StudyProgram result;
        if(studyProgramDTO.getStudyProgramId() == null){
            DocumentReal documentReal = documentRealService.add(studyProgramDTO.toDocumentReal());
            studyProgramDTO.setStudyProgramId(documentReal.getDocumentRealId());
            result = studyProgramService.add(studyProgramDTO.toEntity());
        }else{
            DocumentReal documentReal = documentRealRepository.get(studyProgramDTO.getStudyProgramId());
            documentReal.setDocumentRealNumber(studyProgramDTO.getDocumentRealNumber());
            documentRealService.edit(documentReal);
            result = studyProgramService.edit(studyProgramDTO.toEntity());
        }
        return studyProgramService.getOne(result.getStudyProgramId());
    }



}
