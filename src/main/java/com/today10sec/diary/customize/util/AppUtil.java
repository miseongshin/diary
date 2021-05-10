package com.today10sec.diary.customize.util;

import javax.servlet.http.HttpServletRequest;

public class AppUtil {
   public static String PROD_DOMAIN = "today10sec";

   public static boolean isProd(HttpServletRequest request){
      if (AppUtil.PROD_DOMAIN.equals(request.getServerName())){
         return false;
      }
      return true;
   }
}
