package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.repository.TableRepository;
import biz.spring.core.utils.DatabaseUtils;
import biz.spring.core.view.dnk.PeopleView;
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
import java.util.stream.Collectors;

@Repository
public class PeopleRepository implements TableRepository<People> {

    private static Logger logger = LoggerFactory.getLogger(PeopleRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void bindFamily(Integer parentId, Integer childId){
        String sql = "INSERT INTO \"family\" (family_id, parent_id, child_id) VALUES (:family_id, :parent_id, :child_id)";
        Map<String, Object> params = new HashMap<>();
        params.put("parent_id", parentId);
        params.put("child_id", childId);
        params.put("family_id", DatabaseUtils.getSequenceNextValue("family_id_gen"));
        executeSql(sql, params);
    }

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/dnk/200200-people.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("people created");
    }

    @Override
    public void drop(){
        String[] tables = {"people", "family"};
        drop(tables);
    }

    @Override
    public void load(){
        People[] people = {
                new People(1, "Иван", "Иванов", "Иванович",
                        new Date(), 1, "test@mail.ru", "89999999999", 0, null, null),
                new People(2, "Петр", "Петров", "Петрович",
                        new Date(), 2, "test123@mail.ru", "89999999999", 0, null, null),
                new People(3, "Салимов", "Сергей", "Пушкович",
                        new Date(), 1, "test321@mail.ru", "89999999999", 1, new Date(), null)
        };
        insert(Arrays.asList(people));
        DatabaseUtils.setSequenceValue("people_id_gen", people.length+1);
    }
}
