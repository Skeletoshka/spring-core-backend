package biz.spring.core.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import javax.persistence.Column;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class RowMapForEntity implements RowMapper<Object> {
    private Class cls;
    private final Constructor defaultConstructor;

    public RowMapForEntity(Class cls){
        this.cls = cls;
        try {
            defaultConstructor = cls.getConstructor(null);
        }catch (NoSuchMethodException e){
            throw new RuntimeException("Класс не имеет конструктора по умолчанию", e);
        }
    }

    //основной компонент для преобразования
    @Override
    public Object mapRow(ResultSet resultSet, int i) {
        Object obj;
        try {
            obj = defaultConstructor.newInstance(null);
            Field[] fields = obj.getClass().getDeclaredFields();
            ResultSetMetaData metadata = resultSet.getMetaData();
            for (int j = 1; j <= metadata.getColumnCount(); j++) {
                String columnName = metadata.getColumnName(j);
                Field resultField = Arrays.stream(fields)
                        .filter(field -> field.getAnnotationsByType(Column.class).length>0 &&
                                field.getAnnotationsByType(Column.class)[0].name().equals(columnName))
                        .findFirst().orElseThrow();
                Method setMethod = Arrays.stream(obj.getClass().getMethods())
                        .filter(method -> method.getName().toLowerCase(Locale.ROOT).equals("set" + resultField.getName().toLowerCase(Locale.ROOT)))
                        .findFirst().orElseThrow();
                String columnTypeName = metadata.getColumnTypeName(j);
                switch (columnTypeName) {
                    case "int4":
                    case "serial":
                        setMethod.invoke(obj, resultSet.getObject(j, Integer.class));
                        break;
                    case "varchar":
                        setMethod.invoke(obj, resultSet.getString(j));
                        break;
                    case "date":
                        setMethod.invoke(obj, resultSet.getDate(j));
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return obj;
    }
}
