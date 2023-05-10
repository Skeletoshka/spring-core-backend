package biz.spring.core.repository.dnk;
import biz.spring.core.model.dnk.Appendix;

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
public class AppendixRepository implements TableRepository<Appendix> {

    private static Logger logger = LoggerFactory.getLogger(AppendixRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/200300-appendix.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("appendix created");
    }

    @Override
    public void drop() {
        String[] tables = {"appendix", "material"};
        drop(tables);
    }


    @Override
    public void load(){
        Appendix[] appendixs = {
                new Appendix(1, "Отчетный материал 1", "Отчетный материал 1.txt"),
                new Appendix(2, "Отчетный материал 2", "Отчетный материал 2.txt"),
                new Appendix(3, "Отчетный материал 3", "Отчетный материал 3.txt")
        };
        insert(Arrays.asList(appendixs));
        DatabaseUtils.setSequenceValue("appendix_id_gen", appendixs.length+1);

    }

}
