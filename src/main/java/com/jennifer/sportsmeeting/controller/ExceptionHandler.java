package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.exception.ManagerException;
import com.jennifer.sportsmeeting.exception.Message;
import com.jennifer.sportsmeeting.util.MessageUtil;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一处理异常
 */
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public <E>Message<E> handler(Exception exception){
        if (exception instanceof ManagerException){
            ManagerException managerException = (ManagerException) exception;
            return MessageUtil.error(managerException.getCode(), managerException.getMessage());
        } else {
            return MessageUtil.error(120, "异常信息：" + exception.getMessage());
        }
    }

}
