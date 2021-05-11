package com.today10sec.diary.customize.exception;

import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

/**
 * Validation Exception for Common Diary
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
@Getter
public class DiaryValidErrorException extends Exception {

    private BindingResult bindingResult;
    private MessageSource messageSource;
    private String target;
    private String messageCode;
    private Locale locale;

    public DiaryValidErrorException(BindingResult bindingResult, MessageSource messageSource, Locale locale) {
        Assert.notNull(bindingResult, "BindingResult must not be null");
        Assert.notNull(messageSource, "messageSource must not be null");
        this.bindingResult = bindingResult;
        this.messageSource = messageSource;
        this.locale = locale;
    }

    public DiaryValidErrorException(String target, String messageCode, MessageSource messageSource, Locale locale) {
        Assert.notNull(target, "target must not be null");
        Assert.notNull(messageCode, "messageCode must not be null");
        Assert.notNull(messageSource, "messageSource must not be null");
        this.target = target;
        this.messageCode = messageCode;
        this.messageSource = messageSource;
        this.locale = locale;
    }
}
