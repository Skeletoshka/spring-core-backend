package biz.bna.core.utils;

import biz.bna.core.MainApplication;
import biz.bna.core.config.DatabaseConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OrmUtils {
    public static NamedParameterJdbcTemplate getJDBC(){
        ApplicationContext context = MainApplication.getApplicationContext();
        DataSource dataSource = context.getBean(DatabaseConfig.class).dataSource();
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**Метод, возвращающий класс дженерика
     * @param cls - класс, реализующий TableRepository<T>
     * */
    public static String getTableName(Class cls){
        ParameterizedType genericSuperclass = (ParameterizedType) cls.getGenericSuperclass();
        Class<?>[] genericArgumentClass = (Class[])genericSuperclass.getActualTypeArguments();
        genericArgumentClass.clone();
        return null;
    }
}
