package biz.spring.core.annotations;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('USER', 'SYSDBA', 'ROLE_USER', 'ROLE_SYSDBA')")
public @interface CheckAnyRole {
}
