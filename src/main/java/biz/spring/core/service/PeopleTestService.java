package biz.spring.core.service;

import biz.spring.core.model.Answer;
import biz.spring.core.model.PeopleTest;
import biz.spring.core.repository.AnswerRepository;
import biz.spring.core.repository.PeopleTestRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AnswerView;
import biz.spring.core.view.PeopleTestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleTestService extends BaseService<PeopleTest>{

    @Autowired
    private PeopleTestRepository peopleTestRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM peopletest";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM peopletest " +
            "WHERE peopletest_id = :id";

    public List<PeopleTestView> getAll(){
        return new Query<PeopleTestView>(mainSql)
                .forClass(PeopleTestView.class)
                .execute();
    }

    public PeopleTestView getOne(Integer id){
        return new Query<PeopleTestView>(mainSqlForOne)
                .forClass(PeopleTestView.class)
                .executeOne(id);
    }

    public void save(PeopleTest peopleTest){
        peopleTestRepository.insert(peopleTest);
    }
}