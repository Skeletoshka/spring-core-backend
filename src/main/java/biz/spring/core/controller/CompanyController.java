package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.dto.CompanyDTO;
import biz.spring.core.model.Company;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.CompanyService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.CompanyView;
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
@Tag(name = "Контроллер для партнёров", description = "Контроллер для получения партнёров")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/contragent",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class CompanyController {

    static class GridDataOptionCompany extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private CompanyService companyService;

    @Operation(summary = "Возвращает список объектов \"Компания\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/company/getlist", method = RequestMethod.POST)
    public List<CompanyView> getList(@RequestBody GridDataOptionCompany gridDataOption){
        return companyService.getAll(gridDataOption);
    }

    @Operation(summary = "Получение одной записи \"Компания\" по ее идентификатору",
            description = "Получение одной записи \"Компания\" по ее идентификатору. " +
                    "Если идентификатора нет, возвращается запись с полями по умолчанию")
    @RequestMapping(value = "/company/get", method = RequestMethod.POST)
    public CompanyDTO get(@RequestBody(required = false) Integer id){
        if (id == null){
            return new CompanyDTO();
        }else{
            CompanyView view = companyService.getOne(id);
            CompanyDTO dto = new CompanyDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Сохранение одной записи \"Компания\"",
            description = "Сохранение одной записи \"Компания\". " +
                    "Если идентификатора нет, то запись вставляется, иначе обновляется")
    @RequestMapping(value = "/company/save", method = RequestMethod.POST)
    public CompanyView save(@RequestBody CompanyDTO companyDTO){
        Company result;
        if(companyDTO.getCompanyId() == null){
            result = companyService.add(companyDTO.toEntity());
        }else{
            result = companyService.edit(companyDTO.toEntity());
        }
        return companyService.getOne(result.getCompanyId());
    }

    @Operation(summary = "Удаление записей \"Компания\"",
            description = "Удаление записей \"Компания\". " +
                    "Удаление записей по их идентификаторам")
    @RequestMapping(value = "/company/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        companyService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

}
