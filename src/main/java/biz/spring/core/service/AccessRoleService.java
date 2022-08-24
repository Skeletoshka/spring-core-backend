package biz.spring.core.service;

import biz.spring.core.model.AccessRole;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AccessRoleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessRoleService extends BaseService<AccessRole> {

    @Autowired
    private AccessRoleRepository accessRoleRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM accessrole";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM accessrole " +
            "WHERE accessrole_id = :id";

    public List<AccessRoleView> getAll(){
        return new Query<AccessRoleView>(mainSql)
                .forClass(AccessRoleView.class)
                .execute();
    }

    public AccessRoleView getOne(Integer id){
        return new Query<AccessRoleView>(mainSqlForOne)
                .forClass(AccessRoleView.class)
                .executeOne(id);
    }

    public void save(AccessRole accessRole){
        accessRoleRepository.insert(accessRole);
    }
}
