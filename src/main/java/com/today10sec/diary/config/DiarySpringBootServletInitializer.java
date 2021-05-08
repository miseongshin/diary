/*
package com.today10sec.diary.config;

import org.apache.catalina.Context;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DiarySpringBootServletInitializer extends SpringBootServletInitializer {

    @Bean
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory ( ) {
        return new TomcatServletWebServerFactory(){
            @Override
            protected void postProcessContext(Context context) {
                super.postProcessContext(context);
               */
/* JspPropertyGroup jspPropertyGroup = new JspPropertyGroup();
                jspPropertyGroup.addUrlPattern("*.jsp");
                jspPropertyGroup.setPageEncoding("UTF-8");
                jspPropertyGroup.setScriptingInvalid("true");
                //jspPropertyGroup.addIncludePrelude("/WEB-INF/views/common/common.jsp");
                jspPropertyGroup.setTrimWhitespace("true");
                jspPropertyGroup.setDefaultContentType("text/html");

                JspPropertyGroupDescriptorImpl jspPropertyGroupDescriptor = new JspPropertyGroupDescriptorImpl(jspPropertyGroup);
                context.setJspConfigDescriptor(new JspConfigDescriptorImpl(Collections.singletonList(jspPropertyGroupDescriptor), Collections.emptyList()));
*//*

            }
        };
    }

}
*/
