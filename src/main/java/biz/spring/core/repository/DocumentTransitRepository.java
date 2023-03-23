package biz.spring.core.repository;

import biz.spring.core.model.DocumentTransit;
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
public class DocumentTransitRepository implements TableRepository<DocumentTransit> {

    private static Logger logger = LoggerFactory.getLogger(DocumentTransitRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/100700-documenttransit.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("documenttransit created");
    }

    @Override
    public void drop() {
        String[] tables = {"documenttransit"};
        drop(tables);
    }

    @Override
    public void load() {
        DocumentTransit[] documentTransits = {};
        insert(Arrays.asList(documentTransits));
        DatabaseUtils.setSequenceValue("documenttransit_id_gen", documentTransits.length+1);
    }
}
