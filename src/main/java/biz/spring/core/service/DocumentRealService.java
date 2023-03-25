package biz.spring.core.service;

import biz.spring.core.model.DocumentReal;
import biz.spring.core.repository.DocumentRealRepository;
import biz.spring.core.validator.DocumentRealValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentRealService extends BaseService<DocumentReal>{

    @Autowired
    private DocumentRealRepository documentRealRepository;
    @Autowired
    private DocumentRealValidator documentRealValidator;

    @Override
    protected void init() {
        super.init(documentRealRepository, documentRealValidator);
    }
}
