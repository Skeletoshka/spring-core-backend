package biz.bna.core.utils;

import biz.bna.core.MainApplication;
import biz.bna.core.config.DatabaseConfig;
import biz.bna.core.repository.TableRepository;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.stream.Collectors;

public class OrmUtils {

    private static Logger logger = LoggerFactory.getLogger(OrmUtils.class);

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
        cls.getSimpleName();
        return cls.getSimpleName().replaceAll("Repository", "");
    }

    /**Метод для заполнения метаданных таблиц в TableRepository
     * Считывает все классы с аннотацией Table
     * Ключ - имя таблицы
     * */
    public static void fillTableMetadata(){
        Set<Class<?>> tableClasses = new Reflections("biz.bna.core").getTypesAnnotatedWith(Table.class);
        tableClasses.forEach(aClass -> {
            TableMetadata tableMetadata = new TableMetadata();
            //Ставим в поле первичного ключа поле с аннотацией @Id
            tableMetadata.setIdField(Arrays.stream(aClass.getDeclaredFields()).filter(field ->
                    field.getAnnotationsByType(Id.class).length>0).findAny().orElseThrow());
            //Класс сущности
            tableMetadata.setModelClass(aClass);
            //Наименование таблицы в бд
            tableMetadata.setTableName(aClass.getAnnotation(Table.class).name());
            //Метаданные полей
            tableMetadata.setFields(getColumnMetadata(aClass));
            TableRepository.metaDataMap.put(aClass.getAnnotation(Table.class).name(), tableMetadata);
        });
    }

    /**Метод для заполнения метаданных столбцов в TableMetadata
     * @param cls - Класс, из которого формируются метаданные
     * @return List<ColumnMetadata> - список из метаданных столбцов
     **/
    private static List<ColumnMetadata> getColumnMetadata(Class cls){
        Field[] fields = cls.getDeclaredFields();
        return Arrays.stream(fields).map(field -> {
            ColumnMetadata columnMetadata = new ColumnMetadata();
            columnMetadata.setColumnName(field.getAnnotationsByType(Column.class)[0].name());
            columnMetadata.setNullable(field.getAnnotationsByType(Column.class)[0].nullable());
            columnMetadata.setNullableMessage(field.getAnnotationsByType(NotNull.class).length>=1?
                    field.getAnnotationsByType(NotNull.class)[0].message():null);
            if(field.getAnnotationsByType(Size.class).length>=1){
                columnMetadata.setTextSize(field.getAnnotationsByType(Size.class)[0].max());
                columnMetadata.setTextSizeMessage(field.getAnnotationsByType(Size.class)[0].message());
            }
            columnMetadata.setGetMethod(Arrays.stream(cls.getDeclaredMethods())
                    .filter(method -> method.getName().toLowerCase(Locale.ROOT).equals("get" + field.getName().toLowerCase(Locale.ROOT)))
                    .findAny().orElseThrow());
            columnMetadata.setSetMethod(Arrays.stream(cls.getDeclaredMethods())
                    .filter(method -> method.getName().toLowerCase(Locale.ROOT).equals("set" + field.getName().toLowerCase(Locale.ROOT)))
                    .findAny().orElseThrow());
            return columnMetadata;
        }).collect(Collectors.toList());
    }

    public static void loggerSql(String sql){
        logger.info(sql);
    }
}
