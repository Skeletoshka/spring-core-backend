package biz.bna.core.utils;

import biz.bna.core.MainApplication;
import biz.bna.core.config.DatabaseConfig;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.Table;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

public class OrmUtils {
    public static NamedParameterJdbcTemplate getJDBC(){
        ApplicationContext context = MainApplication.getApplicationContext();
        DataSource dataSource = context.getBean(DatabaseConfig.class).dataSource();
        return new NamedParameterJdbcTemplate(dataSource);
    }

    /**Метод, возвращающий класс дженерика
     * @param cls - класс, реализующий TableRepository<T>
     * @return tableName - Имя таблицы в бд
     * */
    public static String getTableName(Class cls){
        ParameterizedType genericSuperclass = (ParameterizedType) cls.getGenericSuperclass();
        Class<?>[] genericArgumentClass = (Class[])genericSuperclass.getActualTypeArguments();
        genericArgumentClass.clone();
        return null;
    }

    /**Метод для заполнения метаданных таблиц в TableRepository
     * Считывает все классы с аннотацией Table
     * Ключ - имя таблицы
     * */
    public static void fillTableMetadata(){
        Set<Class<?>> tableClasses = new Reflections("biz.bna.core").getTypesAnnotatedWith(Table.class);
        TableMetadata tableMetadata = new TableMetadata();
        tableClasses.forEach(aClass -> {
            tableMetadata.setFields(getColumnMetadata(aClass));
        });
    }

    /**Метод для заполнения метаданных столбцов в TableMetadata
     * @param cls - Класс, из которого формируются метаданные
     * @return List<ColumnMetadata> - список из метаданных столбцов*/
    private static List<ColumnMetadata> getColumnMetadata(Class cls){
        Field[] fields = cls.getFields();
        return null;
    }
}
