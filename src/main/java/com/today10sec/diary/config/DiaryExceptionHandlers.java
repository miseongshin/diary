package com.today10sec.diary.config;

import com.today10sec.diary.customize.dto.ValidErrorData;
import com.today10sec.diary.customize.dto.ValidErrorResultData;
import com.today10sec.diary.customize.exception.DiaryValidErrorException;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class DiaryExceptionHandlers {

    @ResponseBody
    @ExceptionHandler(DiaryValidErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidErrorResultData ValidErrorExceptionHandler (DiaryValidErrorException diaryValidErrorException){

        MessageSource messageSource = diaryValidErrorException.getMessageSource();
        BindingResult bindingResult = diaryValidErrorException.getBindingResult();

        List<ValidErrorData> errorDataList = bindingResult.getFieldErrors()
                .stream().map(error-> new ValidErrorData(error, messageSource)
                ).collect(Collectors.toList());

        return new ValidErrorResultData(errorDataList);
    }
}
