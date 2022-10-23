package biz.spring.core.security;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.ProgUser;
import biz.spring.core.repository.ProgUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsImpl implements UserDetailsService {

    @Autowired
    private ProgUserRepository progUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ProgUserDTO dto = progUserRepository.findByLogin(username);
        if(dto.getProgUserId() == null){
            throw new UsernameNotFoundException("User " + username + " doesn't exist in database");
        }
        return new User(dto.getProgUserName(), dto.getProgUserWebPassword(), dto.getAccessRoleViews().stream()
                .map(accessRoleView -> new SimpleGrantedAuthority(accessRoleView.getAccessRoleName()))
                .collect(Collectors.toList()));
    }
}
