package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Activity;
import biz.spring.core.repository.dnk.ActivityRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.ActivityValidator;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.dnk.ActivityView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService extends BaseService<Activity> {
    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private ActivityValidator activityValidator;

    @Value("classpath:/script/dnk/activity/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/dnk/activity/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @Override
    protected void init() {
        init(activityRepository, activityValidator);
    }

    public List<ActivityView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ActivityView>(mainSQL)
                .forClass(ActivityView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public ActivityView getOne(Integer id){
        return new Query.QueryBuilder<ActivityView>(mainSQLForOne)
                .forClass(ActivityView.class, "m0")
                .build()
                .executeOne(id);
    }
}
