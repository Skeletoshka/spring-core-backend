package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.NewsDTO;
import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.News;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.DocumentRealService;
import biz.spring.core.service.dnk.NewsService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.NewsView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Контроллер для Новостей", description = "Контроллер для работы с таблицей \"Новость\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/document",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private DocumentRealService documentRealService;

    public static class GridDataOptionNews extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li> statusId - ИД статуса " +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Новость\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/news/getlist", method = RequestMethod.POST)
    @CrossOrigin
    public DataResponse<NewsView> getList(@RequestBody GridDataOptionNews gridDataOption){
        List<NewsView> result = newsService.getAll(gridDataOption);
        Integer count = newsService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Новость\"",
            description = "Вовзращает объект согласно переданному идентификатору." +
                    "Если идентификатор пуст, то возвращает объект по умолчанию")
    @RequestMapping(value = "/news/get", method = RequestMethod.POST)
    public NewsDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new NewsDTO();
        }else{
            NewsDTO dto = new NewsDTO();
            NewsView view = newsService.getOne(id);
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Сохраняет объект \"Новость\"",
            description = "Сохраняет объект в базу данных. " +
                    "Если идентификатор пуст, то объект вставляется, иначе обновляется")
    @RequestMapping(value = "/news/save", method = RequestMethod.POST)
    public NewsView save(@RequestBody NewsDTO dto){
        News result;
        DocumentReal documentReal;
        if(dto.getNewsId() == null){
            documentReal = documentRealService.add(dto.toDocumentReal());
            dto.setNewsId(documentReal.getDocumentRealId());
            result = newsService.add(dto.toEntity());
        }else{
            documentRealService.edit(dto.toDocumentReal());
            result = newsService.edit(dto.toEntity());
        }
        return newsService.getOne(result.getNewsId());
    }

    @Operation(summary = "Удаляет объекты \"Новость\"",
            description = "Удаляет объекты с переданными идентификаторами")
    @RequestMapping(value = "/news/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        newsService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

}
