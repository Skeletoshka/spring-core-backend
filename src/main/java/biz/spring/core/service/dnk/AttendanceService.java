package biz.spring.core.service.dnk;

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
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("studyProgramId") && !nf.getValue().equals(-1));
        boolean scheduleDateFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("scheduleDate") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AttendanceView>(mainSQL)
                .forClass(AttendanceView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(peopleFound, "/*PEOPLE_PLACEHOLDER*/", "AND m0.people_id = :peopleId")
                .injectSqlIf(studyProgramFound, "/*STUDYPROGRAM_PLACEHOLDER*/", "AND sh.studyprogram_id = :studyProgramId")
                .injectSqlIf(scheduleDateFound, "/*SCHEDULE_PLACEHOLDER*/", "AND sh.shedule_date = :scheduleDate")
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean peopleFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("peopleId") && !nf.getValue().equals(-1));
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("studyProgramId") && !nf.getValue().equals(-1));
        boolean scheduleDateFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("scheduleDate") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AttendanceView>(mainSQL)
                .forClass(AttendanceView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(peopleFound, "/*PEOPLE_PLACEHOLDER*/", "AND m0.people_id = :peopleId")
                .injectSqlIf(studyProgramFound, "/*STUDYPROGRAM_PLACEHOLDER*/", "AND sh.studyprogram_id = :studyProgramId")
                .injectSqlIf(scheduleDateFound, "/*SCHEDULE_PLACEHOLDER*/", "AND sh.shedule_date = :scheduleDate")
                .build()
                .count();
    }

    public AttendanceView getOne(Integer id){
        return new Query.QueryBuilder<AttendanceView>(mainSQLForOne)
                .forClass(AttendanceView.class, "m0")
                .build()
                .executeOne(id);
    }
}
