package biz.spring.core.service;

import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ControlObject;
import biz.spring.core.repository.ControlObjectRepository;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ControlObjectView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlObjectService extends BaseService<ControlObject> {

    private ControlObjectRepository controlObjectRepository;

    private final String mainSql = "" +
            "SELECT * " +
            "FROM controlobject";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM controlobject " +
            "WHERE controlobject_id = :id";

    public List<ControlObjectView> getAll(){
        return new Query<ControlObjectView>(mainSql)
                .forClass(ControlObjectView.class)
                .execute();
    }

    public ControlObjectView getOne(Integer id){
        return new Query<ControlObjectView>(mainSqlForOne)
                .forClass(ControlObjectView.class)
                .executeOne(id);
    }

    public void save(ControlObject controlObject){
        controlObjectRepository.insert(controlObject);
    }
}
