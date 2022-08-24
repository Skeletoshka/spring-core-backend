package biz.spring.core.service;

import biz.spring.core.rowmapper.RowMapForEntity;
import biz.spring.core.utils.OrmUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Locale;
import java.util.Map;

//TODO Решить какие методы нужны для реализации
public class BaseService<T> {
    protected Object findQuery(String sql, Map<String, Object> params, Class cls){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForEntity rowMapper = new RowMapForEntity(cls);
        OrmUtils.loggerSql(sql);
        return jdbc.query(sql, params, rowMapper);
    }
}
