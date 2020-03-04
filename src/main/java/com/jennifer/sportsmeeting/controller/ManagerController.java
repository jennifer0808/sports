package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * 控制层
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;

//    @RequestMapping(value = "/login")
//    public String gologin(){
//        return "login";
//    }

    @GetMapping("/login")
    public String gologin(Model model){
        model.addAttribute("manager",new Manager());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute Manager manager, HttpSession session,Map<String,Object> map){
        //验证用户名密码，正确，跳转到indexnum.html,错误，清空session，提示用户名密码错误
        System.out.println("manager:"+manager+";username:"+manager.getmUsername()+";password:"+manager.getmPassword());
        if(manager.getmUsername()!=null&&manager.getmPassword()!=null &&!"".equals(manager.getmUsername()) &&!"".equals(manager.getmPassword()) ) {

            Manager man = managerService.login(manager);
            if(man!=null&& !"".equals(man)){
                if ( man.getmUsername().equals(manager.getmUsername()) && man.getmPassword().equals(manager.getmPassword())) {
                    session.setAttribute("username", manager.getmUsername());
                    System.out.println("username:"+man.getmUsername());
                    map.put("age", 23);
                }
                return "redirect:/main";
            }else {
                session.invalidate();
                map.put("msg", "用户名密码错误");
                return "login";
            }
        }else{
            session.invalidate();
            map.put("msg", "用户名密码为空");
            return "login";
        }

    }
    @RequestMapping("/main")
    public String goMain(Map<String,Object> map){
        map.put("age",30);
        return "main";
    }























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
    public String manager(Map<String,Object> map){
        map.put("username","jennifer");
        return "success";//thymeleaf模板引擎后，直接跳转到classpasth:/templates/success.html页面
    }





}
