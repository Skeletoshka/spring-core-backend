package biz.spring.core.service;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ProgUser;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.repository.ProgUserRepository;
import biz.spring.core.security.JwtUtils;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.ProgUserValidator;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ProgUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProgUserService extends BaseService<ProgUser>{

    @Autowired
    private ProgUserRepository progUserRepository;
    @Autowired
    private ProgUserValidator progUserValidator;

    @PostConstruct
    public void init(){
        init(progUserRepository, progUserValidator);
    }

    @Value("classpath:/script/proguser/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/proguser/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<ProgUserView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ProgUserView>(mainSql)
                .forClass(ProgUserView.class, "m0")
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ProgUserView>(mainSql)
                .forClass(ProgUserView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .build()
                .count();
    }

    public ProgUserView getOne(Integer id){
        return new Query.QueryBuilder<ProgUserView>(mainSqlForOne)
                .forClass(ProgUserView.class, "m0")
                .build()
                .executeOne(id);
    }

    public List<AccessRoleView> getRoleByUserId(Integer userId){
        String sql = "" +
                "SELECT ar.* " +
                "FROM proguserrole pur " +
                    "INNER JOIN accessrole ar ON pur.accessrole_id = ar.accessrole_id " +
                "WHERE pur.proguser_id = :progUserId";
        return (List<AccessRoleView>) findQuery(sql, Map.of("progUserId", userId), AccessRoleView.class);
    }

    public void updateRoles(Integer proguserId, List<AccessRoleView> roles){
        List<AccessRoleView> views = getRoleByUserId(proguserId);
        List<Integer> rolesDelete = views.stream().map(AccessRoleView::getAccessRoleId)
                .filter(accessRoleId ->
                        roles.stream().noneMatch(role -> role.getAccessRoleId().equals(accessRoleId)))
                .collect(Collectors.toList());
        List<Integer> rolesAdd = roles.stream().map(AccessRoleView::getAccessRoleId)
                .filter(accessRoleId ->
                        views.stream().noneMatch(role -> role.getAccessRoleId().equals(accessRoleId)))
                .collect(Collectors.toList());
        progUserRepository.bindWithRoles(rolesAdd, proguserId);
        progUserRepository.unBindWithRoles(rolesDelete, proguserId);
    }

    public void saveUser(ProgUserDTO progUserDTO){
        progUserDTO.setProgUserId(progUserRepository.insert(progUserDTO.toEntity()));
        progUserRepository.bindWithRoles(progUserDTO.getAccessRoleViews().stream()
                .map(AccessRoleView::getAccessRoleId).collect(Collectors.toList()), progUserDTO.getProgUserId());
        progUserRepository.createToken(progUserDTO.getProgUserId(), JwtUtils.createToken());
    }
}
