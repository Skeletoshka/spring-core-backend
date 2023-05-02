package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Attendance;
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
public class AttendanceRepository implements TableRepository<Attendance> {

    private static Logger logger = LoggerFactory.getLogger(AttendanceRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100700-attendance.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("attendance created");
    }

    @Override
    public void drop() {
        String[] tables = {"attendance"};
        drop(tables);
    }

    @Override
    public void load() {
        Attendance[] attendances = new Attendance[]{
                new Attendance(1, 1, 1, 1),
                new Attendance(2, 1, 2, 0),
                new Attendance(3, 2, 1, 1),
                new Attendance(4, 1, 3, 0),
                new Attendance(5, 2, 2, 1),
                new Attendance(6, 2, 3, 0),
                new Attendance(7, 2, 4, 0),
                new Attendance(8, 1, 4, 1)
        };
        insert(Arrays.asList(attendances));
        DatabaseUtils.setSequenceValue("attendance_id_gen", attendances.length+1);
    }
}
