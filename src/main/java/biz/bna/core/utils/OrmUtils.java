package biz.bna.core.utils;

import biz.bna.core.MainApplication;
import biz.bna.core.config.DatabaseConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

public class OrmUtils {
    public static NamedParameterJdbcTemplate getJDBC(){
        ApplicationContext context = MainApplication.getApplicationContext();
        DataSource dataSource = context.getBean(DatabaseConfig.class).dataSource();
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
