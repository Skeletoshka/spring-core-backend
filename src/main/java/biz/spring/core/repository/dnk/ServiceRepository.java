package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Service;
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
public class ServiceRepository implements TableRepository<Service> {

    private static Logger logger = LoggerFactory.getLogger(ServiceRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100300-service.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("service created");
    }

    @Override
    public void drop() {
        String[] tables = {"service"};
        drop(tables);
    }

    @Override
    public void load() {
        Service[] services = new Service[]{
                new Service(1, "Добавление мероприятия", null),
                new Service(2, "Регистрация школьника", null),
                new Service(3, "Регистрация программы обучения", null),
        };
        insert(Arrays.asList(services));
        DatabaseUtils.setSequenceValue("service_id_gen", services.length+1);
    }
}
