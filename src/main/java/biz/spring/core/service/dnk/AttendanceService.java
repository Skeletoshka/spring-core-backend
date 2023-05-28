package biz.spring.core.service.dnk;

import biz.spring.core.dto.dnk.AttendanceDTO;
import biz.spring.core.model.dnk.Attendance;
import biz.spring.core.repository.dnk.AttendanceRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.AttendanceValidator;
import biz.spring.core.view.dnk.AttendanceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AttendanceService extends BaseService<Attendance> {
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private AttendanceValidator attendanceValidator;

    @Value("classpath:/script/dnk/attendance/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/dnk/attendance/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @PostConstruct
    protected void init() {
        super.init(attendanceRepository, attendanceValidator);
    }

    public List<AttendanceView> getAll(GridDataOption gridDataOption){
        boolean peopleFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("peopleId") && !nf.getValue().equals(-1));
        boolean scheduleId = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("scheduleId") && !nf.getValue().equals(-1));
        boolean workGroupId = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("workGroupId") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AttendanceView>(mainSQL)
                .forClass(AttendanceView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(peopleFound, "/*PEOPLE_PLACEHOLDER*/", "AND p.people_id = :peopleId")
                .injectSqlIf(scheduleId, "/*SCHEDULE_PLACEHOLDER*/", "AND sh.schedule_id = :scheduleId")
                .injectSqlIf(workGroupId, "/*WORKGROUP_PLACEHOLDER*/", "AND wg.workgroup_id = :workGroupId")
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean peopleFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("peopleId") && !nf.getValue().equals(-1));
        boolean scheduleId = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("scheduleId") && !nf.getValue().equals(-1));
        boolean workGroupId = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("workGroupId") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AttendanceView>(mainSQL)
                .forClass(AttendanceView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(peopleFound, "/*PEOPLE_PLACEHOLDER*/", "AND p.people_id = :peopleId")
                .injectSqlIf(scheduleId, "/*SCHEDULE_PLACEHOLDER*/", "AND sh.schedule_id = :scheduleId")
                .injectSqlIf(workGroupId, "/*WORKGROUP_PLACEHOLDER*/", "AND wg.workgroup_id = :workGroupId")
                .build()
                .count();
    }

    public AttendanceView getOne(Integer id){
        return new Query.QueryBuilder<AttendanceView>(mainSQLForOne)
                .forClass(AttendanceView.class, "m0")
                .build()
                .executeOne(id);
    }

    /**Метод сохранения посещаемости
     * @param scheduleId занятие
     * @param dtos посещаемость занятия учениками. В учет идет 2 поля - peopleId, attendancePresenceFlag*/
    public void saveAttendance(Integer scheduleId, List<AttendanceDTO> dtos){
        attendanceRepository.deleteAttendances(scheduleId);
        dtos.stream().forEach(dto -> {
            attendanceRepository.saveAttendance(scheduleId, dto.getPeopleId(), dto.getAttendancePresenceFlag());
        });
    }

}
