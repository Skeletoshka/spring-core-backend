package biz.spring.core.repository;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.ControlObject;
import biz.spring.core.model.Post;
import biz.spring.core.model.ProgUser;
import biz.spring.core.utils.DatabaseUtils;
import biz.spring.core.view.ProgUserView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProgUserRepository implements TableRepository<ProgUser> {

    @Autowired
    AccessRoleRepository accessRoleRepository;

    private static Logger logger = LoggerFactory.getLogger(ProgUserRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/100100-proguser.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("proguser created");
    }

    @Override
    public void drop(){
        String[] tables = {"proguser", "proguserrole", "sqlaction"};
        drop(tables);
    }

    @Override
    public void load(){
        ProgUser[] progUsers = {
                new ProgUser(1, "SYSDBA", "Системный администратор",
                        "$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2", 1, 1),
                new ProgUser(1, "Director", "Директор",
                        "$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2", 1, 2),
                new ProgUser(1, "Metodist", "Методист",
                        "$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2", 1, 3)
        };
        insert(Arrays.asList(progUsers));
        DatabaseUtils.setSequenceValue("proguser_id_gen", progUsers.length+1);
    }

    public ProgUserDTO findByLogin(String login){
        ProgUser progUser = getAll().stream().filter(pu -> pu.getProgUserName().equals(login)).findFirst().orElse(null);
        ProgUserDTO dto = new ProgUserDTO();
        BeanUtils.copyProperties(progUser, dto);
        dto.setAccessRoleViews(accessRoleRepository.getRolesForProguserId(dto.getProgUserId()));
        return dto;
    }
}
