package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 控制层
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;



    @RequestMapping("/home")
    @ResponseBody
    public String home(@RequestParam("user") String user)throws Exception{
        if(user.equals("111")){
            throw new NullPointerException("jhkh");
        }
      return "login";//不是直接跳转到classpasth:/templates/路径下的login.html页面，而是跳转字符串页面

    }

//    @ResponseBody
    @RequestMapping("/manager")
    public String manager(){
        return "success";//thymeleaf模板引擎后，直接跳转到classpasth:/templates/success.html页面
    }





}
