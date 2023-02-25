package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.repository.dnk.PeopleRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.Query;
import biz.spring.core.view.dnk.PeopleView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleService extends BaseService<People> {

    @Autowired
    private PeopleRepository peopleRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM people";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM people " +
            "WHERE people_id = :id";

    public List<PeopleView> getAll(){
        return new Query<PeopleView>(mainSql)
                .forClass(People.class)
                .execute();
    }

    public PeopleView getOne(Integer id){
        return new Query<PeopleView>(mainSqlForOne)
                .forClass(PeopleView.class)
                .executeOne(id);
    }

    public void save(People people){
        peopleRepository.insert(people);
    }
}
