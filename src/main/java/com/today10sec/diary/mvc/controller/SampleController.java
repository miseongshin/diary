package com.today10sec.diary.mvc.controller;

import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import com.today10sec.diary.customize.util.DiaryTimeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/sample")
public class SampleController extends AbstrectController {


    /**
     * sample ByYearDay
     * @param date find day
     * @param request
     * @return
     */
    @GetMapping({"/","/{date}"})
    public ModelAndView sampleByYearDay(@PathVariable("date") String date
            , HttpServletRequest request){

        Optional<LocalDate> localDate  = DiaryTimeUtil.getLocalDate(date);
        if (!localDate.isPresent())
            return new ModelAndView("redirect:"+ DIARY_URL_ENUM.SAMPLE.getTodayViewURI());

        ModelAndView modelAndView = new ModelAndView("/sample/sample");
        modelAndView = setViewByYearDayData(request, modelAndView, date, localDate);
        return modelAndView;
    }

}
