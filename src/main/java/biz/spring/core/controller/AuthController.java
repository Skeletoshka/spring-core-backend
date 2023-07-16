package biz.spring.core.controller;

import biz.spring.core.config.Config;
import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.payload.request.LoginRequest;
import biz.spring.core.payload.request.SignupRequest;
import biz.spring.core.payload.response.JwtResponse;
import biz.spring.core.payload.response.MessageResponse;
import biz.spring.core.repository.AccessRoleRepository;
import biz.spring.core.repository.ProgUserRepository;
import biz.spring.core.security.JwtUtils;
import biz.spring.core.security.UserDetailsImpl;
import biz.spring.core.service.ProgUserService;
import biz.spring.core.view.AccessRoleView;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Tag(name = "Контроллер для аутентификации", description = "Контроллер для регистрации и авторизации пользователя " +
        "в системе.")
@RequestMapping(value ="/security/v" + Config.CURRENT_VERSION + "/apps/auth",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ProgUserRepository progUserRepository;

    @Autowired
    ProgUserService progUserService;

    @Autowired
    AccessRoleRepository accessRoleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    @Operation(summary = "Метод для авторизации", description = "Возвращается данные пользователя с его токеном доступа")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.getToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getProgUserId(),
                userDetails.getUsername(),
                userDetails.getProgUserFullName(),
                userDetails.getPeopleId(),
                roles));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @Operation(summary = "Метод для регистрации нового пользователя", description = "Возвращается сообщение о успешности/" +
            "неуспешности регистрации")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (progUserRepository.findByLogin(signUpRequest.getUsername()) != null) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        ProgUserDTO progUserDTO = new ProgUserDTO();
        progUserDTO.setProgUserName(signUpRequest.getUsername());
        progUserDTO.setProgUserFullName(signUpRequest.getEmail());
        progUserDTO.setProgUserPassword(encoder.encode(signUpRequest.getPassword()));
        progUserDTO.setProgUserActive(1);

        List<AccessRoleView> strRoles = signUpRequest.getRole();

        progUserDTO.setAccessRoleViews(strRoles);
        progUserService.saveUser(progUserDTO);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @RequestMapping(value = "/getroles", method = RequestMethod.POST)
    @Operation(summary = "Метод для получения ролей", description = "Возвращает доступные роли пользователя для регистрации в системе")
    private List<AccessRoleView> getRoles(){
        return accessRoleRepository.getAll().stream().filter(role -> role.getAccessRoleVisible().equals(1)).map(role -> {
            AccessRoleView view = new AccessRoleView();
            BeanUtils.copyProperties(role, view);
            return view;
        }).collect(Collectors.toList());
    }
}