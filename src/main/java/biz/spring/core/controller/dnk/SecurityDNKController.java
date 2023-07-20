package biz.spring.core.controller.dnk;

import biz.spring.core.config.Config;
import biz.spring.core.controller.CompanyController;
import biz.spring.core.dto.dnk.RegistryUserDTO;
import biz.spring.core.model.Company;
import biz.spring.core.model.ProgUser;
import biz.spring.core.model.dnk.People;
import biz.spring.core.payload.response.MessageResponse;
import biz.spring.core.repository.ProgUserRepository;
import biz.spring.core.response.DataResponse;
import biz.spring.core.security.JwtUtils;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.CompanyService;
import biz.spring.core.service.ProgUserService;
import biz.spring.core.service.dnk.PeopleService;
import biz.spring.core.service.dnk.StudentService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.CompanyView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Tag(name = "Контроллер для аутентификации в ДНК", description = "Контроллер для регистрации и авторизации пользователя " +
        "в системе ДНК.")
@RequestMapping(value ="/security/v" + Config.CURRENT_VERSION + "/apps/auth",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SecurityDNKController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ProgUserService progUserService;

    @Autowired
    private ProgUserRepository progUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/registeruser", method = RequestMethod.POST)
    @Operation(summary = "Метод для регистрации нового пользователя", description = "Возвращается сообщение о успешности/" +
            "неуспешности регистрации")
    public String registryUser(@RequestBody RegistryUserDTO registryUserDTO){
        if (progUserRepository.findByLogin(registryUserDTO.getProgUserName()) != null) {
            throw new RuntimeException("Имя пользователя занято");
        }
        People parent = new People();
        People child = new People();
        if(registryUserDTO.getAccessRoleId().equals(RegistryUserDTO.CHILD_ROLE) || registryUserDTO.getAccessRoleId().equals(RegistryUserDTO.PEOPLE_ROLE)) {
            parent = peopleService.add(registryUserDTO.toParent());
            child = peopleService.add(registryUserDTO.toChild());
            peopleService.bindFamily(parent.getPeopleId(), child.getPeopleId());
        }

        ProgUser progUser = registryUserDTO.toProgUser();
        progUser.setProgUserPassword(encoder.encode(progUser.getProgUserPassword()));
        progUser.setPeopleId(registryUserDTO.getAccessRoleId().equals(RegistryUserDTO.CHILD_ROLE)?child.getPeopleId():
                registryUserDTO.getAccessRoleId().equals(RegistryUserDTO.PEOPLE_ROLE)?parent.getPeopleId():null);
        progUser = progUserService.add(progUser);
        progUserRepository.createToken(progUser.getProgUserId(), JwtUtils.createToken());
        progUserRepository.bindWithRoles(Collections.singletonList(registryUserDTO.getAccessRoleId()), progUser.getProgUserId());

        if(registryUserDTO.getAccessRoleId().equals(RegistryUserDTO.COMPANY_ROLE)){
            Company company = registryUserDTO.toCompany();
            company.setProgUserId(progUser.getProgUserId());
        }

        return BaseService.STANDARD_SUCCESS;
    }

    static class GridDataOptionCompanyDNK extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @Operation(summary = "Возвращает список объектов \"Компания\"",
            description = "Вовзращает список объектов согласно переданным фильтрам")
    @RequestMapping(value = "/company/getlist", method = RequestMethod.POST)
    public DataResponse<CompanyView> getList(@RequestBody GridDataOptionCompanyDNK gridDataOption){
        List<CompanyView> result = companyService.getAll(gridDataOption);
        Integer count = companyService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

}
