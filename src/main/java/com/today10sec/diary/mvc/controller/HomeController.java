package com.today10sec.diary.mvc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class HomeController extends AbstrectController{

    @GetMapping("/")
    public ModelAndView home() {

        return new ModelAndView("forward:/diary/view");
    }

}
