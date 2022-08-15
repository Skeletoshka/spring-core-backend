package biz.bna.core.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RowMapForEntity implements RowMapper<Object> {
    private Class cls;

    public RowMapForEntity(Class cls){
        this.cls = cls;
    }

    //основной компонент для преобразования
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Object obj = new Object();
        Field[] fields = obj.getClass().getFields();
        ResultSetMetaData metadata = resultSet.getMetaData();
        for(int j = 0; j < metadata.getColumnCount(); j++){
            String columnName = metadata.getColumnName(j);
        }
        return null;
    }
}
