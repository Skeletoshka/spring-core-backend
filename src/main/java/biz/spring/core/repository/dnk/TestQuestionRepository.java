package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.TestQuestion;
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
public class TestQuestionRepository implements TableRepository<TestQuestion> {

    private static Logger logger = LoggerFactory.getLogger(TestQuestionRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/190300-testquestion.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("testquestion created");
    }

    @Override
    public void drop() {
        String[] tables = {"testquestion"};
        drop(tables);
    }

    @Override
    public void load(){
        TestQuestion[] testQuestions = {
                new TestQuestion(1,"Столица Великобритании",1),
                new TestQuestion(2,"Президент России",1),
                new TestQuestion(3,"Часовой пояс Китая",2)
        };
        insert(Arrays.asList(testQuestions));
        DatabaseUtils.setSequenceValue("testquestion_id_gen", testQuestions.length+1);
    }


}