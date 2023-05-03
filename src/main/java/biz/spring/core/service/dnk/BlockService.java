package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Block;
import biz.spring.core.repository.dnk.BlockRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.BlockValidator;
import biz.spring.core.view.dnk.BlockView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BlockService extends BaseService<Block> {

    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private BlockValidator blockValidator;

    @Value("classpath:/script/dnk/block/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/dnk/block/mainSqlForOne.sql")
    Resource mainSqlForOne;

    @PostConstruct
    public void init(){
        init(blockRepository, blockValidator);
    }


    public List<BlockView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<BlockView>(mainSql)
                .forClass(BlockView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setLimit(gridDataOption.buildPageRequest())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public BlockView getOne(Integer id){
        return new Query.QueryBuilder<BlockView>(mainSqlForOne)
                .forClass(BlockView.class, "m0")
                .build()
                .executeOne(id);
    }
}
