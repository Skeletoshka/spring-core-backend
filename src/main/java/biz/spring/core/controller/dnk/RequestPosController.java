package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.RequestPosDTO;
import biz.spring.core.model.dnk.RequestPos;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.RequestPosService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.RequestPosView;
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
@Tag(name = "Контроллер для позиций заявки", description = "Контроллер для работы с таблицей \"Позиция заявки\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/request",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class RequestPosController {
    @Autowired
    private RequestPosService requestPosService;

    public static class GridDataOptionRequestPos extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li> requestId - ИД заявки " +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Позиция заявки\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/requestpos/getlist", method = RequestMethod.POST)
    public DataResponse<RequestPosView> getList(@RequestBody GridDataOptionRequestPos gridDataOption){
        List<RequestPosView> result = requestPosService.getAll(gridDataOption);
        Integer count = requestPosService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Возвращает объект \"Позиция заявки\"",
            description = "Вовзращает объект согласно переданному идентификатору. " +
                    "Если идентификатор пуст, то возвращает объект по умолчанию")
    @RequestMapping(value = "/requestpos/get", method = RequestMethod.POST)
    public RequestPosDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new RequestPosDTO();
        }else{
            RequestPosDTO dto = new RequestPosDTO();
            RequestPosView view = requestPosService.getOne(id);
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Сохраняет объект \"Позиция заявки\"",
            description = "Сохраняет объект в базу данных. " +
                    "Если идентификатор пуст, то объект вставляется, иначе обновляется")
    @RequestMapping(value = "/requestpos/save", method = RequestMethod.POST)
    public RequestPosView save(@RequestBody RequestPosDTO dto){
        RequestPos result;
        if(dto.getRequestPosId() == null){
            result = requestPosService.add(dto.toEntity());
        }else{
            result = requestPosService.edit(dto.toEntity());
        }
        return requestPosService.getOne(result.getRequestPosId());
    }

    @Operation(summary = "Удаляет объекты \"Позиция заявки\"",
            description = "Удаляет объекты с переданными идентификаторами")
    @RequestMapping(value = "/requestpos/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        requestPosService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

}
