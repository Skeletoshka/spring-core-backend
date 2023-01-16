package biz.spring.core.repository;

import biz.spring.core.model.ControlObject;
import biz.spring.core.model.PeopleTest;
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
public class PeopleTestRepository implements TableRepository<PeopleTestRepository> {

    private static Logger logger = LoggerFactory.getLogger(PeopleTestRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/190100-peopletest.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("peopletest created");
    }

    @Override
    public void drop() {
        String[] tables = {"peopletest","test"};
        drop(tables);
    }

    @Override
    public void load(){
        PeopleTest[] peopleTests = {
                new PeopleTest(1,1,1),
                new PeopleTest(1,1,2),
                new PeopleTest(1,2,1)
        };
        //insert(Arrays.asList(peopleTests));
        DatabaseUtils.setSequenceValue("peopletest_id_gen", peopleTests.length+1);
    }


}