package com.today10sec.diary.customize.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Constraint(validatedBy = SameValueValidator.class)
public @interface SameValue {

    String field();

    String fieldMatch();

    String message() default "{come.today10sec.diary.error.valid.samePassword}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}