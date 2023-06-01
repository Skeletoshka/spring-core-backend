package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.RequestDTO;
import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.dnk.News;
import biz.spring.core.model.dnk.Request;
import biz.spring.core.repository.DocumentRealRepository;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.DocumentRealService;
import biz.spring.core.service.dnk.RequestService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.RequestView;
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
@Tag(name = "Контроллер для заявок", description = "Контроллер для работы с таблицей \"Заявка\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/document",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private DocumentRealService documentRealService;
    @Autowired
    private DocumentRealRepository documentRealRepository;

    public static class GridDataOptionRequest extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                    "<li> statusId - ИД статуса " +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Заявка\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/request/getlist", method = RequestMethod.POST)
    public DataResponse<RequestView> getList(@RequestBody GridDataOptionRequest gridDataOption){
        List<RequestView> result = requestService.getAll(gridDataOption);
        Integer count = requestService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Заявка\"",
            description = "Вовзращает объект согласно переданному идентификатору." +
                    "Если идентификатор пуст, то возвращает объект по умолчанию")
    @RequestMapping(value = "/request/get", method = RequestMethod.POST)
    public RequestDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new RequestDTO();
        }else{
            RequestDTO dto = new RequestDTO();
            RequestView view = requestService.getOne(id);
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Сохраняет объект \"Заявка\"",
            description = "Сохраняет объект в базу данных. " +
                    "Если идентификатор пуст, то объект вставляется, иначе обновляется")
    @RequestMapping(value = "/request/save", method = RequestMethod.POST)
    public RequestView save(@RequestBody RequestDTO dto){
        Request result;
        DocumentReal documentReal;
        if(dto.getRequestId() == null){
            DocumentReal dr = dto.toDocumentReal();
            dr.setDocumentTransitId(Request.DOCUMENT_DRAFT);
            documentReal = documentRealService.add(dr);
            dto.setRequestId(documentReal.getDocumentRealId());
            result = requestService.add(dto.toEntity());
        }else{
            documentReal = documentRealRepository.get(dto.getRequestId());
            dto.setDocumentRealDateCreate(documentReal.getDocumentRealDateCreate());
            dto.setDocumentTransitId(documentReal.getDocumentTransitId());
            documentRealService.edit(dto.toDocumentReal());
            result = requestService.edit(dto.toEntity());
        }
        return requestService.getOne(result.getRequestId());
    }

    @Operation(summary = "Удаляет объекты \"Заявка\"",
            description = "Удаляет объекты с переданными идентификаторами")
    @RequestMapping(value = "/request/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        requestService.delete(ids);
        documentRealService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Устанавливает статус \"Отправлен\" объектам \"Заявка\"",
            description = "Устанавливает статус \"Отправлен\" записям с переданными идентификаторами")
    @RequestMapping(value = "/request/setstatus/send", method = RequestMethod.POST)
    public String setSend(@RequestBody int[] ids){
        for(int id: ids) {
            documentRealService.setStatus(id, Request.DOCUMENT_SEND);
        }
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Устанавливает статус \"Принят\" объектам \"Заявка\"",
            description = "Устанавливает статус \"Принят\" записям с переданными идентификаторами")
    @RequestMapping(value = "/request/setstatus/submit", method = RequestMethod.POST)
    public String setSubmit(@RequestBody int[] ids){
        for(int id: ids) {
            documentRealService.setStatus(id, Request.DOCUMENT_SUBMIT);
        }
        return BaseService.STANDARD_SUCCESS;
    }

    @Operation(summary = "Устанавливает статус \"Отказано\" объектам \"Заявка\"",
            description = "Устанавливает статус \"Отказано\" записям с переданными идентификаторами")
    @RequestMapping(value = "/request/setstatus/reject", method = RequestMethod.POST)
    public String setReject(@RequestBody int[] ids){
        for(int id: ids) {
            documentRealService.setStatus(id, Request.DOCUMENT_REJECTION);
        }
        return BaseService.STANDARD_SUCCESS;
    }

}
