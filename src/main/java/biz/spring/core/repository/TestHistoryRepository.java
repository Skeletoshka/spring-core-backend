package biz.spring.core.repository;

import biz.spring.core.model.Answer;
import biz.spring.core.model.ControlObject;
import biz.spring.core.model.Test;
import biz.spring.core.model.TestHistory;
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
public class TestHistoryRepository implements TableRepository<TestHistory> {

    private static Logger logger = LoggerFactory.getLogger(TestHistoryRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/190500-testhistory.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("testhistory created");
    }

    @Override
    public void drop() {
        String[] tables = {"test", "testhistory", "testquestion", "answer"};
        drop(tables);
    }

    @Override
    public void load(){
        TestHistory[] testHistories = {
                new TestHistory(1,1,1,1),
                new TestHistory(2,1,2,2),
                new TestHistory(3,2,1,4),
        };
        insert(Arrays.asList(testHistories));
        DatabaseUtils.setSequenceValue("testhistory_id_gen", testHistories.length+1);
    }


}