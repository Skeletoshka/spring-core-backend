package biz.spring.core.repository.dnk;

import biz.spring.core.model.dnk.News;
import biz.spring.core.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class NewsRepository implements TableRepository<News> {
    private static Logger logger = LoggerFactory.getLogger(NewsRepository.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create() {
        Resource resource = new ClassPathResource("sql/dnk/100600-news.sql");
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
        databasePopulator.setSqlScriptEncoding("UTF-8");
        databasePopulator.execute(jdbcTemplate.getDataSource());
        logger.info("news created");
    }

    @Override
    public void drop() {
        String[] tables = {"activity"};
        drop(tables);
    }

    @Override
    public void load() {
        News[] news = new News[]{
                new News(1, "Крутая новость", "Самая крутая новость"),
                new News(2, "Крутая новость-2", "Самая крутая новость-2"),
                new News(3, "Крутая новость-3", "Самая крутая новость-3"),
                new News(4, "Крутая новость-4", "Самая крутая новость-4")
        };
    }
}
