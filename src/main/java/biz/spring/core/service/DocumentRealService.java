package biz.spring.core.service;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.DocumentTransit;
import biz.spring.core.model.DocumentType;
import biz.spring.core.repository.DocumentRealRepository;
import biz.spring.core.repository.DocumentTransitRepository;
import biz.spring.core.repository.DocumentTypeRepository;
import biz.spring.core.security.AuthenticationBean;
import biz.spring.core.security.UserDetailsImpl;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.DocumentRealValidator;
import biz.spring.core.view.CapClassView;
import biz.spring.core.view.DocumentRealView;
import biz.spring.core.view.ProgUserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class DocumentRealService extends BaseService<DocumentReal>{

    @Autowired
    private DocumentRealRepository documentRealRepository;
    @Autowired
    private DocumentRealValidator documentRealValidator;
    @Autowired
    private DocumentTransitRepository documentTransitRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private AuthenticationBean authenticationBean;
    @Value("classpath:/script/documentreal/mainSql.sql")
    Resource mainSQL;
    @Value("classpath:/script/documentreal/mainSqlForOne.sql")
    Resource mainSQLForOne;

    @Override
    @PostConstruct
    protected void init() {
        super.init(documentRealRepository, documentRealValidator);
    }

    public List<DocumentRealView> getAll(GridDataOption gridDataOption){
        boolean documentTypeFound = gridDataOption.getNamedFilters().stream().anyMatch(nf ->
                "documentTypeId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<DocumentRealView>(mainSQL)
                .forClass(DocumentRealView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(documentTypeFound, "/*DOCUMENTTYPE_PLACEHOLDER*/", "AND m0.documenttype_id = :documentTypeId")
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        boolean documentTypeFound = gridDataOption.getNamedFilters().stream().anyMatch(nf ->
                "documentTypeId".equals(nf.getName()) && !nf.getValue().equals(-1));
        return new Query.QueryBuilder<DocumentRealView>(mainSQL)
                .forClass(DocumentRealView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .injectSqlIf(documentTypeFound, "/*DOCUMENTTYPE_PLACEHOLDER*/", "AND m0.documenttype_id = :documentTypeId")
                .build()
                .count();
    }

    public DocumentRealView getOne(Integer id){
        return new Query.QueryBuilder<DocumentRealView>(mainSQLForOne)
                .forClass(DocumentRealView.class, "m0")
                .build()
                .executeOne(id);
    }

    public void setStatus(Integer documentRealId, Integer statusId){
        DocumentTransit documentTransit = documentTransitRepository.get(statusId);
        DocumentReal documentReal = documentRealRepository.get(documentRealId);
        checkAccess(documentReal, documentTransit);
        documentRealRepository.setStatus(documentRealId, statusId);
    }

    private void checkAccess(DocumentReal documentReal, DocumentTransit documentTransit){
        if(!documentReal.getDocumentTypeId().equals(documentTransit.getDocumentTypeId())){
            throw new RuntimeException(String.format("У документа %s нельзя установить статус %s",
                    documentReal.getDocumentRealNumber(), documentTransit.getDocumentTransitName()));
        }
    }

    @Override
    protected void beforeValidate(DocumentReal documentReal){
        UserDetailsImpl userDetails = (UserDetailsImpl) authenticationBean.getCurrentUserDetails();
        boolean insertFlag = documentReal.getDocumentRealId() == null;
        if(documentReal.getDocumentTransitId()!=null) {
            DocumentTransit documentTransit = documentTransitRepository.get(documentReal.getDocumentTransitId());
            checkAccess(documentReal, documentTransit);
        }
        if(insertFlag){
            documentReal.setProgUserId(userDetails.getProgUserId());
            documentReal.setDocumentRealDateCreate(new Date());
        }else{
            DocumentReal prevEntity = documentRealRepository.get(documentReal.getDocumentRealId());
            documentReal.setProgUserId(prevEntity.getProgUserId());
            documentReal.setDocumentRealDateCreate(prevEntity.getDocumentRealDateCreate());
            documentReal.setDocumentTransitId(prevEntity.getDocumentTransitId());
        }
        documentReal.setDocumentRealDateModify(new Date());
        DocumentType documentType = documentTypeRepository.get(documentReal.getDocumentTypeId());
        documentReal.setDocumentRealName(documentType.getDocumentTypeName() + " №" + documentReal.getDocumentRealNumber());
    }
}
