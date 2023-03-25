package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Block;
import biz.spring.core.repository.dnk.BlockRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.BlockValidator;
import biz.spring.core.view.dnk.BlockView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BlockService extends BaseService<Block> {

    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private BlockValidator blockValidator;

    @PostConstruct
    public void init(){
        init(blockRepository, blockValidator);
    }

    private final String mainSql = "" +
            "SELECT * " +
            "FROM block";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM block " +
            "WHERE block_id = :id";

    public List<BlockView> getAll(GridDataOption gridDataOption) {
        boolean findBlock = gridDataOption.getNamedFilters().stream().anyMatch(nf -> "blockId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query<BlockView>(mainSql)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy("blockId")
                .injectSqlIf(findBlock, "/*BLOCK PROGRAM_PLACEHOLDER*/", " AND block_id = :blockId")
                .forClass(BlockView.class)
                .execute();
    }

    public BlockView getOne(Integer id){
        return new Query<BlockView>(mainSqlForOne)
                .forClass(BlockView.class)
                .executeOne(id);
    }
}
