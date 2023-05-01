package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.model.dnk.News;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.NewsService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.NewsView;
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
    public DataResponse<NewsView> getList(@RequestBody NewsController.GridDataOptionNews gridDataOption){
        gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("statusId", News.RELEASE));
        List<NewsView> result = newsService.getAll(gridDataOption);
        Integer count = newsService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

}
