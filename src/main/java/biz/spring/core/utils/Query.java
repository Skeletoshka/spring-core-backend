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

    public Query(){}

    public Query(String sql){
        this.sql = sql;
    }

    public Query<T> forClass(Class cls){
        this.cls = cls;
        return this;
    }

    public Query<T> setParams(Map<String, Object> params){
        this.params = params;
        return this;
    }

    public Query<T> setParam(String paramName, Object paramValue){
        params.put(paramName, paramValue);
        return this;
    }

    public List<T> execute(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForObject rowMapper = new RowMapForObject(cls);
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
