package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.RequestPos;
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
public class RequestPosRepository implements TableRepository<RequestPos> {
    private static Logger logger = LoggerFactory.getLogger(RequestPosRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100500-requestpos.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("requestpos created");
    }

    @Override
    public void drop() {
        String[] tables = {"requestpos"};
        drop(tables);
    }

    @Override
    public void load() {
        RequestPos[] requestPos = new RequestPos[]{
                new RequestPos(1, 1, "Добавьте, пожалуйста, меня на курс", 1),
                new RequestPos(2, 1, "Тестовый текст", 1),
                new RequestPos(3, 2, "Что-нибудь интересное", 2),
                new RequestPos(4, 1, "Сделайте все в лучшем виде", 1),
                new RequestPos(5, 2, "Я ваш партнёр", 3)
        };
        insert(Arrays.asList(requestPos));
        DatabaseUtils.setSequenceValue("requestpos_id_gen", requestPos.length+1);
    }
}
