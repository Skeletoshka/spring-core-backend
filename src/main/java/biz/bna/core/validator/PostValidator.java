package biz.bna.core.validator;

import biz.bna.core.model.Post;
import biz.bna.core.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class PostValidator implements Validator {

    @Autowired
    private javax.validation.Validator validator;

    @Override
    public boolean supports(Class<?> aClass) {
        return Post.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> validates =  validator.validate(o);
        ValidateUtils.fillErrors(errors, validates);
    }
}
