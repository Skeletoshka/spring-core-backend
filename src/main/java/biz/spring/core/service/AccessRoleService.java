package biz.spring.core.service;

import biz.spring.core.model.AccessRole;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.AccessRoleValidator;
import biz.spring.core.view.AccessRoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AccessRoleService extends BaseService<AccessRole> {

    @Autowired
    private AccessRoleRepository accessRoleRepository;
    @Autowired
    private AccessRoleValidator accessRoleValidator;

    @Override
    @PostConstruct
    public void init() {
        init(accessRoleRepository, accessRoleValidator);
    }

    @Value("classpath:/script/accessrole/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/accessrole/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<AccessRoleView> getAll(GridDataOption gridDataOption){
        boolean visibleFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("accessRoleVisible") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AccessRoleView>(mainSQL)
                .forClass(AccessRoleView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setSearch(gridDataOption.getSearch())
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(visibleFound, "/*VISIBLE_PLACEHOLDER*/", "AND m0.accessrole_visible = :accessRoleVisible")
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean visibleFound = gridDataOption.getNamedFilters().stream()
                .anyMatch(nf -> nf.getName().equals("accessRoleVisible") && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AccessRoleView>(mainSQL)
                .forClass(AccessRoleView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(visibleFound, "/*VISIBLE_PLACEHOLDER*/", "AND m0.accessrole_visible = :accessRoleVisible")
                .build()
                .count();
    }

    public AccessRoleView getOne(Integer id){
        return new Query.QueryBuilder<AccessRoleView>(mainSqlForOne)
                .forClass(AccessRoleView.class, "m0")
                .build()
                .executeOne(id);
    }

}
