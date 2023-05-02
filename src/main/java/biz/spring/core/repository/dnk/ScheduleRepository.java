package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Schedule;
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
public class ScheduleRepository implements TableRepository<Schedule> {

    private static Logger logger = LoggerFactory.getLogger(ScheduleRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100800-schedule.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("request created");
    }

    @Override
    public void drop() {
        String[] tables = {"schedule"};
        drop(tables);
    }

    @Override
    public void load() {
        Schedule[] schedules = new Schedule[]{
                new Schedule(1, 1, 1, "A307", new Date()),
                new Schedule(2, 1, 1, "A306", new Date()),
                new Schedule(3, 2, 2, "A305", new Date()),
                new Schedule(4, 1, 1, "A304", new Date()),
                new Schedule(5, 2, 2, "A303", new Date()),
                new Schedule(6, 2, 1, "A302", new Date()),
                new Schedule(7, 1, 2, "A301", new Date())
        };
        insert(Arrays.asList(schedules));
        DatabaseUtils.setSequenceValue("activity_id_gen", schedules.length+1);
    }
}
