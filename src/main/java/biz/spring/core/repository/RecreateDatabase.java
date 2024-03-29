package biz.spring.core.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class RecreateDatabase {

    @Autowired
    private AccessRoleRepository accessRoleRepository;
    @Autowired
    private ControlObjectRepository controlObjectRepository;
    @Autowired
    private ProgUserRepository progUserRepsitory;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentTransitRepository documentTransitRepository;
    @Autowired
    private DocumentRealRepository documentRealRepository;
    @Autowired
    private CapClassRepository capClassRepository;
    @Autowired
    private CapClassTypeRepository capClassTypeRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AppendixRepository appendixRepository;
    @Autowired
    private ContractRepository contractRepository;


    public void recreate(){
        TableRepository[] repositories = {
                progUserRepsitory,
                accessRoleRepository,
                controlObjectRepository,
                documentTypeRepository,
                documentTransitRepository,
                documentRealRepository,
                capClassRepository,
                capClassTypeRepository,
                companyRepository,
                addressRepository,
                appendixRepository,
                contractRepository
                //TODO регистрация репозитория. Строго в порядке создания таблиц
        };
        Arrays.stream(repositories).forEach(repo->{
            repo.drop();
            repo.create();
            repo.load();
        });
    }
}
