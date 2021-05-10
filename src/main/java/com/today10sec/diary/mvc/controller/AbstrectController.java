package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.util.AppUtil;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

public class AbstrectController {

    @ModelAttribute("isLogin")
    public boolean isLogin(){
        return false;
    }

    @ModelAttribute("isTest")
    public boolean isTest(HttpServletRequest request){
        return AppUtil.isProd(request);
    }

}
