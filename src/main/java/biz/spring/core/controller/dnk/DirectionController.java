package biz.spring.core.controller.dnk;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.DirectionDTO;
import biz.spring.core.model.dnk.Direction;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.DirectionService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.DirectionView;
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
@Tag(name = "Контроллер для ролей", description = "Контроллер для работы с таблицей \"Направление\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/refbooks",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class DirectionController {

    static class GridDataOptionDirection extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Autowired
    private DirectionService directionService;

    @Operation(summary = "Возвращает список объектов \"Направление\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/direction/getlist", method = RequestMethod.POST)
    public List<DirectionView> getList(@RequestBody GridDataOptionDirection gridDataOption){
        return directionService.getAll(gridDataOption);
    }

    @RequestMapping(value = "/direction/get", method = RequestMethod.POST)
    @Operation(summary = "Возвращает объект \"Направление\"",
            description = "Вовзращает объект \"Направление\" по его идентификатору. Если идентификатора нет - " +
                    "возвращается объект с полями по умолчанию")
    public DirectionDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new DirectionDTO();
        } else {
            DirectionView view = directionService.getOne(id);
            DirectionDTO dto = new DirectionDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/direction/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Направление\"",
            description = "Запись с заполненным идентификатором обновляется, с пустым - вставляется")
    public DirectionView save(@RequestBody DirectionDTO directionDTO){
        Direction direction;
        if(directionDTO.getDirectionId()==null){
            direction = directionService.add(directionDTO.toEntity());
        }else {
            direction = directionService.edit(directionDTO.toEntity());
        }
        return directionService.getOne(direction.getDirectionId());
    }

    @RequestMapping(value = "/direction/delete", method = RequestMethod.POST)
    @Operation(summary = "Метод для удаления объекта \"Направление\"",
            description = "Удаляются записи с переданными идентификаторами")
    public String delete(@RequestBody int[] ids){
        directionService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
