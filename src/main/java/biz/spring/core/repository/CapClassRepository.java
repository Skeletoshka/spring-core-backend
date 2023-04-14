package biz.spring.core.repository;

import biz.spring.core.model.CapClass;
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
public class CapClassRepository implements TableRepository<CapClass>{

    private static Logger logger = LoggerFactory.getLogger(CapClassRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/100900-сapclass.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("capclass created");
    }

    @Override
    public void drop() {
        String[] tables = {"capclass"};
        drop(tables);
    }

    @Override
    public void load() {
        CapClass[] capClasses = new CapClass[]{
                new CapClass(1, "Преподаватель", "Преподаёт", 1),
                new CapClass(2, "Учащийся", "Учится", 1),
                new CapClass(3, "Партнёр", "Партнёрирует", 1),
                new CapClass(4, "Методист", "Методирует", 1),
                new CapClass(5, "Тест", "Тестирует", 2)
        };
        insert(Arrays.asList(capClasses));
        DatabaseUtils.setSequenceValue("capclass_id_gen", capClasses.length+1);
    }
}
