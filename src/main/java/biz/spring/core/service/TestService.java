package biz.spring.core.service;

import biz.spring.core.model.Test;
import biz.spring.core.repository.TestRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.TestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService extends BaseService<Test>{

    @Autowired
    private TestRepository testRepository;

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
