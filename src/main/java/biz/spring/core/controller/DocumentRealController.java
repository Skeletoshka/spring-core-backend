package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.dto.DocumentRealDTO;
import biz.spring.core.model.DocumentReal;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.DocumentRealService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.DocumentRealView;
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
@Tag(name = "Контроллер для документов", description = "Контроллер для работы с документами")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/document",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class DocumentRealController {

    static class GridDataOptionDocumentReal extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li>documentTypeId - тип документа" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private DocumentRealService documentRealService;

    @Operation(summary = "Возвращает список объектов \"Документ\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/documentreal/getlist", method = RequestMethod.POST)
    public DataResponse<DocumentRealView> getList(@RequestBody GridDataOptionDocumentReal gridDataOption){
        boolean documentTypeFound = gridDataOption.getNamedFilters().stream().anyMatch(nf ->
                "documentTypeId".equals(nf.getName()));
        if(!documentTypeFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("documentTypeId", -1));
        }
        List<DocumentRealView> result = documentRealService.getAll(gridDataOption);
        Integer count = documentRealService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Документ\"",
            description = "Возвращает объект \"Документ\" по его id. Если id null, то возвращается пустой документ")
    @RequestMapping(value = "/documentreal/get", method = RequestMethod.POST)
    public DocumentRealDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new DocumentRealDTO();
        }else{
            DocumentRealView view = documentRealService.getOne(id);
            DocumentRealDTO dto = new DocumentRealDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Метод для сохранения объекта \"Документ\"", description = "Если идентификатор пустой, то " +
            "производится вставка, иначе проивзодится сохранение")
    @RequestMapping(value = "/documentreal/save", method = RequestMethod.POST)
    public DocumentRealView save(@RequestBody DocumentRealDTO dto){
        DocumentReal result;
        if(dto.getDocumentRealId() == null){
            result = documentRealService.add(dto.toEntity());
        }else{
            result = documentRealService.edit(dto.toEntity());
        }
        return documentRealService.getOne(result.getDocumentRealId());
    }


    @Operation(summary = "Метод для удаления объектов \"Документ\"", description = "Удаляет все записи с переданными " +
            "идентификаторами")
    @RequestMapping(value = "/documentreal/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        documentRealService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

}
