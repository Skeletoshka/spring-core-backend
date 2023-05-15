package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.model.dnk.Service;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.ServiceService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.ServiceView;
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
@Tag(name = "Контроллер для активностей", description = "Контроллер для работы с таблицей \"Услуги\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    public static class GridDataOptionService extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Услуга\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/service/getlist", method = RequestMethod.POST)
    public DataResponse<ServiceView> getList(@RequestBody GridDataOptionService gridDataOption){
        List<ServiceView> result = serviceService.getAll(gridDataOption);
        Integer count = serviceService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

}
