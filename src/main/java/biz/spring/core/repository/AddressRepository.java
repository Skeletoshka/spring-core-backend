package biz.spring.core.repository;

import biz.spring.core.model.Address;
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
public class AddressRepository implements TableRepository<Address>{

    private static Logger logger = LoggerFactory.getLogger(AddressRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/200300-address.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("address created");
    }

    @Override
    public void drop(){
        String[] tables = {"address", "street", "town"};
        drop(tables);
    }

    @Override
    public void load(){
        //INSERT происходит в файле 200300-address.sql
    }

}
