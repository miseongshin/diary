package com.today10sec.diary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class HomeController extends AbstrectController{

    @GetMapping("/")
    public RedirectView home() {
        return new RedirectView("diary/add");
    }

}
