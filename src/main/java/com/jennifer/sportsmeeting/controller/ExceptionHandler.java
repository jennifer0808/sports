package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.exception.Message;
import com.jennifer.sportsmeeting.exception.MyException;
import com.jennifer.sportsmeeting.util.MessageUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一处理异常
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public String handlerException(Exception exception, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Message message= null;
        if(exception instanceof MyException){
            MyException myException = (MyException) exception;
             message = MessageUtil.error(myException.getCode(),myException.getMessage());

        }else{
             message = MessageUtil.error(110,"异常信息："+exception.getMessage());
        }
       //设置状态码
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("myCode",message.getCode());
        map.put("myMsg",message.getMessage());
        request.setAttribute("me",map);
        return "forward:/error";
    }

}
