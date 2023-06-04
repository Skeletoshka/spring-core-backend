package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.StudentDTO;
import biz.spring.core.model.dnk.People;
import biz.spring.core.model.dnk.Student;
import biz.spring.core.repository.dnk.StudentRepository;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.PeopleService;
import biz.spring.core.service.dnk.StudentService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.PeopleView;
import biz.spring.core.view.dnk.StudentView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@Tag(name = "Контроллер для \"Ученик\"", description = "Контроллер для работы с таблицей \"Ученик\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {
    public static class GridDataOptionStudent extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li>workGroupId - Учебная группа" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Autowired
    private StudentService studentService;
    @Autowired
    private PeopleService peopleService;

    @Operation(summary = "Метод для получения списка объектов \"Ученик\"",
            description = "Выводит список объектов \"Ученик\" согласно переданным фильтрам")
    @RequestMapping(value = "/student/getlist", method = RequestMethod.POST)
    public DataResponse<StudentView> getList(@RequestBody GridDataOptionStudent gridDataOption){
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "workGroupId".equals(nf.getName()));
        if(!workGroupFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("workGroupId", -1));
        }
        gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("capClassId", People.CHILD_ID));
        List<StudentView> result = studentService.getAll(gridDataOption);
        Integer count = studentService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Метод для получения объекта \"Ученик\"",
            description = "Выводит объект \"Ученик\" согласно переданному идентификатора. Если идентификатор пустой, " +
                    "то возвращается объект с заполненными полями по умолчанию")
    @RequestMapping(value = "/student/get", method = RequestMethod.POST)
    public StudentDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            StudentDTO dto = new StudentDTO();
            dto.setPeopleDateDelete(null);
            dto.setPeopleDateBirth(new Date());
            return dto;
        }else{
            StudentView view = studentService.getOne(id);
            StudentDTO dto = new StudentDTO();
            BeanUtils.copyProperties(view, dto);
            return dto;
        }
    }

    @Operation(summary = "Метод для получения сохранения объекта \"Ученик\"",
            description = "Сохраняет объект \"Ученик\". Если идентификатор пустой, то запись добавляется, иначе обновляется")
    @RequestMapping(value = "/student/save", method = RequestMethod.POST)
    public StudentView save(@RequestBody StudentDTO dto){
        Student result;
        if(dto.getStudentId() == null){
            People people = dto.toPeople();
            people.setPeopleDateDelete(null);
            people.setPeopleDeleteFlag(0);
            people = peopleService.add(people);
            dto.setStudentId(people.getPeopleId());
            result = studentService.add(dto.toEntity());
        }else{
            People people = dto.toPeople();
            people.setPeopleDateDelete(null);
            people.setPeopleDeleteFlag(0);
            peopleService.edit(people);
            if(studentService.getOne(dto.getStudentId()).getStudentId() == null){
                result = studentService.add(dto.toEntity());
            }else {
                result = studentService.edit(dto.toEntity());
            }
        }
        return studentService.getOne(result.getStudentId());
    }

    @Operation(summary = "Метод для удаления объектов \"Ученик\"",
            description = "Удаляет список объектов \"Ученик\" согласно переданным идентификаторам")
    @RequestMapping(value = "/student/delete", method = RequestMethod.POST)
    public String delete(@RequestBody int[] ids){
        peopleService.delete(ids);
        studentService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }
}
