package biz.spring.core.service.dnk;

import biz.spring.core.model.dnk.TestHistory;
import biz.spring.core.repository.dnk.TestHistoryRepository;
import biz.spring.core.service.BaseService;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.dnk.TestHistoryValidator;
import biz.spring.core.view.dnk.TestHistoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TestHistoryService extends BaseService<TestHistory> {

    @Autowired
    private TestHistoryRepository testHistoryRepository;
    @Autowired
    private TestHistoryValidator testHistoryValidator;

    @PostConstruct
    public void init(){
        init(testHistoryRepository, testHistoryValidator);
    }
    private final String mainSql = "" +
            "SELECT * " +
            "FROM testhistory";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM testhistory " +
            "WHERE testhistory_id = :id";

    public List<TestHistoryView> getAll(){
        return new Query.QueryBuilder<TestHistoryView>(mainSql)
                .forClass(TestHistoryView.class)
                .build()
                .execute();
    }

    public TestHistoryView getOne(Integer id){
        return new Query.QueryBuilder<TestHistoryView>(mainSqlForOne)
                .forClass(TestHistoryView.class)
                .build()
                .executeOne(id);
    }

    public void save(TestHistory testHistory){
        testHistoryRepository.insert(testHistory);
    }


}
