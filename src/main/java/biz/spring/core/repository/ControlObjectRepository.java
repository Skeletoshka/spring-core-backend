package biz.spring.core.repository;

import biz.spring.core.model.ControlObject;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ControlObjectRepository implements TableRepository<ControlObject> {

    public List<ControlObject> getAccessControlObject(String proguserName){
        String sql = String.join("\n",
                "SELECT DISTINCT CO.controlobject_id, ",
                "       CO.*",
                "FROM   controlobjectrole COR ",
                "       INNER JOIN controlobject CO ON COR.controlobject_id = CO.controlobject_id ",
                "       INNER JOIN proguserrole PUR ON COR.accessrole_id = PUR.accessrole_id ",
                "       INNER JOIN proguser PU ON PUR.proguser_id = PU.proguser_id ",
                "WHERE  PU.proguser_name = :proguser_name");
        Map<String, Object> params = Map.of("proguser_name", proguserName);
        return findListForObject(sql, params, ControlObject.class);
    }
}
