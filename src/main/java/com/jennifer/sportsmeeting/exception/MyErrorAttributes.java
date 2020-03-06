package com.jennifer.sportsmeeting.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("msg","这是自定义的错误消息");
        Map<String,Object> mef  = (Map<String, Object>) webRequest.getAttribute("me",0);
        map.put("mef",mef);
        return  map;
    }

}
