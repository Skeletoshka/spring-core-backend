package biz.spring.core.controller.dnk;

import biz.spring.core.annotations.CheckAnyRole;
import biz.spring.core.dto.dnk.PeopleDTO;
import biz.spring.core.model.dnk.People;
import biz.spring.core.service.dnk.PeopleService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.PeopleView;
import io.swagger.v3.oas.annotations.media.Schema;
import org.junit.jupiter.api.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(value = "Контроллер для пользователей")
@RequestMapping(value = "/api/people",
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

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @Tag(value = "Метод для получения списка объектов \"Пользователь\"")
    public List<PeopleView> getList(@RequestBody GridDataOptionPeople gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName()));
        if(!capClassFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("capClassId", -1));
        }
        return peopleService.getAll(gridDataOption);
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    @Tag(value = "Метод для получения объекта \"Пользователь\" по его идентификатору")
    @CheckAnyRole
    public PeopleDTO get(@RequestBody(required = false) int id){
        if(id == 0){
            return new PeopleDTO();
        } else {
            PeopleView view = peopleService.getOne(id);
            PeopleDTO dto = new PeopleDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @Tag(value = "Метод для сохранения объекта \"Пользователь\"")
    public PeopleView save(@RequestBody PeopleDTO peopleDTO){
        People result;
        if(peopleDTO.getPeopleId()==null){
            result = peopleService.add(peopleDTO.toEntity());
        }else{
            result = peopleService.edit(peopleDTO.toEntity());
        }
        return peopleService.getOne(result.getPeopleId());
    }
}
