package biz.spring.core.repository;

import biz.spring.core.model.Contract;
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
public class ContractRepository implements TableRepository<Contract>{

    private static Logger logger = LoggerFactory.getLogger(ContractRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/200400-contract.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("contract created");
    }

    @Override
    public void drop() {
        String[] tables = {"contract"};
        drop(tables);
    }

    @Override
    public void load(){
        Contract[] contracts = new Contract[]{
                new Contract(1, new Date()),
                new Contract(2, new Date()),
                new Contract(3, new Date()),
                new Contract(4, new Date()),
                new Contract(5, new Date())
        };
        insert(Arrays.asList(contracts));
    }
}
