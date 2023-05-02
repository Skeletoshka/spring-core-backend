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
        return new Query.QueryBuilder<AttendanceView>(mainSQL)
                .forClass(AttendanceView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<AttendanceView>(mainSQL)
                .forClass(AttendanceView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
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
