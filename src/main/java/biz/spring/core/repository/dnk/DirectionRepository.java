package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Direction;
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
public class DirectionRepository implements TableRepository<Direction> {

    private static Logger logger = LoggerFactory.getLogger(DirectionRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100100-direction.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("direction created");
    }

    @Override
    public void drop() {
        String[] tables = {"direction"};
        drop(tables);
    }

    @Override
    public void load() {
        Direction[] directions = {
                new Direction(1, "Информатика", null),
                new Direction(2, "Математика", null),
                new Direction(3, "Физика", null),
                new Direction(4, "Литература", null),
                new Direction(5, "Русский язык", null)
        };
        insert(Arrays.asList(directions));
        DatabaseUtils.setSequenceValue("direction_id_gen", directions.length+1);
    }
}
