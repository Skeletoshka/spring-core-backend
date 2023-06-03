package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.dto.ContractDTO;
import biz.spring.core.model.Contract;
import biz.spring.core.model.DocumentReal;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.AppendixService;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.ContractService;
import biz.spring.core.service.DocumentRealService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.ContractView;
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
@Tag(name = "Контроллер для Договоров", description = "Контроллер для получения договоров")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/document",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class ContractController {

    static class GridDataOptionContract extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li>documentTypeId - Тип контракта" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private ContractService contractService;
    @Autowired
    private DocumentRealService documentRealService;
    @Autowired
    private AppendixService appendixService;

    @Operation(summary = "Возвращает список объектов \"Договор\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/contract/getlist", method = RequestMethod.POST)
    public DataResponse<ContractView> getList(@RequestBody GridDataOptionContract gridDataOption){
        List<ContractView> result = contractService.getAll(gridDataOption);
        Integer count = contractService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Договор\"",
            description = "Вовзращает список объект \"Договор\" по его идентификатору. Если идентификатора нет - " +
                    "возвращается пустой объект")
    @RequestMapping(value = "/contract/get", method = RequestMethod.POST)
    public ContractDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new ContractDTO();
        }else{
            ContractView view = contractService.getOne(id);
            ContractDTO dto = new ContractDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Метод для сохранения объекта \"Договор\"",
            description = "Запись с заполненным идентификатором обновляется, с пустым - вставляется")
    @RequestMapping(value = "/contract/save", method = RequestMethod.POST)
    public ContractView save(@RequestBody ContractDTO dto){
        Contract result;
        if(dto.getContractId() == null){
            DocumentReal documentReal = documentRealService.add(dto.toDocumentReal());
            dto.setContractId(documentReal.getDocumentRealId());
            appendixService.add(dto.toAppendix());
            result = contractService.add(dto.toEntity());
        }else{
            DocumentReal documentReal = documentRealService.edit(dto.toDocumentReal());
            dto.setContractId(documentReal.getDocumentRealId());
            appendixService.edit(dto.toAppendix());
            result = contractService.edit(dto.toEntity());
        }
        return contractService.getOne(result.getContractId());
    }

    @Operation(summary = "Метод для удаления объекта \"Договор\"",
            description = "Удаляются записи с переданными идентификаторами")
    @RequestMapping(value = "/contract/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        contractService.delete(ids);
        appendixService.deleteFiles(ids);
        appendixService.delete(ids);
        documentRealService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
