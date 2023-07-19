package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.FamilyDTO;
import biz.spring.core.dto.dnk.PeopleDTO;
import biz.spring.core.model.dnk.People;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.PeopleService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.PeopleView;
import biz.spring.core.view.dnk.ReportView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Контроллер для \"Человек\"", description = "Контроллер для работы с таблицей \"Человек\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class PeopleController {

    public static class GridDataOptionPeople extends GridDataOption{
        @Schema(description = "" +
                "<ul>" +
                    "<li>capClassId - Классификатор" +
                    "<li>workGroupId - Учебная группа" +
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
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "workGroupId".equals(nf.getName()));
        if(!workGroupFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("workGroupId", -1));
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

    @Operation(summary = "Метод для создания объекта \"Семья\"",
            description = "Связывает родителя и ребенка, образуя запись в таблице \"Семья\"")
    @RequestMapping(value = "/people/bind", method = RequestMethod.POST)
    public String bind(@RequestBody FamilyDTO dto){
        PeopleView peopleView = peopleService.getOne(dto.getParentId());
        if(!peopleView.getCapClassId().equals(People.PARENT_ID)){
            throw new RuntimeException("Не верно выбран родитель");
        }
        peopleView = peopleService.getOne(dto.getChildId());
        if(!peopleView.getCapClassId().equals(People.CHILD_ID)){
            throw new RuntimeException("Не верно выбран ребёнок");
        }
        peopleService.bindFamily(dto.getParentId(), dto.getChildId());
        return BaseService.STANDARD_SUCCESS;
    }

    public static class GridDataOptionReport extends GridDataOption{
        @Schema(description = "" +
                "<ul>" +
                    "<li> studyProgramId - программа обучения" +
                    "<li> workGroupId - группа" +
                    "<li> companyId - образовательная организация" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @RequestMapping(value = "/report/getlist", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения отчета",
            description = "Выводит отчет согласно переданным фильтрам")
    public DataResponse<ReportView> getReport(@RequestBody GridDataOptionReport gridDataOption){
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("studyProgramId"));
        if(!studyProgramFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("studyProgramId", -1));
        }
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("workGroupId"));
        if(!workGroupFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("workGroupId", -1));
        }
        boolean companyFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("companyId"));
        if(!companyFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("companyId", -1));
        }
        List<ReportView> result = peopleService.getReport(gridDataOption);
        Integer count = peopleService.getReportCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }
}
