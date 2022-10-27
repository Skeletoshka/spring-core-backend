package biz.spring.core.annotations;


import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority('SYSDBA')")
public @interface CheckAdminRole {
}
