package biz.bna.core.utils;

import java.lang.reflect.Method;

//TODO Описать класс, заполняющий метаданные поля. Метаданные - поля, описанные
public class ColumnMetadata {

    private String columnName;
    private boolean nullable;
    private String nullableMessage;
    private String description;
    private Integer textSize;
    private Integer textSizeMessage;
    private Method getMethod;
    private Method setMethod;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public String getNullableMessage() {
        return nullableMessage;
    }

    public void setNullableMessage(String nullableMessage) {
        this.nullableMessage = nullableMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTextSize() {
        return textSize;
    }

    public void setTextSize(Integer textSize) {
        this.textSize = textSize;
    }

    public Integer getTextSizeMessage() {
        return textSizeMessage;
    }

    public void setTextSizeMessage(Integer textSizeMessage) {
        this.textSizeMessage = textSizeMessage;
    }

    public Method getGetMethod() {
        return getMethod;
    }

    public void setGetMethod(Method getMethod) {
        this.getMethod = getMethod;
    }

    public Method getSetMethod() {
        return setMethod;
    }

    public void setSetMethod(Method setMethod) {
        this.setMethod = setMethod;
    }
}
