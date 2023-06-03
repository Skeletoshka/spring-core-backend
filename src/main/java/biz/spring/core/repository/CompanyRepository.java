package biz.spring.core.repository;

import biz.spring.core.model.Company;
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
public class CompanyRepository implements TableRepository<Company>{

    private static Logger logger = LoggerFactory.getLogger(CompanyRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/200200-company.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("company created");
    }

    @Override
    public void drop() {
        String[] tables = {"company"};
        drop(tables);
    }

    @Override
    public void load() {
        Company[] companies = new Company[]{
                new Company(1, "Лучшие штучки", 1, 1, "89999999999", null, 1),
                new Company(2, "Игрушки для детишек", 1, 1, null, null, 2),
                new Company(3, "Лучшие игрушки", 1, 1, "89999999999", null, 3),
                new Company(4, "Детские игрушки", 1, 1, "89999999999", null, 4),
        };
        insert(Arrays.asList(companies));
        DatabaseUtils.setSequenceValue("company_id_gen", companies.length+1);
    }
}
