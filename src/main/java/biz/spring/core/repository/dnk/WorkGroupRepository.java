package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.WorkGroup;
import biz.spring.core.repository.TableRepository;
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
import java.util.Map;

@Repository
public class WorkGroupRepository implements TableRepository<WorkGroup> {
    private static Logger logger = LoggerFactory.getLogger(WorkGroupRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void bindWithPeople(Integer workGroupId, Integer peopleId){
        String sql = "INSERT INTO peoplegroup (peoplegroup_id, people_id, workgroup_id) " +
                "VALUES (:peoplegroup_id, :people_id, :workgroup_id)";
        Map<String, Object> params = new HashMap<>();
        params.put("peoplegroup_id", DatabaseUtils.getSequenceNextValue("peoplegroup_id_gen"));
        params.put("people_id", peopleId);
        params.put("workGroupId", workGroupId);
        executeSql(sql, params);
    }

    public void unBindWithPeople(Integer workGroupId, Integer peopleId){
        String sql = "DELETE FROM peoplegroup WHERE  people_id = :people_id AND workgroup_id = :workgroup_id";
        Map<String, Object> params = new HashMap<>();
        params.put("people_id", peopleId);
        params.put("workGroupId", workGroupId);
        executeSql(sql, params);
    }

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/dnk/200600-workgroup.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("workgroup created");
    }

    @Override
    public void drop(){
        String[] tables = {"workgroup", "peoplegroup"};
        drop(tables);
    }

    public void load(){
        WorkGroup[] workGroups = {
                new WorkGroup(1, "1347", 1, "Группа 1347"),
                new WorkGroup(2, "1211", 2, "Группа 1211"),
                new WorkGroup(3, "1213", 2, "Группа 1213"),
                new WorkGroup(4, "1411", 1, "Группа 1411"),
                new WorkGroup(5, "1212", 1, "Группа 1212"),
                new WorkGroup(6, "947", 2, "Группа 947"),
                new WorkGroup(7, "912", 2, "Группа 912"),
                new WorkGroup(8, "917", 1, "Группа 917")
        };
        insert(Arrays.asList(workGroups));
        DatabaseUtils.setSequenceValue("workgroup_id_gen", workGroups.length+1);
    }
}
