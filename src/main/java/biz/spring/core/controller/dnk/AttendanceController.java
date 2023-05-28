package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.dto.dnk.AttendanceDTO;
import biz.spring.core.model.dnk.Attendance;
import biz.spring.core.response.DataResponse;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.dnk.AttendanceService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.dnk.AttendanceView;
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
@Tag(name = "Контроллер для Посещаемости", description = "Контроллер для работы с таблицей \"Посещаемость\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/dnk/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    public static class GridDataOptionAttendance extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<li> peopleId - ИД человека " +
                "<li> scheduleId - ИД занятия " +
                "<li> workGroupId - ИД группы" +
                "</ul>")
        public List<NamedFilter> getNamedFilters() {
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Посещаемость\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/attendance/getlist", method = RequestMethod.POST)
    public DataResponse<AttendanceView> getList(@RequestBody GridDataOptionAttendance gridDataOption){
        boolean peopleFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("peopleId"));
        if(!peopleFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("peopleId", -1));
        }
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("workGroupId"));
        if(!workGroupFound){
            gridDataOption.getNamedFilters().add(new GridDataOption.NamedFilter("workGroupId", -1));
        }
        boolean scheduleId = gridDataOption.getNamedFilters().stream().anyMatch(nf -> nf.getName().equals("scheduleId"));
        if(!scheduleId){
            throw new RuntimeException("Требуется обязательный фильтр по занятию");
        }
        List<AttendanceView> result = attendanceService.getAll(gridDataOption);
        Integer count = attendanceService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @Operation(summary = "Сохраняет объект \"Посещаемость\"",
            description = "Сохраняет объект в базу данных. " +
                    "Если идентификатор пуст, то объект вставляется, иначе обновляется")
    @RequestMapping(value = "/attendance/save", method = RequestMethod.POST)
    public String save(@RequestBody AttendanceSaveDTO dto){
        attendanceService.saveAttendance(dto.scheduleId, dto.attendances);
        return BaseService.STANDARD_SUCCESS;
    }

    private static class AttendanceSaveDTO{
        @Schema(description = "ИД занятия")
        private Integer scheduleId;

        @Schema(description = "Посещаемость занятия")
        private List<AttendanceDTO> attendances;

        public AttendanceSaveDTO() {
        }

        public AttendanceSaveDTO(Integer scheduleId,
                                 List<AttendanceDTO> attendances) {
            this.scheduleId = scheduleId;
            this.attendances = attendances;
        }

        public Integer getScheduleId() {
            return scheduleId;
        }

        public void setScheduleId(Integer scheduleId) {
            this.scheduleId = scheduleId;
        }

        public List<AttendanceDTO> getAttendances() {
            return attendances;
        }

        public void setAttendances(List<AttendanceDTO> attendances) {
            this.attendances = attendances;
        }
    }
}
