package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Test;
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

@Repository
public class TestRepository implements TableRepository<Test> {

    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/190200-test.sql");
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
        insert(Arrays.asList(tests));
        DatabaseUtils.setSequenceValue("test_id_gen", tests.length+1);
    }


}