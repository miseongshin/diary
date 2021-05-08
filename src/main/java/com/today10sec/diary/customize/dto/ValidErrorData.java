package com.today10sec.diary.customize.dto;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import java.util.Locale;

@Getter
public class ValidErrorData {

    Locale locale;

    private String fieldName;
    private String message;

    public ValidErrorData(FieldError fieldError, MessageSource messageSource){
        this.fieldName = fieldError.getField();
        this.message = messageSource.getMessage(fieldError.getCodes()[0],fieldError.getArguments(),fieldError.getDefaultMessage()+"["+fieldError.getCodes()[0]+"]",locale);
    }

    @Autowired
    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
