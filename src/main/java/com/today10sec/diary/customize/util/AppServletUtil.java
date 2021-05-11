package com.today10sec.diary.customize.util;

import com.today10sec.diary.customize.enumeration.DIARY_URL_ENUM;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class AppServletUtil {
   public static String PROD_DOMAIN = "today10sec";
   public static String PASSWORD = "PASSWORD";
   public static String POST = "POST";
   public static String USER_AGENT = "user-agent";
   public static String COLON_SPACE = " : ";
   public static String COLON = " : ";
   public static String COMMA_SPACE = ", ";
   public static String PREFIX_LOG_START ="[INFO] START ";
   public static String PREFIX_LOG_END ="[INFO] END ";
   public static String BRACKET_OPEN = "[";
   public static String BRACKET_CLOSE = "]";
   public static String EQUAL = " = ";
   public static String HIDE_VALUE = "****";

   public static boolean isProd(HttpServletRequest request){
      if (AppServletUtil.PROD_DOMAIN.equals(request.getServerName())){
         return false;
      }
      return true;
   }

   /**
    * getStartLog
    * @param request
    * @return
    */
   public static String getStartLog(HttpServletRequest request){
      return PREFIX_LOG_START + getTraceCustomerInfo(request) + COLON_SPACE + getRequestParamsInfo(request) + COLON_SPACE +getUserAgent(request);
   }

   /**
    * getEndLog
    * @param request
    * @param response
    * @return
    */
   public static String getEndLog(HttpServletRequest request, HttpServletResponse response){
      return PREFIX_LOG_END + getTraceCustomerInfo(request) + COLON_SPACE + getResponseParamsInfo(response);
   }

   public static String getTraceCustomerInfo(HttpServletRequest request) {
      return request.getRemoteAddr() + COLON_SPACE + BRACKET_OPEN + request.getMethod() + BRACKET_CLOSE + request.getRequestURI();
   }
   private static String getRequestParamsInfo(HttpServletRequest request) {
      Map<String, String[]> paramMap =  request.getParameterMap();
      if (paramMap.size() > 0) {
         return paramMap.entrySet()
                 .stream()
                 .map(entry -> {
                    if (entry.getKey().toUpperCase().contains(PASSWORD)) {
                       return entry.getKey() + EQUAL + HIDE_VALUE;
                    }
                    return entry.getKey() + EQUAL + entry.getValue();
                 })
                 .collect(Collectors.joining(COMMA_SPACE));
      }

      return StringUtils.EMPTY;
   }

   private static String getResponseParamsInfo(HttpServletResponse response) {
      return BRACKET_OPEN + response.getStatus() + BRACKET_CLOSE ;
   }

   private static String getUserAgent(HttpServletRequest request) {
      if (request.getRequestURI().toLowerCase().contains(DIARY_URL_ENUM.CUSTOMER_LOGIN.getURI()) &&  POST.equalsIgnoreCase(request.getMethod()))
         return USER_AGENT +BRACKET_OPEN + request.getHeader(USER_AGENT) + BRACKET_CLOSE;

      return StringUtils.EMPTY;
   }
}