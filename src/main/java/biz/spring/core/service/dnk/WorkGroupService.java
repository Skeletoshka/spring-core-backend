package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.WorkGroup;
import biz.spring.core.repository.dnk.WorkGroupRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.WorkGroupValidator;
import biz.spring.core.view.dnk.WorkGroupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class WorkGroupService extends BaseService<WorkGroup> {

    @Autowired
    private WorkGroupRepository workGroupRepository;
    @Autowired
    private WorkGroupValidator workGroupValidator;

    @Value("classpath:/script/dnk/workgroup/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/workgroup/mainSqlForOne.sql")
    Resource mainSqlForOne;

    @PostConstruct
    public void init() { init(workGroupRepository, workGroupValidator); }

    public List<WorkGroupView> getAll(GridDataOption gridDataOption){
        boolean directionFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("directionId") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<WorkGroupView>(mainSql)
                .forClass(WorkGroupView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(directionFound, "/*DIRECTION_PLACEHOLDER*/", "AND DIR.direction_id = :directionId")
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean directionFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("directionId") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<WorkGroupView>(mainSql)
                .forClass(WorkGroupView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(directionFound, "/*DIRECTION_PLACEHOLDER*/", "AND DIR.direction_id = :directionId")
                .build()
                .count();
    }

    public WorkGroupView getOne(Integer id){
        return new Query.QueryBuilder<WorkGroupView>(mainSqlForOne)
                .forClass(WorkGroupView.class, "m0")
                .build()
                .executeOne(id);
    }
}
