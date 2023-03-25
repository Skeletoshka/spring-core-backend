package biz.spring.core.validator.dnk;

import biz.spring.core.model.dnk.People;
import biz.spring.core.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

@Component
public class PeopleValidator implements Validator {
    @Autowired
    private javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return People.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> validates =  validator.validate(o);
        ValidateUtils.fillErrors(errors, validates);
    }
}
