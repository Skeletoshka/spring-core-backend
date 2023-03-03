package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.Answer;
import biz.spring.core.repository.dnk.AnswerRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.Query;
import biz.spring.core.view.dnk.AnswerView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class AnswerService extends BaseService<Answer> {

    @Autowired
    private AnswerRepository answerRepository;

    @PostConstruct
    public void init(){
        init(answerRepository);
    }

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
