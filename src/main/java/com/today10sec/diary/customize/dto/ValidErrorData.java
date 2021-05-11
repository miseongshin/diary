package com.today10sec.diary.customize.dto;

import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import java.util.Locale;

@Getter
public class ValidErrorData {


    private String fieldName;
    private String message;

    public ValidErrorData(FieldError fieldError, MessageSource messageSource, Locale locale){
        this.fieldName = fieldError.getField();
        this.message = messageSource.getMessage(fieldError.getCodes()[0],fieldError.getArguments(),fieldError.getDefaultMessage()+"["+fieldError.getCodes()[0]+"]",locale);
    }

    public ValidErrorData(String fieldName, String messageCode , MessageSource messageSource, Locale locale){
        this.fieldName =fieldName;
        this.message = messageSource.getMessage(messageCode,null,"",locale);
    }

}
