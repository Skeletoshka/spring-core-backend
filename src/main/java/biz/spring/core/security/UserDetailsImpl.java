package biz.spring.core.security;

import biz.spring.core.dto.ProgUserDTO;
import biz.spring.core.model.ProgUser;
import biz.spring.core.repository.ProgUserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.*;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private Integer progUserId;

    private Integer peopleId;

    private String username;

    private String progUserFullName;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Integer progUserId,
                           String username,
                           String progUserFullName,
                           String password,
                           Integer peopleId,
                           Collection<? extends GrantedAuthority> authorities) {
        this.progUserId = progUserId;
        this.username = username;
        this.progUserFullName = progUserFullName;
        this.password = password;
        this.peopleId = peopleId;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(ProgUserDTO progUserDTO) {
        List<GrantedAuthority> authorities = progUserDTO.getAccessRoleViews().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAccessRoleName()))
                .collect(Collectors.toList());

        return new UserDetailsImpl(
                progUserDTO.getProgUserId(),
                progUserDTO.getProgUserName(),
                progUserDTO.getProgUserFullName(),
                progUserDTO.getProgUserPassword(),
                progUserDTO.getPeopleId(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Integer getProgUserId() {
        return progUserId;
    }

    public String getProgUserFullName() {
        return progUserFullName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(progUserId, user.progUserId);
    }
}
