package biz.spring.core.service;

import biz.spring.core.model.TestHistory;
import biz.spring.core.repository.TestHistoryRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.TestHistoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestHistoryService extends BaseService<TestHistory>{

    @Autowired
    private TestHistoryRepository testHistoryRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM testhistory";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM testhistory " +
            "WHERE testhistory_id = :id";

    public List<TestHistoryView> getAll(){
        return new Query<TestHistoryView>(mainSql)
                .forClass(TestHistoryView.class)
                .execute();
    }

    public TestHistoryView getOne(Integer id){
        return new Query<TestHistoryView>(mainSqlForOne)
                .forClass(TestHistoryView.class)
                .executeOne(id);
    }

    public void save(TestHistory testHistory){
        testHistoryRepository.insert(testHistory);
    }


}
