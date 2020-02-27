package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 控制层
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping(value = "/manager/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession session){
        Manager manager = managerService.login(new Manager(username,password));
        if("admin".equals(manager.getmUsername()) && "admin".equals(manager.getmPassword())){
            //登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser",username);
            return "redirect:/dashboard.html";
        }else{
            //登陆失败
            map.put("msg","用户名密码错误");
            return  "index";
        }
    }




}
