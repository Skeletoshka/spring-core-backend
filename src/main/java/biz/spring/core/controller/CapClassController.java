package biz.spring.core.controller;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.config.Config;
import biz.spring.core.service.CapClassService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.CapClassView;
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
@Tag(name = "Контроллер для классификатора", description = "Контроллер для получения классификаторов")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class CapClassController {

    static class GridDataOptionCapClass extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                    "<li>capClassTypeId - ИД типа классификатора" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private CapClassService capClassService;

    @Operation(summary = "Возвращает список объектов \"Классификатор\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/capclass/getlist", method = RequestMethod.POST)
    @CheckAnyRole
    public List<CapClassView> getList(@RequestBody GridDataOptionCapClass gridDataOption){
        boolean capClassTypeFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassTypeId".equals(nf.getName()));
        if(!capClassTypeFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("capClassTypeId", -1));
        }
        return capClassService.getAll(gridDataOption);
    }

}
