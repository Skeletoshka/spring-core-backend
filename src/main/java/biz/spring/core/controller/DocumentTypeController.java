package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.DocumentTypeService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.DocumentTypeView;
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
@Tag(name = "Контроллер для типов документов",
        description = "Контроллер для работы с типами документов")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class DocumentTypeController {
    static class GridDataOptionDocumentType extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private DocumentTypeService documentTypeService;

    @Operation(summary = "Возвращает список объектов \"Тип документа\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/documenttype/getlist", method = RequestMethod.POST)
    public DataResponse<DocumentTypeView> getList(@RequestBody GridDataOptionDocumentType gridDataOption){
        List<DocumentTypeView> result = documentTypeService.getAll(gridDataOption);
        Integer count = documentTypeService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }
}
