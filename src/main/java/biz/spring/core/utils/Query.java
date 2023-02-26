package biz.spring.core.utils;

import biz.spring.core.rowmapper.RowMapForObject;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO реализация класса для кастомных запросов
public class Query<T> {
    private Class cls;
    private String sql;
    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> replace = new HashMap<>();

    private String orderBy;

    public Query(){}

    public Query(String sql){
        this.sql = sql;
    }

    public Query<T> forClass(Class cls){
        this.cls = cls;
        return this;
    }

    public Query<T> setParams(Map<String, Object> params){
        this.params.putAll(params);
        return this;
    }

    public Query<T> setParam(String paramName, Object paramValue){
        params.put(paramName, paramValue);
        return this;
    }

    /**
     * Для выполнения сортировки в запросе должен быть ORDERBY_PLACEHOLDER
     * @param orderBy */
    public Query<T> setOrderBy(String orderBy){
        this.orderBy = orderBy;
        this.replace.put("/*ORDERBY_PLACEHOLDER*/", "ORDER BY " + orderBy);
        return this;
    }

    public Query<T> setLimit(String limitPlaceholder){
        this.replace.put("/*LIMIT_PLACEHOLDER*/", limitPlaceholder);
        return this;
    }

    public Query<T> injectSql(String placeholder, String sql){
        this.replace.put(placeholder, sql);
        return this;
    }

    public Query<T> injectSqlIf(boolean condition, String placeholder, String sql){
        if(condition){
            injectSql(placeholder, sql);
        }
        return this;
    }

    public List<T> execute(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForObject rowMapper = new RowMapForObject(cls);
        replace.forEach((key, val) -> {
            sql = sql.replaceAll(key, val);
        });
        OrmUtils.loggerSql(sql);
        if (params != null) {
            return (List<T>) jdbc.query(sql, params, rowMapper);
        }else{
            return (List<T>) jdbc.query(sql, rowMapper);
        }
    }

    public T executeOne(Integer id){
        params.put("id", id);
        List<T> objects = execute();
        if(objects == null || objects.isEmpty()) {
            throw new RuntimeException(String.format("Запись с id = %d не найдена", params.get("id") ));
        }else{
            return execute().get(0);
        }
    }
}
