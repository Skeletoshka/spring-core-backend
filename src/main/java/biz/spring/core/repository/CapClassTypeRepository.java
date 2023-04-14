package biz.spring.core.repository;

import biz.spring.core.model.CapClassType;
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
public class CapClassTypeRepository implements TableRepository<CapClassType>{

    private static Logger logger = LoggerFactory.getLogger(CapClassTypeRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/200100-сapclasstype.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("capclasstype created");
    }

    @Override
    public void drop() {
        String[] tables = {"capclasstype"};
        drop(tables);
    }

    @Override
    public void load() {
        CapClassType[] capClassTypes = new CapClassType[]{
                new CapClassType(1, "Люди", "Классификатор людей")
        };
        insert(Arrays.asList(capClassTypes));
        DatabaseUtils.setSequenceValue("capclasstype_id_gen", capClassTypes.length+1);
    }
}
