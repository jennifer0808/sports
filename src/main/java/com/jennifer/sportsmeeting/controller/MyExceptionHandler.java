package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.exception.ManagerException;
import com.jennifer.sportsmeeting.exception.Message;
import com.jennifer.sportsmeeting.util.MessageUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import sun.net.httpserver.HttpServerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理类，一般作用于controller层
 */
@ControllerAdvice//异常拦截controller请求
public class MyExceptionHandler {

    /**
     * 全局异常捕捉处理，返回json
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)//捕获 Controller 中抛出的指定类型的异常，也可以指定其他异常
    public <E>Message<E> handler(Exception exception){
        if(exception instanceof ManagerException){
            ManagerException managerException= (ManagerException) exception;
            return MessageUtil.error(managerException.getCode(),managerException.getMessage());
        }else if(exception instanceof NullPointerException){
            return MessageUtil.error(500,"空指针异常");
        }else{
            return MessageUtil.error(120,"异常信息："+exception.getMessage());
        }
    }


/*    @ExceptionHandler(Exception.class)
    public String handlerException(Exception exception,HttpServletRequest request){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", "自定义状态码");
        map.put("msg", exception.getMessage());
        //设置错误状态码，一定要设置，否者就不会进入到自定义页面中
        request.setAttribute("javax.servlet.error.status_code", 404);
        //将自己的异常信息加入到request
        request.setAttribute("extMap", map);
        //转发到/error
        return "forward:/error";
    }*/


}
