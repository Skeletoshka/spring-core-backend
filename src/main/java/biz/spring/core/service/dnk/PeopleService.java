package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.repository.dnk.PeopleRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.PeopleValidator;
import biz.spring.core.view.dnk.PeopleView;
import biz.spring.core.view.dnk.ReportView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PeopleService extends BaseService<People> {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleValidator peopleValidator;

    @PostConstruct
    public void init(){
        init(peopleRepository, peopleValidator);
    }

    @Value("classpath:/script/dnk/people/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/people/mainSqlForOne.sql")
    Resource mainSqlForOne;
    @Value("classpath:/script/dnk/people/reportSql.sql")
    Resource reportSql;

    public List<PeopleView> getAll(GridDataOption gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "workGroupId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<PeopleView>(mainSql)
                .forClass(PeopleView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setLimit(gridDataOption.buildPageRequest())
                .injectSqlIf(capClassFound, "/*CAPCLASS_PLACEHOLDER*/", "AND m0.capclass_id = :capClassId")
                .injectSqlIf(workGroupFound, "/*WORKGROUP_PLACEHOLDER*/", "AND pg.workgroup_id = :workGroupId")
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        boolean workGroupFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "workGroupId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<PeopleView>(mainSql)
                .forClass(PeopleView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(capClassFound, "/*CAPCLASS_PLACEHOLDER*/", "AND m0.capclass_id = :capClassId")
                .injectSqlIf(workGroupFound, "/*WORKGROUP_PLACEHOLDER*/", "AND pg.workgroup_id = :workGroupId")
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .count();
    }

    public PeopleView getOne(Integer id){
        return new Query.QueryBuilder<PeopleView>(mainSqlForOne)
                .forClass(PeopleView.class, "m0")
                .build()
                .executeOne(id);
    }

    public void bindFamily(Integer parentId, Integer childId){
        peopleRepository.bindFamily(parentId, childId);
    }

    public List<ReportView> getReport(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ReportView>(reportSql)
                .forClass(ReportView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public Integer getReportCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ReportView>(reportSql)
                .forClass(ReportView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .count();
    }
}
