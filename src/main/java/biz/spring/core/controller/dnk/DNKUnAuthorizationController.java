package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.model.dnk.News;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.NewsService;
import biz.spring.core.service.dnk.StudyProgramService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.NewsView;
import biz.spring.core.view.dnk.StudyProgramView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Контроллер для Новостей", description = "Контроллер для работы с таблицей \"Новость\"")
@RequestMapping(value = "/security/v" + Config.CURRENT_VERSION + "/apps/dnk/document",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class DNKUnAuthorizationController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private StudyProgramService studyProgramService;

    public static class GridDataOptionNews extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Новость\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/news/getlist", method = RequestMethod.POST)
    public DataResponse<NewsView> getList(@RequestBody GridDataOptionNews gridDataOption){
        gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("statusId", News.RELEASE));
        List<NewsView> result = newsService.getAll(gridDataOption);
        Integer count = newsService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

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

    @RequestMapping(value = "/studyprogram/getlist", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения списка объектов \"Программа обучения\"",
            description = "Возвращает список объектов \"Программа обучения\" согласно переданным фильтрам")
    public DataResponse<StudyProgramView> getList(@RequestBody GridDataOptionStudyProgram gridDataOption){
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
        List<StudyProgramView> result = studyProgramService.getAll(gridDataOption);
        Integer count = studyProgramService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

}
