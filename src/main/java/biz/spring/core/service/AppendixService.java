package biz.spring.core.service;

import biz.spring.core.model.Appendix;
import biz.spring.core.repository.AppendixRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.AppendixValidator;
import biz.spring.core.view.AppendixView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import biz.spring.core.repository.AppendixRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AppendixService extends BaseService<Appendix> {

    @Autowired
    private AppendixRepository appendixRepository;

    @Autowired
    private AppendixValidator appendixValidator;

    @Autowired
    private EMSService emsService;

    @PostConstruct
    public void init() { init(appendixRepository, appendixValidator); }

    @Value("classpath:/script/appendix/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/appendix/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<AppendixView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<AppendixView>(mainSql)
                .forClass(AppendixView.class, "m0")
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public AppendixView getOne(Integer id){
        return new Query.QueryBuilder<AppendixView>(mainSqlForOne)
                .forClass(AppendixView.class, "m0")
                .build()
                .executeOne(id);
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<AppendixView>(mainSql)
                .forClass(AppendixView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .setParams(gridDataOption.buildParams())
                .build()
                .count();
    }

    public void deleteFiles(int[] ids){
        for(Integer id: ids){
            Appendix appendix = appendixRepository.get(id);
            emsService.delete(appendix.getAppendixPath());
        }
    }
}
