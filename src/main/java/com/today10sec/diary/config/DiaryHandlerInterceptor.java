package com.today10sec.diary.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class DiaryHandlerInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    final String PASSWORD = "PASSWORD";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        logger.info(getTraceLog(request));
        return true;
    }

    private String getTraceLog(HttpServletRequest request) {
        String startPrams = "[INFO] START "+request.getRemoteAddr()+": " +request.getRequestURL();
        Map<String, String[]> paramMap = request.getParameterMap();
        String params = paramMap.keySet().stream().map(key->{
            if (key.toUpperCase().contains(PASSWORD)) {
                return PASSWORD;
            }
            return paramMap.get(key).toString();
        }).collect(Collectors.joining(", "));
        return startPrams.concat(params);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        logger.info("[INFO] END "+request.getRemoteAddr()+": " +request.getRequestURL()+"");
    }
}
