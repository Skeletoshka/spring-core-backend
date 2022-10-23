package biz.spring.core.repository;

import biz.spring.core.rowmapper.RowMapForEntity;
import biz.spring.core.rowmapper.RowMapForObject;
import biz.spring.core.utils.OrmUtils;
import biz.spring.core.utils.TableMetadata;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Id;
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

    default Integer count(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        String sql = "SELECT COUNT(*) FROM " + OrmUtils.getTableName(this.getClass());
        OrmUtils.loggerSql(sql);
        return jdbc.queryForObject(sql, (Map<String, ?>) null, Integer.class);
    }

    default void insert(T obj){
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
                                nextValue(tableMetadata.getTableName() + "_"
                                        + tableMetadata.getIdField().getDeclaredAnnotation(Column.class).name()
                                        + "_seq"):
                                Arrays.stream(obj.getClass().getDeclaredMethods())
                                .filter(method -> method.getName().toLowerCase(Locale.ROOT).equals("get" + field.getName().toLowerCase(Locale.ROOT)))
                                .findFirst().orElseThrow().invoke(obj, null));
                    } catch (Exception e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }).collect(Collectors.toList());
        OrmUtils.loggerSql(sql);
        jdbc.execute(sql, params, PreparedStatement::execute);
    }

    default void insert(List<T> objects){
        objects.forEach(this::insert);
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
}
