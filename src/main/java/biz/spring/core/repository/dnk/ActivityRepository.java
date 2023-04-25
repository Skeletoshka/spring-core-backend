package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Activity;
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
import java.util.Date;

@Repository
public class ActivityRepository implements TableRepository<Activity> {
    private static Logger logger = LoggerFactory.getLogger(ActivityRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100200-activity.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("activity created");
    }

    @Override
    public void drop() {
        String[] tables = {"activity"};
        drop(tables);
    }

    @Override
    public void load() {
        Activity[] activities = new Activity[]{
                new Activity(1, 1 ,1, 1, "Встреча выпускников", new Date(), 1),
                new Activity(2, 2 ,2, 2, "Встреча студентов", new Date(), 1),
                new Activity(3, 3 ,3, 3, "Очумелые ручки", new Date(), 2),
                new Activity(4, 4 ,4, 4, "Отдам в добрые руки", new Date(), 1),
                new Activity(5, 5 ,5, 1, "Рога на копытах", new Date(), 2),
                new Activity(6, 6 ,1, 2, "Копыта в рогах", new Date(), 2)
        };
        insert(Arrays.asList(activities));
        DatabaseUtils.setSequenceValue("activity_id_gen", activities.length+1);
    }
}
