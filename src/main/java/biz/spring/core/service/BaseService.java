package biz.spring.core.service;

import biz.spring.core.repository.TableRepository;
import biz.spring.core.rowmapper.RowMapForEntity;
import biz.spring.core.utils.OrmUtils;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Locale;
import java.util.Map;

//TODO Решить какие методы нужны для реализации
public abstract class BaseService<T> {

    public static String STANDARD_SUCCESS = "{\"status\":\"success\"}";
    TableRepository<T> tableRepository;
    protected abstract void init();

    public void init(TableRepository<T> tableRepository){
        this.tableRepository=tableRepository;
    }
    protected Object findQuery(String sql, Map<String, Object> params, Class cls){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        RowMapForEntity rowMapper = new RowMapForEntity(cls);
        OrmUtils.loggerSql(sql);
        return jdbc.query(sql, params, rowMapper);
    }

    public T add(T obj){
        Integer id = tableRepository.insert(obj);
        return tableRepository.get(id);
    }

    public T edit(T obj){
        Integer id = tableRepository.update(obj);
        return tableRepository.get(id);
    }

    public void delete(int[] ids){
        for(int id: ids){
            delete(id);
        }
    }

    public void delete(int id){
        tableRepository.delete(id);
    }
}
