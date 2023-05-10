package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.StudyCaseDTO;
import biz.spring.core.model.dnk.StudyCase;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.StudyCaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.StudyCaseView;
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
@Tag(name = "Контроллер для кейсов обучения", description = "Контроллер для работы с таблицей \"Кейсы\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/studyprogram",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class StudyCaseController {

    @Autowired
    private StudyCaseService studyCaseService;

    public static class GridDataOptionStudyCase extends GridDataOption{
        @Schema(description = "" +
                "<ul>" +
                "<li> studyProgramId - ИД программы обучения " +
                "</ul>")
        public List<NamedFilter> getNamedFilter() { return super.getNamedFilters(); }
    }

    @Operation(summary = "Метод для получения списка объектов \"Кейсы программы обучения\"",
            description = "Возвращает список объектов \"Кейсы программ обучения\" согласно переданным фильтрам")
    @RequestMapping(value = "/studycase/getlist", method = RequestMethod.POST)
    public DataResponse<StudyCaseView> getList(@RequestBody GridDataOptionStudyCase gridDataOption){
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream().anyMatch(nf ->nf.getName().equals("studyProgramId"));
        if(!studyProgramFound){
            gridDataOption.getNamedFilter().add(new GridDataOption.NamedFilter("studyProgramId", - 1));
        }
        List<StudyCaseView> result = studyCaseService.getAll(gridDataOption);
        Integer count = studyCaseService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }


    @Operation(summary = "Возвращает объект \"Кейсы\"",
            description = "Возвращает объект \"Кейсы\" по его идентификатору. При отсутствии идентификатора - " +
                    "возвращается объект с полями по умолчанию")
    @RequestMapping(value = "/studycase/get", method = RequestMethod.POST)
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

    @Operation(summary = "Метод для сохранения объекта \"Кейсы\"",
            description = "Запись с заполненным идентификатором обновляется, а с пустым вставляется")
    @RequestMapping(value = "/studycase/save", method = RequestMethod.POST)
    public StudyCaseView save(@RequestBody StudyCaseDTO studyCaseDTO){
        StudyCase studyCase;
        if(studyCaseDTO.getStudyCaseId()==null){
            studyCase = studyCaseService.add(studyCaseDTO.toEntity());
        }else {
            studyCase = studyCaseService.edit(studyCaseDTO.toEntity());
        }
        return studyCaseService.getOne(studyCase.getStudyCaseId());
    }

    @Operation(summary = "Метод для удаления объекта \"Кейсы\"",
            description = "Удаляются записи с переданными идентификаторами")
    @RequestMapping(value = "/studycase/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        studyCaseService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
