package main.springMVC.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserTagConstraintValidator implements ConstraintValidator<UserTag, String> {

    private String tagPrefix;

    @Override
    public void initialize(UserTag userTag) {
        tagPrefix = userTag.value();
    }

    @Override
    public boolean isValid(String tag, ConstraintValidatorContext constraintValidatorContext) {
        if(tag == null){
            return false;
        }

        boolean result = tag.startsWith(tagPrefix);
        return result;
    }
}
