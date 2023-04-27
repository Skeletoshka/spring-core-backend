package biz.spring.core.service;

import biz.spring.core.dto.ControlObjectRoleDTO;
import biz.spring.core.model.AccessRole;
import biz.spring.core.model.ControlObject;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.repository.ControlObjectRepository;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.utils.Query;
import biz.spring.core.validator.ControlObjectValidator;
import biz.spring.core.view.AccessRoleView;
import biz.spring.core.view.ControlObjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ControlObjectService extends BaseService<ControlObject> {

    @Autowired
    private ControlObjectRepository controlObjectRepository;

    @Autowired
    private ControlObjectValidator controlObjectValidator;

    @Autowired
    private AccessRoleRepository accessRoleRepository;

    @PostConstruct
    public void init(){
        init(controlObjectRepository, controlObjectValidator);
    }

    @Value("classpath:/script/controlobject/mainSql.sql")
    Resource mainSql;

    @Value("classpath:/script/controlobject/mainSqlForOne.sql")
    Resource mainSqlForOne;

    public List<ControlObjectView> getAll(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ControlObjectView>(mainSql)
                .forClass(ControlObjectView.class, "m0")
                .setLimit(gridDataOption.buildPageRequest())
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .execute();
    }

    public Integer getCount(GridDataOption gridDataOption){
        return new Query.QueryBuilder<ControlObjectView>(mainSql)
                .forClass(ControlObjectView.class, "m0")
                .setOrderBy(gridDataOption.getOrderBy())
                .setParams(gridDataOption.buildParams())
                .setSearch(gridDataOption.getSearch())
                .build()
                .count();
    }

    public void insertAccess(ControlObjectRoleDTO dto){
        controlObjectRepository.bindWithRole(dto.getAccessRoleId(),
                dto.getControlObjects().stream().map(ControlObject::getControlObjectId).collect(Collectors.toList()));
    }

    public void deleteAccess(ControlObjectRoleDTO dto){
        controlObjectRepository.unbindWithRole(dto.getAccessRoleId(),
                dto.getControlObjects().stream().map(ControlObject::getControlObjectId).collect(Collectors.toList()));
    }
}
