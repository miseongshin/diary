
package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.dto.CustomerData;
import com.today10sec.diary.customize.dto.CustomerSignUpData;
import com.today10sec.diary.customize.dto.ResultData;
import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import com.today10sec.diary.customize.exception.DiaryValidErrorException;
import com.today10sec.diary.customize.model.Customer;
import com.today10sec.diary.customize.util.DiaryTimeUtil;
import com.today10sec.diary.customize.validator.Sequences;
import com.today10sec.diary.mvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.converter.Converter;
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
    protected Converter<CustomerData, Customer> customerConverter;



    @GetMapping("/login")
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView("customer/login");
        modelAndView.addObject("customerAddUrl",DIARY_URL_ENUM.CUSTOMER_SIGN_UP.getURI());
        return modelAndView;
    }

    @GetMapping("/signUp")
    public ModelAndView signUp(){

        if (isLogin()){
            return new ModelAndView("redirect:"+DIARY_URL_ENUM.DIARY_VIEW.getURI()+ DiaryTimeUtil.getTodayOnlyNumberText());
        }

        ModelAndView modelAndView = new ModelAndView("customer/signUp");
        modelAndView.addObject("customerLoginUrl",DIARY_URL_ENUM.CUSTOMER_LOGIN.getURI());
        modelAndView.addObject("customerSignUp",DIARY_URL_ENUM.CUSTOMER_SIGN_UP.getURI());

        return modelAndView;
    }

    @PostMapping("/signUp")
    @ResponseBody
    public ResultData signUpAjax(HttpServletRequest request, @Validated(Sequences.class) @RequestBody CustomerSignUpData customerSignUpData, BindingResult bindingResult) throws DiaryValidErrorException {

        if (bindingResult.hasErrors()) {
            throw new DiaryValidErrorException(bindingResult, messageSource, request.getLocale());
        }

        if(customerService.isExistEmail(customerSignUpData.getEmail())){
            throw new DiaryValidErrorException("email","join.fail.already", messageSource, request.getLocale());
        }

        Customer customer = customerConverter.convert(customerSignUpData);
        int result = customerService.save(customer);

        return new ResultData(200, messageSource.getMessage("join.success",null, request.getLocale()), null);
    }


    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerConverter(Converter<CustomerData, Customer> customerConverter) {
        this.customerConverter = customerConverter;
    }
}