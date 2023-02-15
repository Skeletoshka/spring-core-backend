package biz.spring.core.service;

import biz.spring.core.model.Answer;
import biz.spring.core.repository.AnswerRepository;
import biz.spring.core.repository.TestRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AnswerView;
import biz.spring.core.view.TestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService extends BaseService<Answer>{

    @Autowired
    private AnswerRepository answerRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM answer";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM answer " +
            "WHERE answer_id = :id";

    public List<AnswerView> getAll(){
        return new Query<AnswerView>(mainSql)
                .forClass(AnswerView.class)
                .execute();
    }

    public AnswerView getOne(Integer id){
        return new Query<AnswerView>(mainSqlForOne)
                .forClass(AnswerView.class)
                .executeOne(id);
    }

    public void save(Answer answer){
        answerRepository.insert(answer);
    }

}
