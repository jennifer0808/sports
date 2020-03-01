package com.jennifer.sportsmeeting.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
       /* Map<String, Object> map = (Map<String, Object>) webRequest.getAttribute("extMap", 0);//0标识从request中获取
        errorAttributes.put("tag", "标识");
        errorAttributes.put("extMap",map);*/
        return errorAttributes;
    }
}
