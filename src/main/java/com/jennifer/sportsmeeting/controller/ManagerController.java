package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


/**
 * 控制层
 */

@Controller
public class ManagerController {
    private  final static Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    @GetMapping("login")//可任意设置路径
    public String gologin(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("mUsername") String mUsername,@RequestParam("mPassword") String mPassword, HttpSession session,Map<String,Object> map){
        //验证用户名密码，正确，跳转到indexnum.html,错误，清空session，提示用户名密码错误
        logger.info("username:"+mUsername+";password:"+mPassword);
        if(mUsername!=null&&mPassword!=null &&!"".equals(mUsername) &&!"".equals(mPassword) ) {

            Manager man = managerService.login(new Manager(mUsername,mPassword));
            if(man!=null&& !"".equals(man)){
                if ( man.getmUsername().equals(mUsername) && man.getmPassword().equals(mPassword)) {
                    session.setAttribute("username", mUsername);
                    logger.info("username:"+man.getmUsername());
                    map.put("age", 23);
                }
                return "redirect:/manager.html";//防止浏览器中表单重复提交
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
//与return "redirect:/main"搭配使用
//    @RequestMapping("/main")
//    public String goMain(Map<String,Object> map){
//        map.put("age",30);
//        return "main";
//    }


















    @RequestMapping("/home")
    @ResponseBody
    public String home(@RequestParam("user") String user)throws Exception{
        if(user.equals("111")){
            throw new NullPointerException("jhkh");
        }
      return "login";//不是直接跳转到classpasth:/templates/路径下的login.html页面，而是跳转字符串页面

    }






}
