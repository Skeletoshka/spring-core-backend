package biz.spring.core.repository;

import biz.spring.core.model.AccessRole;
import biz.spring.core.view.AccessRoleView;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AccessRoleRepository implements TableRepository<AccessRole>{

    public List<AccessRoleView> getRolesForProguserId(Integer proguserId){
        String sql = "" +
                "SELECT AR.* " +
                "FROM accessrole AR " +
                "INNER JOIN proguserrole PUR ON AR.accessrole_id = PUR.accessrole_id " +
                "WHERE PUR.proguser_id = :proguserId";
        return findListForObject(sql, Map.of("proguserId", proguserId), AccessRole.class)
                .stream().map(ar -> {
                    AccessRoleView view = new AccessRoleView();
                    BeanUtils.copyProperties(ar, view);
                    return view;
                }).collect(Collectors.toList());
    }
}
