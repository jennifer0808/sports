package com.jennifer.sportsmeeting.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(LoginHandlerInterceptor.class);
   //目标方法执行之前，从Session中判断是否有登录过得用户名记录
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("username");
        logger.info("preHandle==user:"+user+"=="+request.getRequestURL());
        if(user ==null ){//表示用户未登录，返回登录页
            request.setAttribute("msg","无权限请先登录");
            // 获取request转发页面到登录页
            request.getRequestDispatcher("/index.html").forward(request,response);
            //30分钟后session失效
            request.getSession().setMaxInactiveInterval(30 * 60);
            return false;

        }else{//已登录，放行请求
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Object user = request.getSession().getAttribute("username");
        logger.info("postHandle==user:"+user+"=="+request.getRequestURL());

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Object user = request.getSession().getAttribute("username");
        logger.info("afterCompletion==user:"+user+"=="+request.getRequestURL());
    }
}
