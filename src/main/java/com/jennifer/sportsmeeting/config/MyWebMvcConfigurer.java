package com.jennifer.sportsmeeting.config;

import com.jennifer.sportsmeeting.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")//拦截任意多层路径下的任意请求
                .excludePathPatterns("/","/index.html","/login","/error","/home")//排除登录页面，登录请求
                .excludePathPatterns("/css/**","/images/**","/js/**","/lib/**","/favicon.ico");//不需要考虑静态资源，springboot已经做好静态映射
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //视图映射：浏览器发送/xxx 请求来到login
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/loginManager.html").setViewName("main");
        registry.addViewController("/loginTeacher.html").setViewName("mainTeacher");
        registry.addViewController("/loginStudent.html").setViewName("mainStudent");
    }


}
