package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Schedule;
import biz.spring.core.repository.dnk.ScheduleRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.ScheduleValidator;
import biz.spring.core.view.dnk.ScheduleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ScheduleService extends BaseService<Schedule> {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleValidator scheduleValidator;

    @Value("classpath:/script/dnk/schedule/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/dnk/schedule/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @PostConstruct
    protected void init() {
        super.init(scheduleRepository, scheduleValidator);
    }

    public List<ScheduleView> getAll(GridDataOption gridDataOption){
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("studyProgramId") && !nf.getValue().equals(-1));
        boolean workGroupFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("workGroupId") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<ScheduleView>(mainSQL)
                .forClass(ScheduleView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(studyProgramFound, "/*STUDYPROGRAM_PLACEHOLDER*/", "AND m0.studyprogram_id = :studyProgramId")
                .injectSqlIf(workGroupFound, "/*WORKGROUP_PLACEHOLDER*/", "AND m0.workgroup_id = :workGroupId")
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean studyProgramFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("studyProgramId") && !nf.getValue().equals(-1));
        boolean workGroupFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("workGroupId") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<ScheduleView>(mainSQL)
                .forClass(ScheduleView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(studyProgramFound, "/*STUDYPROGRAM_PLACEHOLDER*/", "AND m0.studyprogram_id = :studyProgramId")
                .injectSqlIf(workGroupFound, "/*WORKGROUP_PLACEHOLDER*/", "AND m0.workgroup_id = :workGroupId")
                .build()
                .count();
    }

    public ScheduleView getOne(Integer id){
        return new Query.QueryBuilder<ScheduleView>(mainSQLForOne)
                .forClass(ScheduleView.class, "m0")
                .build()
                .executeOne(id);
    }

}
