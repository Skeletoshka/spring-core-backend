package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.PeopleDTO;
import biz.spring.core.model.dnk.People;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.PeopleService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.PeopleView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Tag(value = "Контроллер для пользователей")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleController {

    public static class GridDataOptionPeople extends GridDataOption{
        @Schema(description = "" +
                "<ul>" +
                    "<li>capClassId - Классификатор" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "/people/getlist", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения списка объектов \"Человек\"",
            description = "Выводит список объектов \"Человек\" согласно переданным фильтрам")
    public DataResponse<PeopleView> getList(@RequestBody GridDataOptionPeople gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName()));
        if(!capClassFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("capClassId", -1));
        }
        List<PeopleView> result = peopleService.getAll(gridDataOption);
        Integer count = peopleService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @RequestMapping(value = "/people/get", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения объекта \"Человек\"",
            description = "Выводит объект \"Человек\" согласно переданному идентификатора. Если идентификатор пустой, " +
                    "то возвращается объект с заполненными полями по умолчанию")
    public PeopleDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            PeopleDTO dto = new PeopleDTO();
            dto.setPeopleDateDelete(null);
            dto.setPeopleDateBirth(new Date());
            return dto;
        } else {
            PeopleView view = peopleService.getOne(id);
            PeopleDTO dto = new PeopleDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/people/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения сохранения объекта \"Человек\"",
            description = "Сохраняет объект \"Человек\". Если идентификатор пустой, то запись добавляется, иначе обновляется")
    public PeopleView save(@RequestBody PeopleDTO peopleDTO){
        People result;
        if(peopleDTO.getPeopleId()==null){
            peopleDTO.setPeopleDateDelete(null);
            peopleDTO.setPeopleDeleteFlag(null);
            peopleDTO.setPeopleDeleteFlag(0);
            result = peopleService.add(peopleDTO.toEntity());
        }else{
            peopleDTO.setPeopleDeleteFlag(null);
            peopleDTO.setPeopleDeleteFlag(0);
            result = peopleService.edit(peopleDTO.toEntity());
        }
        return peopleService.getOne(result.getPeopleId());
    }

    @RequestMapping(value = "/people/delete", method = RequestMethod.POST)
    @Operation(summary = "Метод для удаления объектов \"Человек\"",
            description = "Удаляет список объектов \"Человек\" согласно переданным идентификаторам")
    public String delete(@RequestBody int[] ids){
        peopleService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
