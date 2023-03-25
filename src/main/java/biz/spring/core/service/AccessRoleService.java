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
        return new Query<AccessRoleView>(mainSQL)
                .forClass(AccessRoleView.class)
                .execute();
    }

    public AccessRoleView getOne(Integer id){
        return new Query<AccessRoleView>(mainSqlForOne)
                .forClass(AccessRoleView.class)
                .executeOne(id);
    }

}
