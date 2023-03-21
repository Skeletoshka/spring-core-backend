package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.repository.dnk.PeopleRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
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

    @PostConstruct
    public void init(){
        init(peopleRepository);
    }

    @Value("classpath:/script/dnk/people/mainSQL.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/people/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<PeopleView> getAll(GridDataOption gridDataOption){
        boolean capClassFound = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "capClassId".equals(nf.getName())
         && !nf.getValue().equals(-1));
        return new Query<PeopleView>(mainSql)
                .setParams(gridDataOption.buildParams())
                .setLimit(gridDataOption.buildPageRequest())
                .injectSqlIf(capClassFound, "/*CAPCLASS_PLACEHOLDER*/", "AND capclass_id = :capClassId")
                .setOrderBy(gridDataOption.getOrderBy())
                .forClass(People.class)
                .execute();
    }

    public PeopleView getOne(Integer id){
        return new Query<PeopleView>(mainSqlForOne)
                .forClass(PeopleView.class)
                .executeOne(id);
    }
}
