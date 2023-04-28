package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.RequestPos;
import biz.spring.core.repository.dnk.RequestPosRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.RequestPosValidator;
import biz.spring.core.view.dnk.RequestPosView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class RequestPosService extends BaseService<RequestPos> {

    @Autowired
    private RequestPosRepository requestPosRepository;
    @Autowired
    private RequestPosValidator requestPosValidator;

    @Value("classpath:/script/dnk/requestpos/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/dnk/requestpos/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @PostConstruct
    protected void init() {
        super.init(requestPosRepository, requestPosValidator);
    }

    public List<RequestPosView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<RequestPosView>(mainSQL)
                .forClass(RequestPosView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setSearch(gridDataOption.getSearch())
                .setParams(gridDataOption.buildParams())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<RequestPosView>(mainSQL)
                .forClass(RequestPosView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .setParams(gridDataOption.buildParams())
                .build()
                .count();
    }

    public RequestPosView getOne(Integer id){
        return new Query.QueryBuilder<RequestPosView>(mainSQLForOne)
                .forClass(RequestPosView.class, "m0")
                .build()
                .executeOne(id);
    }
}
