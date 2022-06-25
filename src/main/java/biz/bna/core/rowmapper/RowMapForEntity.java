package biz.bna.core.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Column;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RowMapForEntity<T> implements RowMapper<T> {
    @Override
    public T mapRow(ResultSet resultSet, int i) throws SQLException {
        T obj = (T)new Object();
        ResultSetMetaData metadata = resultSet.getMetaData();
        for(int j = 0; j < metadata.getColumnCount(); j++){
            String columnName = metadata.getColumnName(j);
        }
        return null;
    }
}
