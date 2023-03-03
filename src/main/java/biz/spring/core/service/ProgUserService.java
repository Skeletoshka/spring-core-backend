package biz.spring.core.service;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ProgUser;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.repository.ProgUserRepository;
import biz.spring.core.security.JwtUtils;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ProgUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
public class ProgUserService extends BaseService<ProgUser>{

    @Autowired
    private ProgUserRepository progUserRepository;

    @PostConstruct
    public void init(){
        init(progUserRepository);
    }

    private final String mainSql = "" +
            "SELECT p " +
            "FROM proguser";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM proguser " +
            "WHERE proguser_id = :id";

    public List<ProgUserView> getAll(GridDataOption gridDataOption){
        return new Query<ProgUserView>(mainSql)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .forClass(ProgUserView.class)
                .execute();
    }

    public ProgUserView getOne(Integer id){
        return new Query<ProgUserView>(mainSqlForOne)
                .forClass(ProgUserView.class)
                .executeOne(id);
    }

    public List<AccessRoleView> getRoleByUserId(Integer userId){
        String sql = "" +
                "SELECT ar.* " +
                "FROM proguserrole pur " +
                    "INNER JOIN accessrole ar ON pur.accessrole_id = pur.accessrole_id " +
                "WHERE pur.proguser_id = :progUserId";
        return (List<AccessRoleView>) findQuery(sql, Map.of("progUserId", userId), AccessRoleView.class);
    }

    public void saveUser(ProgUserDTO progUserDTO){
        progUserDTO.setProgUserId(progUserRepository.insert(progUserDTO.toEntity()));
        progUserRepository.bindWithRoles(progUserDTO.getAccessRoleViews(), progUserDTO.getProgUserId());
        progUserRepository.createToken(progUserDTO.getProgUserId(), JwtUtils.createToken());
    }
}
