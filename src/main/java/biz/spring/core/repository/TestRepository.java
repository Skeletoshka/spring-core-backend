package biz.spring.core.repository;

import biz.spring.core.model.Test;
import biz.spring.core.model.ControlObject;
import biz.spring.core.model.TestQuestion;
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
import java.util.List;
import java.util.Map;

@Repository
public class TestRepository implements TableRepository<TestRepository> {

    private static Logger logger = LoggerFactory.getLogger(TestRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/190200-test.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("test created");
    }

    @Override
    public void drop() {
        String[] tables = {"test"};
        drop(tables);
    }

    @Override
    public void load(){
        Test[] tests = {
                new Test(1,"Столицы","выбрать верную столицу"),
                new Test(2,"Президенты","выбрать верного президента страны"),
                new Test(3,"Программирование","найти ошибку в коде")
        };
        //insert(Arrays.asList(test));
        DatabaseUtils.setSequenceValue("test_id_gen", tests.length+1);
    }


}