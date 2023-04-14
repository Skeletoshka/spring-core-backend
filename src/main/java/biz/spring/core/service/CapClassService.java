package biz.spring.core.service;

import biz.spring.core.model.CapClass;
import biz.spring.core.repository.CapClassRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.CapClassValidator;
import biz.spring.core.view.CapClassView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CapClassService extends BaseService<CapClass>{

    @Autowired
    private CapClassRepository capClassRepository;
    @Autowired
    private CapClassValidator capClassValidator;

    @PostConstruct
    protected void init() {
        init(capClassRepository, capClassValidator);
    }

    @Value("classpath:/script/capclass/mainSql.sql")
    Resource mainSQL;

    public List<CapClassView> getAll(GridDataOption gridDataOption){
        boolean capClassTypeFound = gridDataOption.getNamedFilters().stream().anyMatch(nf ->
                "capClassTypeId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<CapClassView>(mainSQL)
                .forClass(CapClassView.class)
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(capClassTypeFound, "/*CAPCLASSTYPE_PLACEHOLDER*/", "AND cc.capclasstype_id = :capClassTypeId")
                .build()
                .execute();
    }
}
