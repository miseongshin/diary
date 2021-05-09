
package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import com.today10sec.diary.customize.exception.DiaryValidErrorException;
import com.today10sec.diary.customize.util.DiaryTimeUtil;
import com.today10sec.diary.customize.validator.Sequences;
import com.today10sec.diary.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * UserController
 *
 * 로그인, 회원가입
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends AbstrectController{

    protected CustomerService customerService;
    protected MessageSource messageSource;



    @GetMapping("/login")
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView(DIARY_URL_ENUM.CUSTOMER_LOGIN.getJspPath());
        modelAndView.addObject("customerAddUrl",DIARY_URL_ENUM.CUSTOMER_SIGN_UP.getUrl());
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(){

        if (isLogin()){
            return new ModelAndView("redirect:"+DIARY_URL_ENUM.DIARY_VIEW.getUrl()+ DiaryTimeUtil.getTodayOnlyNumberText());
        }

        ModelAndView modelAndView = new ModelAndView(DIARY_URL_ENUM.CUSTOMER_SIGN_UP.getJspPath());
        modelAndView.addObject("customerLoginUrl",DIARY_URL_ENUM.CUSTOMER_LOGIN.getUrl());
        modelAndView.addObject("customerAddAjaxUrl",DIARY_URL_ENUM.CUSTOMER_SIGN_UP_AJAX.getUrl());

        return modelAndView;
    }

    @PostMapping("/signUp/ajax")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> signUpAjax(HttpServletRequest request, @Validated(Sequences.class) @RequestBody CustomerSignUpData customerSignUpData, BindingResult bindingResult) throws DiaryValidErrorException {

        if (bindingResult.hasErrors()) {
            throw new DiaryValidErrorException(bindingResult, messageSource);
        }

        boolean result = customerService.saveCustomer(customerSignUpData);


        return ResponseEntity.ok(result);
    }


    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public CustomerService getCustomerService() {
        return customerService;
    }
}
