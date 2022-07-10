package biz.bna.core.utils;
import org.reflections.Reflections;

import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

//TODO описать класс, заполняющий метаданные таблицы. Метаданные = поля, описанные ниже
public class TableMetadata {

    //Имя таблицы
    private String tableName;
    //Имя класса
    private Class modelClass;
    //Первычный ключ с аннотацией @Id
    private Field idField;
    //Поля таблицы
    private List<ColumnMetadata> fields;
    //методы get и set
    private Map<String, List<Method>> methods;

    public static void fillTableMetadata(){
        Set<Class<?>> tableClasses = new Reflections("biz.bna.core").getTypesAnnotatedWith(Table.class);
        tableClasses.forEach(aClass -> {
            Field[] fields = aClass.getFields();
            for(Field field: fields){
                field.isAnnotationPresent(Id.class);
            }
        });
    }
}
