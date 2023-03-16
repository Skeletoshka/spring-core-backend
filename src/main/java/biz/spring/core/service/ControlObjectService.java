package biz.spring.core.service;

import biz.spring.core.dto.ControlObjectRoleDTO;
import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ControlObject;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.repository.ControlObjectRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ControlObjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ControlObjectService extends BaseService<ControlObject> {

    @Autowired
    private ControlObjectRepository controlObjectRepository;

    @Autowired
    private AccessRoleRepository accessRoleRepository;

    @PostConstruct
    public void init(){
        init(controlObjectRepository);
    }

    private final String mainSql = "" +
            "SELECT co.controlobject_id," +
            "       co.controlobject_url," +
            "       co.controlobject_name," +
            "       CASE WHEN cor.controlobject_id IS NOT NULL THEN 1 ELSE 0 END access_flag " +
            "FROM   controlobject co " +
            "       LEFT JOIN controlobjectrole cor ON co.controlobject_id = cor.controlobject_id " +
            "AND :accessRoleId = cor.accessrole_id";

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

    public void updateAccess(ControlObjectRoleDTO dto){
        accessRoleRepository.clearAccess(dto.getAccessRoleId());
        controlObjectRepository.bindWithRole(dto.getAccessRoleId(),
                dto.getControlObjects().stream().map(ControlObject::getControlObjectId).collect(Collectors.toList()));
    }
}
