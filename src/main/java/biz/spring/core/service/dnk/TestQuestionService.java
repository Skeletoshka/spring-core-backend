package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.TestQuestion;
import biz.spring.core.repository.dnk.TestQuestionRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.Query;
import biz.spring.core.view.dnk.TestQuestionView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestQuestionService extends BaseService<TestQuestion> {

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