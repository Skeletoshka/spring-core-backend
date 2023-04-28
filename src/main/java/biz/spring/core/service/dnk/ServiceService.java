package biz.spring.core.service.dnk;

import biz.spring.core.repository.dnk.ServiceRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.ServiceValidator;
import biz.spring.core.view.dnk.ServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ServiceService extends BaseService<biz.spring.core.model.dnk.Service> {
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private ServiceValidator serviceValidator;

    @PostConstruct
    protected void init() {
        super.init(serviceRepository, serviceValidator);
    }

    @Value("classpath:/script/dnk/service/mainSQL.sql")
    Resource mainSql;

    public List<ServiceView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ServiceView>(mainSql)
                .forClass(ServiceView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ServiceView>(mainSql)
                .forClass(ServiceView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .count();
    }
}
