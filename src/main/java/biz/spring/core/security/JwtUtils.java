package biz.spring.core.security;

import biz.spring.core.repository.ProgUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Autowired
    private ProgUserRepository progUserRepository;

    public String getToken(Authentication authentication) {
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        return progUserRepository.getTokenByUsername(userPrincipal.getUsername());
    }

    public static String createToken() {
        return UUID.randomUUID().toString();
    }

    public String getUserNameFromJwtToken(String token) {
        String userName = progUserRepository.getUsernameByToken(token);
        if(userName != null){
            return userName;
        }else{
            throw new RuntimeException("Пользователь не найден");
        }
    }

    public boolean validateJwtToken(String authToken) {
        return getUserNameFromJwtToken(authToken) != null;
    }
}
