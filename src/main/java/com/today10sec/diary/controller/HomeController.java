package com.today10sec.diary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController extends AbstrectController{

    @GetMapping("/")
    public ModelAndView home(Map<String, Object> model){

        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

}
