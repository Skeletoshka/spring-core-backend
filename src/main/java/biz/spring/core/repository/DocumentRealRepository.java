package biz.spring.core.repository;

import biz.spring.core.model.DocumentReal;
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
import java.util.HashMap;
import java.util.Map;

@Repository
public class DocumentRealRepository implements TableRepository<DocumentReal>{

    private static Logger logger = LoggerFactory.getLogger(DocumentRealRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setStatus(Integer documentRealId, Integer statusId){
        String sql = "" +
                "UPDATE documentreal SET " +
                "documenttransit_id = :statusId " +
                "WHERE documentreal_id = :documentRealId";
        Map<String, Object> params = new HashMap<>();
        params.put("documentRealId", documentRealId);
        params.put("statusId", statusId);
        executeSql(sql, params);
    }

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/100800-documentreal.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("documentreal created");
    }

    @Override
    public void drop() {
        String[] tables = {"documentreal"};
        drop(tables);
    }

    @Override
    public void load() {
        DocumentReal[] documentReals = {};
        insert(Arrays.asList(documentReals));
        DatabaseUtils.setSequenceValue("documenttransit_id_gen", documentReals.length+1);
    }
}
