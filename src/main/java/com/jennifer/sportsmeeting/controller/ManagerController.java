package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.exception.ManagerException;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 控制层
 */
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    @ResponseBody
    @RequestMapping("/home")
    public String home()throws Exception{
        throw new ManagerException(101,"sam error!");

    }





}
