package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.Block;
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
public class BlockRepository implements TableRepository<Block> {
    private static Logger logger = LoggerFactory.getLogger(BlockRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/200200-block.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("block created");
    }

    @Override
    public void drop(){
        String[] tables = {"block"};
        drop(tables);
    }

    @Override
    public void load(){
        Block[] blocks = {
                new Block(1, "Вступление", 1, 1, 1, 1),
                new Block(2, "Вступление", 2, 1, 1, 2),
                new Block(3, "Вступление", 3, 1, 1, 3)
        };
        insert(Arrays.asList(blocks));
        DatabaseUtils.setSequenceValue("block_id_gen", blocks.length+1);
    }
}
