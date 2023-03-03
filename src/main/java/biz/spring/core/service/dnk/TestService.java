package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Test;
import biz.spring.core.repository.dnk.TestRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.Query;
import biz.spring.core.view.dnk.TestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TestService extends BaseService<Test> {

    @Autowired
    private TestRepository testRepository;

    @PostConstruct
    public void init(){
        init(testRepository);
    }
    private final String mainSql = "" +
            "SELECT * " +
            "FROM test";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM test " +
            "WHERE test_id = :id";

    public List<TestView> getAll(){
        return new Query<TestView>(mainSql)
                .forClass(TestView.class)
                .execute();
    }

    public TestView getOne(Integer id){
        return new Query<TestView>(mainSqlForOne)
                .forClass(TestView.class)
                .executeOne(id);
    }

    public void save(Test test){
        testRepository.insert(test);
    }

}
