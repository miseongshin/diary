package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class HomeController extends AbstrectController{

    @GetMapping("/")
    public RedirectView home() {

        if (isLogin()){
            return new RedirectView(DIARY_URL_ENUM.DIARY_VIEW.getTodayViewURI());
        }
        return new RedirectView(DIARY_URL_ENUM.SAMPLE.getTodayViewURI());
    }

}
