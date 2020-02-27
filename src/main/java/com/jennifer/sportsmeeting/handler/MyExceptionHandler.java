package com.jennifer.sportsmeeting.handler;

import com.jennifer.sportsmeeting.exception.ManagerException;
import com.jennifer.sportsmeeting.exception.Message;
import com.jennifer.sportsmeeting.util.MessageUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class MyExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public <E>Message<E> handler(Exception exception){
        if(exception instanceof ManagerException){
            ManagerException managerException= (ManagerException) exception;
            return MessageUtil.error(managerException.getCode(),managerException.getMessage());
        }else if(exception instanceof NullPointerException){
            return MessageUtil.error(500,"空指针异常");
        }else{
            return MessageUtil.error(120,exception.getMessage());
        }
    }
}
