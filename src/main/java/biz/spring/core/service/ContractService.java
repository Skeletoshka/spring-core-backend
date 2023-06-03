package biz.spring.core.service;

import biz.spring.core.model.Contract;
import biz.spring.core.repository.ContractRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.ContractValidator;
import biz.spring.core.view.ContractView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ContractService extends BaseService<Contract>{

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractValidator contractValidator;

    @PostConstruct
    public void init(){
        init(contractRepository, contractValidator);
    }

    @Value("classpath:/script/contract/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/contract/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<ContractView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ContractView>(mainSql)
                .forClass(ContractView.class, "m0")
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .build()
                .execute();
    }

    public ContractView getOne(Integer id){
        return new Query.QueryBuilder<ContractView>(mainSqlForOne)
                .forClass(ContractView.class, "m0")
                .build()
                .executeOne(id);
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean blockFound = gridDataOption.getNamedFilters().stream().anyMatch(nf ->
                "blockId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<ContractView>(mainSql)
                .forClass(ContractView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .injectSqlIf(blockFound, "/*BLOCK_PLACEHOLDER*/", "AND m0.block_id = :blockId")
                .setParams(gridDataOption.buildParams())
                .build()
                .count();
    }
}
