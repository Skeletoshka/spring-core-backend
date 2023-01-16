package biz.spring.core.service;

import biz.spring.core.model.PeopleTest;
import biz.spring.core.model.TestQuestion;
import biz.spring.core.repository.PeopleTestRepository;
import biz.spring.core.repository.TestQuestionRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.PeopleTestView;
import biz.spring.core.view.TestQuestionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestQuestionService extends BaseService<TestQuestion>{

    @Autowired
    private TestQuestionRepository testQuestionRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM testquestion";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM testquestion " +
            "WHERE testquestion_id = :id";

    public List<TestQuestionView> getAll(){
        return new Query<TestQuestionView>(mainSql)
                .forClass(TestQuestionView.class)
                .execute();
    }

    public TestQuestionView getOne(Integer id){
        return new Query<TestQuestionView>(mainSqlForOne)
                .forClass(TestQuestionView.class)
                .executeOne(id);
    }

    public void save(TestQuestion testQuestion){
        testQuestionRepository.insert(testQuestion);
    }
}