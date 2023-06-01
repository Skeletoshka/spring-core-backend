package biz.spring.core.repository;


import biz.spring.core.model.DocumentType;
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
public class DocumentTypeRepository implements TableRepository<DocumentType>{

    private static Logger logger = LoggerFactory.getLogger(DocumentTypeRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/100600-documenttype.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("documenttype created");
    }

    @Override
    public void drop() {
        String[] tables = {"documenttype"};
        drop(tables);
    }

    @Override
    public void load() {
        DocumentType[] documentTypes = {
                new DocumentType(1, "Тест")
        };
        insert(Arrays.asList(documentTypes));
        DatabaseUtils.setSequenceValue("documenttype_id_gen", documentTypes.length+1);
    }
}
