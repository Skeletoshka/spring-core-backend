package biz.spring.core.validator;
import biz.spring.core.model.Company;
import biz.spring.core.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public class CompanyValidator implements Validator{

    @Autowired
    private javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Company.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> validates =  validator.validate(o);
        ValidateUtils.fillErrors(errors, validates);
    }
}
