package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Direction;
import biz.spring.core.repository.dnk.DirectionRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.DirectionValidator;
import biz.spring.core.view.dnk.DirectionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class DirectionService extends BaseService<Direction> {

    @Autowired
    private DirectionRepository directionRepository;
    @Autowired
    private DirectionValidator directionValidator;

    @PostConstruct
    protected void init() {
        init(directionRepository, directionValidator);
    }

    @Value("classpath:/script/dnk/direction/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/direction/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<DirectionView> getAll(GridDataOption gridDataOption){
        return new Query<DirectionView>(mainSql)
                .forClass(DirectionView.class)
                .setOrderBy(gridDataOption.getOrderBy())
                .execute();
    }

    public DirectionView getOne(Integer id){
        return new Query<DirectionView>(mainSqlForOne)
                .forClass(DirectionView.class)
                .executeOne(id);
    }
}
