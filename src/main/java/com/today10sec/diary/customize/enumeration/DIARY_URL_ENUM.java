package com.today10sec.diary.customize.enumeration;

import com.today10sec.diary.customize.util.DiaryTimeUtil;
import org.springframework.util.Assert;

public enum DIARY_URL_ENUM {
    CUSTOMER_LOGIN("/customer/login"),
    DIARY_VIEW("/diary/view"),
    CUSTOMER_SIGN_UP("/customer/signUp"),
    SAMPLE("/sample");

    private String url;

    DIARY_URL_ENUM(String url) {
        this.url =url;
    }

    public String getURI(){
        return this.url;
    }

    public String getPath(){
        return this.url;
    }

    public String getTodayViewURI(){
        Assert.isTrue(DIARY_URL_ENUM.DIARY_VIEW.getURI().equals(this.url)
                || DIARY_URL_ENUM.SAMPLE.getURI().equals(this.url) ,"this is only for 'DIARY_VIEW'");
        return this.getURI().concat("/").concat(DiaryTimeUtil.getTodayOnlyNumberText());
    }

}
