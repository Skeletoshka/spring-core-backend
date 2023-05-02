package biz.spring.core.validator.dnk;

import biz.spring.core.model.dnk.Attendance;
import biz.spring.core.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public class AttendanceValidator implements Validator {
    @Autowired
    javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Attendance.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> validates =  validator.validate(o);
        ValidateUtils.fillErrors(errors, validates);
    }
}
