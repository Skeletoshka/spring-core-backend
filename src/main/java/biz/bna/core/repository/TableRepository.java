package biz.bna.core.repository;

import biz.bna.core.rowmapper.RowMapForEntity;
import biz.bna.core.utils.OrmUtils;
import biz.bna.core.utils.TableMetadata;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Transactional(propagation = Propagation.REQUIRED)
public interface TableRepository<T> {
    //TODO Решить какие методы нужны для реализации

    //Заполняется при запуске приложения. См. config/InitApp
    Map<String, TableMetadata> metaDataMap = new HashMap<>();

    default List<T> getAll(){
        NamedParameterJdbcTemplate jdbc = OrmUtils.getJDBC();
        Map<String, TableMetadata> metaDataMap = this.metaDataMap;
        String sql = "SELECT * FROM " + OrmUtils.getTableName(this.getClass());
        OrmUtils.loggerSql(sql);
        RowMapForEntity rowMapper = new RowMapForEntity(metaDataMap.get(OrmUtils.getTableName(this.getClass()).toLowerCase(Locale.ROOT)).getModelClass());
        return (List<T>) jdbc.query(sql, rowMapper);
    }
}
