package com.today10sec.diary.customize.exception;

import lombok.Getter;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Validation Exception for Common Diary
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST)
@Getter
public class DiaryValidErrorException extends Exception {

    private final BindingResult bindingResult;
    private final MessageSource messageSource;

    public DiaryValidErrorException(BindingResult bindingResult, MessageSource messageSource) {
        Assert.notNull(bindingResult, "BindingResult must not be null");
        Assert.notNull(bindingResult, "BindingResult must not be null");
        this.bindingResult = bindingResult;
        this.messageSource = messageSource;
    }
}
