package biz.spring.core.repository;

import biz.spring.core.model.Answer;
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
import java.util.List;
import java.util.Map;

@Repository
public class AnswerRepository implements TableRepository<Answer> {

    private static Logger logger = LoggerFactory.getLogger(AnswerRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/190400-answer.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("answer created");
    }

    @Override
    public void drop() {
        String[] tables = {"test", "testhistory", "testquestion", "answer"};
        drop(tables);
    }

    @Override
    public void load(){
        Answer[] answers = {
                new Answer(1,1,"Hello",0),
                new Answer(2,1,"World",1),
                new Answer(3,2,"Ped",2)
        };
        insert(Arrays.asList(answers));
        DatabaseUtils.setSequenceValue("answer_id_gen", answers.length+1);
    }


}