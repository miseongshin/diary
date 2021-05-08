package com.today10sec.diary.customize.enumeration;

import com.today10sec.diary.customize.util.DiaryTimeUtil;
import org.springframework.util.Assert;

public enum DIARY_URL_ENUM {
    CUSTOMER_LOGIN("/customer/login/"),
    DIARY_VIEW("/diary/view/"),
    CUSTOMER_SIGN_UP_AJAX("/customer/signUp/ajax"),
    CUSTOMER_SIGN_UP("/customer/signUp/");

    private String url;

    DIARY_URL_ENUM(String url) {
        this.url =url;
    }

    public String getUrl(){
        return this.url;
    }

    public String getJspPath(){
        int urlLength  = this.url.length();
        if ("/".equals(this.url.substring(urlLength-1,urlLength)))
            return this.url.substring(0,urlLength-1);
        return this.url;
    }

    public String getTodayViewUrl(){
        Assert.isTrue(DIARY_URL_ENUM.DIARY_VIEW.getUrl().equals(this.url) ,"this is only for 'DIARY_VIEW'");
        return DIARY_VIEW.getUrl().concat(DiaryTimeUtil.getTodayOnlyNumberText());
    }

}
