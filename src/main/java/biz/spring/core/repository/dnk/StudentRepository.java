package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Student;
import biz.spring.core.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository implements TableRepository<Student> {

    private static Logger logger = LoggerFactory.getLogger(StudentRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100500-student.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("student created");
    }

    @Override
    public void drop() {
        String[] tables = {"student"};
        drop(tables);
    }

    @Override
    public void load() {
        Student[] students = new Student[]{
                new Student(1, "11A", "Пермский", 1),
                new Student(2, "10A", "Пермский", 2),
                new Student(3, "11A", "Пермский", 3)

        };
    }
}
