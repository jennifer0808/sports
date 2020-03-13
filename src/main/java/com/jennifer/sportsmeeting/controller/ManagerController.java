package com.jennifer.sportsmeeting.controller;

import com.jennifer.sportsmeeting.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * 控制层
 */

@Controller
public class ManagerController {
    private  final static Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;



    /**
     * get到浏览器请求，响应-学生信息管理
     * @return
     */
    @RequestMapping("/studentManager")
    public String StudentManager(){
        return "/html/studentManager";
    }


    /**
     * 裁判员信息管理
     * @return
     */
    @RequestMapping("/teacherManager")
    public String TteacherManager(){
        return "/html/teacherManager";
    }

    /**
     * 比赛项目信息管理
     * @return
     */
    @RequestMapping("/courseManager")
    public String CourseManager(){
        return "/html/courseManager";
    }

    /**
     * 参赛成绩管理-学生参赛信息列表
     * @return
     */
    @RequestMapping("/studentCourseManager")
    public String StudentCourseManager(){
        return "/html/studentCourseManager";
    }

    /**
     * 参赛成绩管理-学生比赛成绩列表
     * @return
     */
    @RequestMapping("/scoreManager")
    public String ScoreManager(){
        return "/html/scoreManager";
    }

    /**
     * 管理员管理
     * @return
     */
    @RequestMapping("/manager")
    public String Manager(){
        return "/html/manager";
    }
















//与return "redirect:/main"搭配使用
//    @RequestMapping("/main")
//    public String goMain(Map<String,Object> map){
//        map.put("age",30);
//        return "main";
//    }















}
