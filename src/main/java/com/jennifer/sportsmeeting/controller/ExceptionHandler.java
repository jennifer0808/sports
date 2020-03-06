package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.exception.ManagerException;
import com.jennifer.sportsmeeting.exception.Message;
import com.jennifer.sportsmeeting.util.MessageUtil;
import org.apache.logging.log4j.core.pattern.HtmlTextRenderer;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一处理异常
 */
@ControllerAdvice
public class ExceptionHandler {

//    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
//    public <E>Message<E> handler(Exception exception){
//        if (exception instanceof ManagerException){
//            ManagerException managerException = (ManagerException) exception;
//            return MessageUtil.error(managerException.getCode(), managerException.getMessage());
//        } else {
//            return MessageUtil.error(120, "异常信息：" + exception.getMessage());
//        }
//    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String handlerException(Exception e, HttpServletRequest request){
       //设置状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        Map<String,Object> map = new HashMap<>();
        map.put("code",1005);
        map.put("msg","这是 put 进来的异常！");
        request.setAttribute("me",map);
        return "forward:/error";
    }

}
