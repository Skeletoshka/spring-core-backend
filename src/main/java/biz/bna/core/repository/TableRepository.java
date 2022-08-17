package biz.bna.core.repository;

import biz.bna.core.rowmapper.RowMapForEntity;
import biz.bna.core.utils.OrmUtils;
import biz.bna.core.utils.TableMetadata;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Transactional(propagation = Propagation.REQUIRED)
public interface TableRepository<T> {
    /**Класс содержит основные методы для доступа к бд. Возвращаются данные из ОДНОЙ таблицы.
     * Методы: List<T> getAll()
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
}
