package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Request;
import biz.spring.core.repository.TableRepository;
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
public class RequestRepository implements TableRepository<Request> {

    private static Logger logger = LoggerFactory.getLogger(RequestRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100400-request.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("request created");
    }

    @Override
    public void drop() {
        String[] tables = {"request"};
        drop(tables);
    }

    @Override
    public void load() {
        Request[] requests = new Request[]{
                new Request(1, "Заявка на добавление ученика"),
                new Request(2, "Заявка на партнёрство"),
                new Request(3, "Тестовая заявка")
        };
        insert(Arrays.asList(requests));
    }
}
