package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.common.GlobalConstant;
import com.jennifer.sportsmeeting.exception.MyException;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService; //相当于 ManagerService managerService = new ManagerServiceImpl();

    @GetMapping("login")//可任意设置路径
    public String gologin() {
        return "login";
    }

    /**
     * 登录页功能
     *
     * @param mUsername
     * @param mPassword
     * @param session
     * @param map
     * @return
     */
    @PostMapping(value = "/login")
    public String login(@RequestParam("role") String role, @RequestParam("mUsername") String mUsername, @RequestParam("mPassword") String mPassword, HttpSession session, Map<String, Object> map) {
        //验证用户名密码，正确，跳转到manager.html,错误，清空session，提示用户名密码错误
        logger.info("username:" + mUsername + ";password:" + mPassword + ";role:" + role);

        if (mUsername != null && mPassword != null && !"".equals(mUsername) && !"".equals(mPassword)) {
            Manager manager = managerService.login(new Manager(mUsername, mPassword));
            if ("管理员".equals(role)) {
                if (!GlobalConstant.ifFlag) {
                    if (manager != null && manager.getmUsername().equals(mUsername) && manager.getmPassword().equals(mPassword)) {
                        session.setAttribute("username", mUsername);
                        logger.info("username:" + manager.getmUsername());
                        return "redirect:/loginManager.html";//防止浏览器中表单重复提交
                    } else {
                        session.invalidate();
                        map.put("msg", "用户名密码错误");
                        return "login";
                    }
                } else {
                    logger.error("manager:" + manager);
                    throw new MyException(120, "selectUserByManager SQL is fault");
                }
            } else if ("裁判".equals(role)) {
//                session.invalidate();
//                map.put("msg", "裁判角色登录");
                if("1".equals(mUsername)){
                    session.setAttribute("username", mUsername);
                    return "redirect:/loginTeacher.html";
                }else{
                    session.invalidate();
                    map.put("msg", "学生角色登录");
                    return "login";
                }

            } else {
//                session.invalidate();
//                map.put("msg", "学生角色登录");
                if("2".equals(mUsername)) {
                    session.setAttribute("username", mUsername);
                    return "redirect:/loginStudent.html";
                }else{
                    session.invalidate();
                    map.put("msg", "学生角色登录");
                    return "login";
                }
            }
        } else {
            session.invalidate();
            map.put("msg", "用户名密码为空");
            return "login";
        }

    }

//    public void


    /**
     * 测试springboot定制错误页面以及Json功能
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping("/home")
    @ResponseBody
    public String home(@RequestParam("user") String user) throws Exception {
        if (user.equals("111")) {
            throw new MyException(12, "ss");
        }
        return "success";//不是直接跳转到classpasth:/templates/路径下的login.html页面，而是跳转字符串页面

    }

}
