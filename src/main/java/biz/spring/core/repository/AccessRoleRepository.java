package biz.spring.core.repository;

import biz.spring.core.model.AccessRole;
import biz.spring.core.utils.DatabaseUtils;
import biz.spring.core.view.AccessRoleView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AccessRoleRepository implements TableRepository<AccessRole>{

    private static Logger logger = LoggerFactory.getLogger(AccessRoleRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/100200-accessrole.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("accessrole created");
    }

    @Override
    public void drop(){
        String[] tables = {"accessrole"};
        drop(tables);
    }

    @Override
    public void load(){
        AccessRole[] accessRoles = {
                new AccessRole(1, "SYSDBA", "Системный администратор"),
                new AccessRole(2, "TEST1", "Тестовый пользователь 1"),
                new AccessRole(3, "Test2", "Тестовый пользователь 2")
        };
        insert(Arrays.asList(accessRoles));
        DatabaseUtils.setSequenceValue("accessrole_id_gen", accessRoles.length+1);
    }

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
