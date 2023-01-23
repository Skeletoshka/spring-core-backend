package biz.spring.core.repository;

import biz.spring.core.rowmapper.RowMapForEntity;
import biz.spring.core.rowmapper.RowMapForObject;
import biz.spring.core.utils.OrmUtils;
import biz.spring.core.utils.TableMetadata;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Id;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.util.*;
import java.util.stream.Collectors;

@Transactional(propagation = Propagation.REQUIRED)
public interface TableRepository<T> {
    /**Класс содержит основные методы для доступа к бд. Возвращаются данные из ОДНОЙ таблицы.
     * Методы: List<T> getAll(), Integer count(), void insert(T obj)
     * */

    //Заполняется при запуске приложения. См. config/InitApp
    Map<String, TableMetadata> metaDataMap = new HashMap<>();

    default List<T> getAll(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        String sql = "SELECT * FROM " + OrmUtils.getTableName(this.getClass());
        OrmUtils.loggerSql(sql);
        RowMapForEntity rowMapper = new RowMapForEntity(metaDataMap.get(OrmUtils.getTableName(this.getClass()).toLowerCase(Locale.ROOT)).getModelClass());
        return (List<T>) jdbc.query(sql, rowMapper);
    }

    default T get(Integer id){
        return findWhere(OrmUtils.getTableName(this.getClass()) + "_id = :id", Map.of("id", id)).get(0);
    }

    default Integer count(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        String sql = "SELECT COUNT(*) FROM " + OrmUtils.getTableName(this.getClass());
        OrmUtils.loggerSql(sql);
        return jdbc.queryForObject(sql, (Map<String, ?>) null, Integer.class);
    }

    default Integer insert(T obj){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        TableMetadata tableMetadata = metaDataMap.get(OrmUtils.getTableName(this.getClass()).toLowerCase(Locale.ROOT));
        String columnsName = tableMetadata.getFields().stream()
                .map(field -> field.getColumnName() + ", ")
                .collect(Collectors.joining()).replaceAll(", $", "");
        String paramsName = tableMetadata.getFields().stream()
                .map(field -> ":" + field.getVarName() + ", ")
                .collect(Collectors.joining()).replaceAll(", $", "");
        String sql = String.format("INSERT INTO " + tableMetadata.getTableName() + "(%s) VALUES (%s)", columnsName, paramsName);
        Map<String, Object> params = new HashMap<>();
        Arrays.stream(obj.getClass().getDeclaredFields())
                .peek(field -> {
                    try {
                        params.put(field.getName(), field.getAnnotationsByType(Id.class).length>0?
                                nextValue(tableMetadata.getIdField().getDeclaredAnnotation(Column.class).name()
                                        + "_gen"):
                                Arrays.stream(obj.getClass().getDeclaredMethods())
                                .filter(method -> method.getName().toLowerCase(Locale.ROOT).equals("get" + field.getName().toLowerCase(Locale.ROOT)))
                                .findFirst().orElseThrow().invoke(obj, null));
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }).collect(Collectors.toList());
        OrmUtils.loggerSql(sql);
        jdbc.execute(sql, params, PreparedStatement::execute);
        return (Integer)params.get(tableMetadata.getIdField().getName());
    }

    default void insert(List<T> objects){
        objects.forEach(this::insert);
    }

    default void update(T object){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        TableMetadata tableMetadata = metaDataMap.get(OrmUtils.getTableName(this.getClass()).toLowerCase(Locale.ROOT));
        String sql = "UPDATE " + tableMetadata.getTableName() + " SET ";
        Map<String, Object> params = new HashMap<>();
        sql = sql + tableMetadata.getFields().stream()
                .filter(field -> !field.getVarName().equals(tableMetadata.getIdField().getName()))
                .map(field -> {
                    String columnName = field.getColumnName();
                    try {
                        params.put(columnName, Arrays.stream(object.getClass().getDeclaredMethods())
                                .filter(method -> method.getName().toLowerCase(Locale.ROOT).equals("get" + field.getVarName().toLowerCase(Locale.ROOT)))
                                .findFirst().orElseThrow().invoke(object, null));
                        return columnName + " = :" + columnName;
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }).collect(Collectors.joining(" "));
        String idFieldName = tableMetadata.getIdField().getAnnotationsByType(Column.class)[0].name();
        try {
            params.put(idFieldName, Arrays.stream(object.getClass().getDeclaredMethods())
                    .filter(method -> method.getName().toLowerCase(Locale.ROOT)
                            .equals("get" + tableMetadata.getIdField().getName().toLowerCase(Locale.ROOT)))
                    .findFirst().orElseThrow().invoke(object, null));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }
        sql += " WHERE " + idFieldName + " = :" + idFieldName;
        OrmUtils.loggerSql(sql);
        jdbc.update(sql, params);
    }

    default int nextValue(String seqName){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        String sql = "SELECT NEXTVAL(:seqName) ";
        OrmUtils.loggerSql(sql);
        return jdbc.queryForObject(sql, Map.of("seqName", seqName), Integer.class);
    }

    default List<T> findWhere(String wherePlaceholder, Map<String, Object> params){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        String sql = "SELECT * FROM " + OrmUtils.getTableName(this.getClass()) + " WHERE " + wherePlaceholder;
        RowMapForEntity rowMapper = new RowMapForEntity(metaDataMap.get(OrmUtils.getTableName(this.getClass()).toLowerCase(Locale.ROOT)).getModelClass());
        OrmUtils.loggerSql(sql);
        return (List<T>) jdbc.query(sql, params, rowMapper);
    }

    default List<T> findListForObject(String sql, Map<String, Object> params, Class<T> cls){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForObject rowMapper = new RowMapForObject(cls);
        OrmUtils.loggerSql(sql);
        return (List<T>)jdbc.query(sql, params, rowMapper);
    }

    default <T> T findForObject(String sql, Map<String, Object> params, Class<T> cls){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForObject rowMapper = new RowMapForObject(cls);
        OrmUtils.loggerSql(sql);
        return ((List<T>)jdbc.query(sql, params, rowMapper)).get(0);
    }

    default void executeSql(String sql){
        JdbcTemplate jdbc = OrmUtils.getJDBCTemplate();
        OrmUtils.loggerSql(sql);
        jdbc.execute(sql);
    }

    default void executeSql(String sql, Map<String, Object> params){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        OrmUtils.loggerSql(sql);
        jdbc.execute(sql, params, PreparedStatement::execute);
    }

    abstract public void create();

    default void drop(String[] tables){
        Arrays.stream(tables).forEach(this::drop);
    }
    default void drop(String tableName){
        String sql = "DROP TABLE IF EXISTS %s";
        executeSql(String.format(sql, tableName));
        sql = "DROP SEQUENCE IF EXISTS %s_id_gen";
        executeSql(String.format(sql, tableName));
    }

    abstract public void drop();

    abstract public void load();
}
