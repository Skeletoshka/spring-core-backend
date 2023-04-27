package biz.spring.core.service;

import biz.spring.core.model.Company;
import biz.spring.core.repository.CompanyRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.CompanyValidator;
import biz.spring.core.view.CompanyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CompanyService extends BaseService<Company>{

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyValidator companyValidator;

    @Value("classpath:/script/company/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/company/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @PostConstruct
    protected void init() {
        super.init(companyRepository, companyValidator);
    }

    public List<CompanyView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<CompanyView>(mainSQL)
                .forClass(CompanyView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .setLimit(gridDataOption.buildPageRequest())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<CompanyView>(mainSQL)
                .forClass(CompanyView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .build()
                .count();
    }

    public CompanyView getOne(Integer id){
        return new Query.QueryBuilder<CompanyView>(mainSQLForOne)
                .forClass(CompanyView.class, "m0")
                .build()
                .executeOne(id);
    }
}
