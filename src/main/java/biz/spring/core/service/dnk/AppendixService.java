package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Appendix;
import biz.spring.core.repository.dnk.AppendixRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.AppendixValidator;
import biz.spring.core.view.dnk.AppendixView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import biz.spring.core.repository.dnk.AppendixRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AppendixService extends BaseService<Appendix> {

    @Autowired
    private AppendixRepository appendixRepository;

    @Autowired
    private AppendixValidator appendixValidator;

    @PostConstruct
    public void init() { init(appendixRepository, appendixValidator); }

    private final String mainSql = "" +
            "SELECT * " +
            "FROM appendix";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM appendix " +
            "WHERE appendix_id = :id";

    public List<AppendixView> getAll(GridDataOption gridDataOption){
        boolean findAppendix = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "appendixId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<AppendixView>(mainSql)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .injectSqlIf(findAppendix, "/*APPENDIX_PLACEHOLDER*/", " AND appendix_id = :appendixId")
                .forClass(AppendixView.class)
                .build()
                .execute();
    }

    public AppendixView getOne(Integer id){
        return new Query.QueryBuilder<AppendixView>(mainSqlForOne)
                .forClass(AppendixView.class)
                .build()
                .executeOne(id);
    }

}
