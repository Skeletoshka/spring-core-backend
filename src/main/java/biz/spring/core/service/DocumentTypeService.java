package biz.spring.core.service;

import biz.spring.core.repository.DocumentTypeRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.DocumentTypeValidator;
import biz.spring.core.view.DocumentTypeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentTypeValidator documentTypeValidator;

    @Value("classpath:/script/documenttype/mainSql.sql")
    Resource mainSql;

    public List<DocumentTypeView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<DocumentTypeView>(mainSql)
                .forClass(DocumentTypeView.class, "m0")
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<DocumentTypeView>(mainSql)
                .forClass(DocumentTypeView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setSearch(gridDataOption.getSearch())
                .build()
                .count();
    }
}
