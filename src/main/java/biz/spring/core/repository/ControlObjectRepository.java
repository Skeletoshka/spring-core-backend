package biz.spring.core.repository;

import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ControlObject;
import biz.spring.core.utils.DatabaseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ControlObjectRepository implements TableRepository<ControlObject> {

    private static Logger logger = LoggerFactory.getLogger(ControlObjectRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void bindWithRole(Integer roleId, List<Integer> controlObjectIds){
        String sql = "INSERT INTO controlobjectrole (controlobjectrole_id, accessrole_id, controlobject_id) " +
                "VALUES (:controlobjectrole_id, :accessrole_id, :controlobject_id)";
        Map<String, Object> params = new HashMap<>();
        params.put("accessrole_id", roleId);
        for(Integer id: controlObjectIds){
            params.put("controlobjectrole_id", DatabaseUtils.getSequenceNextValue("controlobjectrole_id_gen"));
            params.put("controlobject_id", id);
            executeSql(sql, params);
        }
    }

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/100300-controlobject.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("controlobject created");
    }

    @Override
    public void drop(){
        String[] tables = {"controlobject", "controlobjectrole"};
        drop(tables);
    }

    @Override
    public void load(){
        ControlObject[] controlObjects = {
                /*Загрузка происходит в InitApp*/
        };
        insert(Arrays.asList(controlObjects));
        DatabaseUtils.setSequenceValue("controlobject_id_gen", controlObjects.length+1);
    }

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
