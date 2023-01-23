package biz.spring.core.repository;

import biz.spring.core.model.Post;
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
public class PostRepository implements TableRepository<Post> {
    private static Logger logger = LoggerFactory.getLogger(PostRepository.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(){
        Resource resource = new ClassPathResource("sql/100500-post.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("post created");
    }

    @Override
    public void drop(){
        String[] tables = {"post"};
        drop(tables);
    }

    @Override
    public void load(){
        Post[] posts = {
                new Post(1, "Директор"),
                new Post(2, "Секретарь"),
                new Post(3, "Методист")
        };
        insert(Arrays.asList(posts));
        DatabaseUtils.setSequenceValue("post_id_gen", posts.length+1);
    }
}
