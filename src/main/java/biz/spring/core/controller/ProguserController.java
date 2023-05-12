package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.ProgUser;
import biz.spring.core.repository.ProgUserRepository;
import biz.spring.core.response.DataResponse;
import biz.spring.core.security.JwtUtils;
import biz.spring.core.service.BaseService;
import biz.spring.core.service.ProgUserService;
import biz.spring.core.utils.GridDataOption;
import biz.spring.core.view.ProgUserView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Контроллер для пользователей", description = "Контроллер для взаимодействия с объектом \"Пользователь\"")
@RequestMapping(value = "/v" + Config.CURRENT_VERSION + "/apps/objects",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
@Transactional
public class ProguserController {

    @Autowired
    private ProgUserService progUserService;
    @Autowired
    private ProgUserRepository progUserRepository;
    @Autowired
    PasswordEncoder encoder;

    static class GridDataOptionProguser extends GridDataOption {
        @Schema(description = "" +
                "<ul>" +
                "<ul>")
        public List<NamedFilter> getNamedFilters(){
            return super.getNamedFilters();
        }
    }

    @RequestMapping(value = "/proguser/getlist", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения списка объектов \"Пользователь\"", description = "Возвращает список объектов " +
            "\"Пользователь\" согласно переданным параметрам")
    public DataResponse<ProgUserView> getList(@RequestBody GridDataOptionProguser gridDataOption){
        List<ProgUserView> result = progUserService.getAll(gridDataOption);
        Integer count = progUserService.getCount(gridDataOption);
        return BaseService.buildResponse(result, gridDataOption, count);
    }

    @RequestMapping(value = "/proguser/get", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения объекта \"Пользователь\"", description = "Возвращает объект " +
            "\"Пользователь\" по его id. Если id null, то возвращается пустой пользователь")
    public ProgUserDTO get(@RequestBody(required = false) Integer id){
        if(id == null){
            return new ProgUserDTO();
        }else{
            ProgUserView view = progUserService.getOne(id);
            ProgUserDTO dto = new ProgUserDTO();
            BeanUtils.copyProperties(view, dto);
            buildItems(dto);
            return dto;
        }
    }

    @RequestMapping(value = "/proguser/save", method = RequestMethod.POST)
    @Operation(summary = "Метод для сохранения объекта \"Пользователь\"", description = "Если идентификатор пустой, то " +
            "производится вставка, иначе проивзодится сохранение")
    public ProgUserView save(@RequestBody ProgUserDTO dto){
        ProgUser result;
        dto.setProgUserPassword(encoder.encode(dto.getProgUserPassword()));
        if(dto.getProgUserId()==null){
            result = progUserService.add(dto.toEntity());
            progUserRepository.createToken(result.getProgUserId(), JwtUtils.createToken());
        }else{
            result = progUserService.edit(dto.toEntity());
        }
        progUserService.updateRoles(result.getProgUserId(), dto.getAccessRoleViews());
        return progUserService.getOne(result.getProgUserId());
    }

    @RequestMapping(value = "/proguser/delete", method = RequestMethod.POST)
    @Operation(summary = "Метод для удаления объектов \"Пользователь\"", description = "Удаляет все записи с переданными " +
            "идентификаторами")
    public String delete(@RequestBody int[] ids){
        progUserService.delete(ids);
        return BaseService.STANDARD_SUCCESS;
    }

    public void buildItems(ProgUserDTO dto){
        dto.setAccessRoleViews(progUserService.getRoleByUserId(dto.getProgUserId()));
    }
}
