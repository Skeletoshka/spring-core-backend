package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Request;
import biz.spring.core.repository.dnk.RequestRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.RequestValidator;
import biz.spring.core.view.dnk.RequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RequestService extends BaseService<Request> {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestValidator requestValidator;

    @Value("classpath:/script/dnk/request/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/dnk/request/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @PostConstruct
    protected void init() {
        super.init(requestRepository, requestValidator);
    }

    public List<RequestView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<RequestView>(mainSQL)
                .forClass(RequestView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<RequestView>(mainSQL)
                .forClass(RequestView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .setParams(gridDataOption.buildParams())
                .build()
                .count();
    }

    public RequestView getOne(Integer id){
        return new Query.QueryBuilder<RequestView>(mainSQLForOne)
                .forClass(RequestView.class, "m0")
                .build()
                .executeOne(id);
    }

}
