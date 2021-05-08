package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import com.today10sec.diary.customize.util.DiaryTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/diary")
public class DiaryController extends AbstrectController{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * view
     *
     * @return RedirectView /view/{yyyyMMdd}
     */
    @GetMapping("/view")
    public RedirectView view(){

        String redirectUrl = DIARY_URL_ENUM.DIARY_VIEW.getTodayViewUrl();
        return new RedirectView(redirectUrl);
    }

    /**
     * viewByYearDay
     * @param date find day
     * @param request
     * @return
     */
    @GetMapping({"/view/{date}", "/view/{date}/**"})
    public ModelAndView viewByYearDay(@PathVariable("date") String date
    , HttpServletRequest request){


        Optional<LocalDate> localDate  = DiaryTimeUtil.getLocalDate(date);
        if (!localDate.isPresent())
            return new ModelAndView("redirect:"+DIARY_URL_ENUM.DIARY_VIEW.getUrl()+ DiaryTimeUtil.getTodayOnlyNumberText());

        ModelAndView modelAndView = new ModelAndView("diary/view");
        modelAndView = setViewByYearDayData(request, modelAndView, date, localDate);

        if(isLogin()){
            //[TODO]로그인 프로세스 완료시
            //modelAndView.addObject("isLogin", true);
        } else {
            //modelAndView.addObject("isLogin", true);
        }
        return modelAndView;
    }

    private ModelAndView setViewByYearDayData(HttpServletRequest request, ModelAndView modelAndView, String date, Optional<LocalDate> localDate) {


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
        modelAndView.addObject("loginUrl",DIARY_URL_ENUM.CUSTOMER_LOGIN.getUrl());
        return modelAndView;
    }

}
