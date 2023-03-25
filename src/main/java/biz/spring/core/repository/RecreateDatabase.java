package biz.spring.core.repository;

import biz.spring.core.model.dnk.People;
import biz.spring.core.repository.dnk.PeopleRepository;
import biz.spring.core.repository.dnk.StudyProgramRepository;
import biz.spring.core.repository.dnk.TestRepository;
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
    private PostRepository postRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentTransitRepository documentTransitRepository;
    @Autowired
    private DocumentRealRepository documentRealRepository;
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private StudyProgramRepository studyProgramRepository;
    @Autowired
    private PeopleRepository peopleRepository;


    public void recreate(){
        TableRepository[] repositories = {
                postRepository,
                accessRoleRepository,
                progUserRepsitory,
                accessRoleRepository,
                controlObjectRepository,
                testRepository,
                studyProgramRepository,
                peopleRepository,
                controlObjectRepository,
                documentTypeRepository,
                documentTransitRepository,
                documentRealRepository
                //TODO регистрация репозитория. Строго в порядке создания таблиц
        };
        Arrays.stream(repositories).forEach(repo->{
            repo.drop();
            repo.create();
            repo.load();
        });
    }
}
