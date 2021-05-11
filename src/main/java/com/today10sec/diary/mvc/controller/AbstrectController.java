package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import com.today10sec.diary.customize.util.AppServletUtil;
import com.today10sec.diary.customize.util.DiaryTimeUtil;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

public class AbstrectController {

    @ModelAttribute("isLogin")
    public boolean isLogin(){
        return false;
    }

    @ModelAttribute("isTest")
    public boolean isTest(HttpServletRequest request){
        return AppServletUtil.isProd(request);
    }

    protected ModelAndView setViewByYearDayData(HttpServletRequest request, ModelAndView modelAndView, String date, Optional<LocalDate> localDate) {

        LocalDate day = DiaryTimeUtil.getFirstDayOFWeek(request.getLocale(), localDate.get());
        modelAndView.addObject("firstDay",DiaryTimeUtil.getDateOnlyNumberText(day));
        int[] days = new int[7];
        String[] dayOfWeeks = new String[7];
        for (int i = 0; i < 7; i++) {
            days[i] = day.getDayOfMonth();
            dayOfWeeks[i] = day.getDayOfWeek().toString();
            day = day.plusDays(1);
        }
        modelAndView.addObject("days" ,days);
        modelAndView.addObject("dayOfWeeks",dayOfWeeks);
        modelAndView.addObject("loginUrl", DIARY_URL_ENUM.CUSTOMER_LOGIN.getURI());
        return modelAndView;
    }
}
