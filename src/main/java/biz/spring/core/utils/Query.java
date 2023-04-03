package biz.spring.core.utils;

import biz.spring.core.rowmapper.RowMapForObject;
import org.springframework.core.io.Resource;
import javax.persistence.Column;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.lang.reflect.Field;
import java.util.*;

//TODO реализация класса для кастомных запросов
public class Query<T> {
    private Class cls;
    private String sql;
    private Map<String, Object> params = new HashMap<>();
    private Map<String, String> replace = new HashMap<>();

    public Query(QueryBuilder queryBuilder){
        this.cls = queryBuilder.cls;
        this.sql = queryBuilder.sql;
        this.params = queryBuilder.params;
        this.replace = queryBuilder.replace;
    }

    public List<T> execute(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForObject rowMapper = new RowMapForObject(cls);
        for(Map.Entry<String, String> replacement:replace.entrySet()){
            while (sql.contains(replacement.getKey())) {
                sql = sql.replace(replacement.getKey(), replacement.getValue());
            }
        }
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

    public static class QueryBuilder <T>{

        private Class cls;
        private String sql;
        private Map<String, Object> params = new HashMap<>();
        private Map<String, String> replace = new HashMap<>();

        public QueryBuilder(String sql){
            this.sql = sql;
        }

        public QueryBuilder(Resource resource){
            this.sql = OrmUtils.loadResource(resource);
        }

        public QueryBuilder<T> forClass(Class cls){
            this.cls = cls;
            return this;
        }

        public QueryBuilder<T> setParams(Map<String, Object> params){
            this.params.putAll(params);
            return this;
        }

        public QueryBuilder<T> setParam(String paramName, Object paramValue){
            params.put(paramName, paramValue);
            return this;
        }

        /**
         * Для выполнения сортировки в запросе должен быть ORDERBY_PLACEHOLDER
         * @param orderBy */
        public QueryBuilder<T> setOrderBy(String orderBy){
            Field orderByField = Arrays.stream(this.cls.getDeclaredFields())
                    .filter(field -> field.getName().toLowerCase(Locale.ROOT).equals(orderBy.toLowerCase(Locale.ROOT)))
                    .findFirst().orElse(null);
            if(orderByField!=null) {
                this.replace.put("/*ORDERBY_PLACEHOLDER*/", "ORDER BY " +
                        (orderByField.getAnnotationsByType(Column.class).length>0 ?
                                orderByField.getAnnotationsByType(Column.class)[0].name() : orderByField.getName()));
            }
            return this;
        }

        public QueryBuilder<T> setLimit(String limitPlaceholder){
            this.replace.put("/*LIMIT_PLACEHOLDER*/", limitPlaceholder);
            return this;
        }

        public QueryBuilder<T> injectSql(String placeholder, String sql){
            this.replace.put(placeholder, sql);
            return this;
        }

        public QueryBuilder<T> injectSqlIf(boolean condition, String placeholder, String sql){
            if(condition){
                injectSql(placeholder, sql);
            }
            return this;
        }

        public Query<T> build(){
            return new Query<>(this);
        }

    }
}
