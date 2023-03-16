package biz.spring.core.service;

import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ControlObject;
import biz.spring.core.repository.ControlObjectRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ControlObjectView;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ControlObjectService extends BaseService<ControlObject> {

    private ControlObjectRepository controlObjectRepository;

    @PostConstruct
    public void init(){
        init(controlObjectRepository);
    }

    private final String mainSql = "" +
            "SELECT * " +
            "FROM   controlobject co " +
            "       LEFT JOIN controlobjectrole cor ON co.controlobject_id = cor.controlobject_id " +
            "WHERE  1=1 " +
            "  AND  cor.accessrole_id = :accessRoleId";

    private final String mainSqlForOne = "" +
            "SELECT * " +
            "FROM controlobject " +
            "WHERE controlobject_id = :id";

    public List<ControlObjectView> getAll(GridDataOption gridDataOption){
        return new Query<ControlObjectView>(mainSql)
                .forClass(ControlObjectView.class)
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .execute();
    }

    public ControlObjectView getOne(Integer id){
        return new Query<ControlObjectView>(mainSqlForOne)
                .forClass(ControlObjectView.class)
                .executeOne(id);
    }
}
