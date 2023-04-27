package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.repository.dnk.PeopleRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.PeopleValidator;
import biz.spring.core.view.dnk.PeopleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PeopleService extends BaseService<People> {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private PeopleValidator peopleValidator;

    @PostConstruct
    public void init(){
        init(peopleRepository, peopleValidator);
    }

    @Value("classpath:/script/dnk/people/mainSQL.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/people/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<PeopleView> getAll(GridDataOption gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName())
         && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<PeopleView>(mainSql)
                .forClass(PeopleView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .setLimit(gridDataOption.buildPageRequest())
                .injectSqlIf(capClassFound, "/*CAPCLASS_PLACEHOLDER*/", "AND m0.capclass_id = :capClassId")
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName())
                && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<PeopleView>(mainSql)
                .forClass(PeopleView.class, "m0")
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(capClassFound, "/*CAPCLASS_PLACEHOLDER*/", "AND m0.capclass_id = :capClassId")
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .count();
    }

    public PeopleView getOne(Integer id){
        return new Query.QueryBuilder<PeopleView>(mainSqlForOne)
                .forClass(PeopleView.class, "m0")
                .build()
                .executeOne(id);
    }
}
