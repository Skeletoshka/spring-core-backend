package biz.spring.core.utils;

import java.util.HashMap;
import java.util.Map;

public class GridDataOption {
    private String namedFilters;
    private Map<String, Object> params = new HashMap<>();
    private Integer rowCount;
    private Integer page;
    private String orderBy;
    private String from;

    public String getNamedFilters() {
        return namedFilters;
    }

    public void setNamedFilters(String namedFilters) {
        this.namedFilters = namedFilters;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    /**Метод, для внедрения в запрос LIMIT*/
    public String buildPageRequest(){
        return "LIMIT" + page + " OFFSET " + page * rowCount;
    }
}
