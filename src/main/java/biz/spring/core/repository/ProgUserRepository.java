package biz.spring.core.repository;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.ControlObject;
import biz.spring.core.model.ProgUser;
import biz.spring.core.view.ProgUserView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProgUserRepository implements TableRepository<ProgUser> {

    @Autowired
    AccessRoleRepository accessRoleRepository;

    public ProgUserDTO findByLogin(String login){
        ProgUser progUser = getAll().stream().filter(pu -> pu.getProgUserName().equals(login)).findFirst().orElse(null);
        ProgUserDTO dto = new ProgUserDTO();
        BeanUtils.copyProperties(progUser, dto);
        dto.setAccessRoleViews(accessRoleRepository.getRolesForProguserId(dto.getProgUserId()));
        return dto;
    }
}
