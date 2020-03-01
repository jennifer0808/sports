package com.jennifer.sportsmeeting.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class ExceptionPreHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        boolean b1 = method.getReturnType().equals(String.class);
        boolean b2 = !method.isAnnotationPresent(ResponseBody.class);
        boolean b3 = !handlerMethod.getBeanType().isAnnotationPresent(RestController.class);
        request.setAttribute("method_return_is_view",b1 && b2 && b3);
        return true;
    }
}
