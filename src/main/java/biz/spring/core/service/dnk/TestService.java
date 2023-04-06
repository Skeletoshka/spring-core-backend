package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Test;
import biz.spring.core.repository.dnk.TestRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.TestValidator;
import biz.spring.core.view.dnk.TestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TestService extends BaseService<Test> {

    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestValidator testValidator;

    @PostConstruct
    public void init(){
        init(testRepository, testValidator);
    }
    private final String mainSql = "" +
            "SELECT * " +
            "FROM test";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM test " +
            "WHERE test_id = :id";

    public List<TestView> getAll(){
        return new Query.QueryBuilder<TestView>(mainSql)
                .forClass(TestView.class)
                .build()
                .execute();
    }

    public TestView getOne(Integer id){
        return new Query.QueryBuilder<TestView>(mainSqlForOne)
                .forClass(TestView.class)
                .build()
                .executeOne(id);
    }

    public void save(Test test){
        testRepository.insert(test);
    }

}
