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
    private PostRepository postRepository;
    @Autowired
    private TestRepository testRepository;


    public void recreate(){
        TableRepository[] repositories = {
                postRepository,
                accessRoleRepository,
                progUserRepsitory,
                accessRoleRepository,
                controlObjectRepository,
                testRepository
                //TODO регистрация репозитория. Строго в порядке создания таблиц
        };
        Arrays.stream(repositories).forEach(repo->{
            repo.drop();
            repo.create();
            repo.load();
        });
    }
}
