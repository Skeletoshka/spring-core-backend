package biz.spring.core.service;

import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ProgUser;
import biz.spring.core.repository.ProgUserRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ProgUserView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgUserService extends BaseService<ProgUser>{

    private ProgUserRepository progUserRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM proguser";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM proguser " +
            "WHERE proguser_id = :id";

    public List<ProgUserView> getAll(){
        return new Query<ProgUserView>(mainSql)
                .forClass(ProgUserView.class)
                .execute();
    }

    public ProgUserView getOne(Integer id){
        return new Query<ProgUserView>(mainSqlForOne)
                .forClass(ProgUserView.class)
                .executeOne(id);
    }

    public void save(ProgUser progUser){
        progUserRepository.insert(progUser);
    }
}
