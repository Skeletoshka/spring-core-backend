package biz.spring.core.repository;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.ProgUser;
import biz.spring.core.payload.response.JwtResponse;
import biz.spring.core.utils.DatabaseUtils;
import biz.spring.core.view.AccessRoleView;
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

import java.util.*;

@Repository
public class ProgUserRepository implements TableRepository<ProgUser> {

    @Autowired
    AccessRoleRepository accessRoleRepository;

    private static Logger logger = LoggerFactory.getLogger(ProgUserRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void bindWithRoles(List<Integer> views, Integer proguserId){
        String sql = "INSERT INTO proguserrole VALUES (:proguserrole_id, :proguser_id, :accessrole_id)";
        views.forEach(view -> {
            executeSql(sql, Map.of(
                    "proguserrole_id", DatabaseUtils.getSequenceNextValue("proguserrole_id_gen"),
                    "proguser_id", proguserId,
                    "accessrole_id", view));
        });
    }

    public void unBindWithRoles(List<Integer> views, Integer proguserId){
        String sql = "DELETE FROM proguserrole WHERE proguser_id = :proguser_id AND accessrole_id = :accessrole_id)";
        views.forEach(view -> {
            executeSql(sql, Map.of(
                    "proguser_id", proguserId,
                    "accessrole_id", view));
        });
    }

    public void createToken(Integer progUserId, String token){
        String sql = "INSERT INTO proguserauth VALUES (:proguserauth_id, :proguserauth_create, :proguserauth_token, :proguser_id)";
        Map<String, Object> params = Map.of(
                "proguserauth_id", DatabaseUtils.getSequenceNextValue("proguserauth_id_gen"),
                "proguserauth_create", new Date(),
                "proguserauth_token", token,
                "proguser_id", progUserId);
        executeSql(sql, params);
    }


    public String getUsernameByToken(String token){
        String sql = "" +
                "SELECT PU.proguser_name " +
                "FROM proguserauth PUA " +
                "INNER JOIN proguser PU ON PUA.proguser_id = PU.proguser_id " +
                "WHERE PUA.proguserauth_token = :token";
        return findForObject(sql, Map.of("token", token), ProgUserView.class).getProgUserName();
    }

    public String getTokenByUsername(String username){
        String sql = "" +
                "SELECT PUA.proguserauth_token " +
                "FROM proguserauth PUA " +
                "INNER JOIN proguser PU ON PUA.proguser_id = PU.proguser_id " +
                "WHERE PU.proguser_name = :username";
        return findForObject(sql, Map.of("username", username), JwtResponse.class).getToken();
    }

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
        String[] tables = {"proguser", "proguserrole", "proguserauth"};
        drop(tables);
    }

    @Override
    public void load(){
        ProgUser[] progUsers = {
                new ProgUser(2, "Director", "Директор",
                        "$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2", 1, 2),
                new ProgUser(3, "Metodist", "Методист",
                        "$2a$10$JtM6dcdfqqBAO1Gscq.JP.SliEMX3.tY.7PvSNh1NJmFb.kQipye2", 1, 3)
        };
        insert(Arrays.asList(progUsers));
        DatabaseUtils.setSequenceValue("proguser_id_gen", progUsers.length+1);
    }

    public ProgUserDTO findByLogin(String login){
        ProgUser progUser = getAll().stream().filter(pu -> pu.getProgUserName().equals(login)).findFirst().orElse(null);
        ProgUserDTO dto = new ProgUserDTO();
        if(progUser != null) {
            BeanUtils.copyProperties(progUser, dto);
            dto.setAccessRoleViews(accessRoleRepository.getRolesForProguserId(dto.getProgUserId()));
            return dto;
        }else{
            return null;
        }
    }
}
