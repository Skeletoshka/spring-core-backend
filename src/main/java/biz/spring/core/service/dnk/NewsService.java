package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.News;
import biz.spring.core.repository.dnk.NewsRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.NewsValidator;
import biz.spring.core.view.dnk.NewsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NewsService extends BaseService<News> {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private NewsValidator newsValidator;

    @Value("classpath:/script/dnk/activity/mainSql.sql")
    Resource mainSQL;

    @Value("classpath:/script/dnk/activity/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @PostConstruct
    protected void init() {
        super.init(newsRepository, newsValidator);
    }

    public List<NewsView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<NewsView>(mainSQL)
                .forClass(NewsView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<NewsView>(mainSQL)
                .forClass(NewsView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .count();
    }

    public NewsView getOne(Integer id){
        return new Query.QueryBuilder<NewsView>(mainSQL)
                .forClass(NewsView.class, "m0")
                .build()
                .executeOne(id);
    }
}
