package biz.spring.core.service;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.model.DocumentTransit;
import biz.spring.core.model.DocumentType;
import biz.spring.core.repository.DocumentRealRepository;
import biz.spring.core.repository.DocumentTransitRepository;
import biz.spring.core.repository.DocumentTypeRepository;
import biz.spring.core.security.AuthenticationBean;
import biz.spring.core.security.UserDetailsImpl;
import biz.spring.core.validator.DocumentRealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

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

    @Override
    @PostConstruct
    protected void init() {
        super.init(documentRealRepository, documentRealValidator);
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
        if(documentReal.getDocumentTransitId()!=null) {
            DocumentTransit documentTransit = documentTransitRepository.get(documentReal.getDocumentTransitId());
            checkAccess(documentReal, documentTransit);
        }
        DocumentType documentType = documentTypeRepository.get(documentReal.getDocumentTypeId());
        documentReal.setDocumentRealName(documentType.getDocumentTypeName() + " №" + documentReal.getDocumentRealNumber());
        documentReal.setProgUserId(userDetails.getId());
        documentReal.setDocumentRealDateModify(new Date());
    }
}
