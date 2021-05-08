package com.today10sec.diary.mvc.controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class AbstrectController {

    final protected String DOMAIN = "today10sec";


    @ModelAttribute("isLogin")
    public boolean isLogin(){
        return false;
    }

    @ModelAttribute("isTest")
    public boolean isTest(HttpServletRequest request){
        if (DOMAIN.equals(request.getServerName())){
            return false;
        }
        return true;
    }

}
