package com.today10sec.diary.customize.validator;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class SameValueValidator implements ConstraintValidator<SameValue,Object> {

    private String field;
    private String fieldMatch;

    @Override
    public void initialize(SameValue constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.fieldMatch = constraintAnnotation.fieldMatch();

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {

        String fieldValue = String.valueOf(new BeanWrapperImpl(object).getPropertyValue(field));
        String fieldMatchValue = String.valueOf(new BeanWrapperImpl(object).getPropertyValue(fieldMatch));

        if (fieldValue == null) {
            throw new RuntimeException("fieldValue can not null");
        }else if(fieldMatchValue ==null ){
            throw new RuntimeException("fieldMatchValue can not null");
        }

        if (fieldValue.equals(fieldMatchValue)){
            return true;
        } else{

            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("message")
                    .addPropertyNode(fieldMatch)
                    .addConstraintViolation();
            return false;
        }
    }
}
