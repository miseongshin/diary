package com.today10sec.diary.data.enumeration;

import com.today10sec.diary.util.TimeUtil;
import org.springframework.util.Assert;

public enum DIARY_URL_ENUM {
    DIARY_VIEW("diary/view/"),
    USER_LOGIN("user/login/"),
    USER_ADD("user/add/");

    private String url;

    DIARY_URL_ENUM(String url) {
        this.url =url;
    }

    public String getUrl(){
        return this.url;
    }

    public String getTodayViewUrl(){
        Assert.isTrue(DIARY_URL_ENUM.DIARY_VIEW.getUrl().equals(this.url) ,"this is only for 'DIARY_VIEW'");
        return DIARY_VIEW.getUrl().concat(TimeUtil.getTodayOnlyNumberText());
    }

}
