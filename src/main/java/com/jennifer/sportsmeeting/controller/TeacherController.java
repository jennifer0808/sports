package com.jennifer.sportsmeeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TeacherController {

    /**
     * 学生信息管理
     * @return
     */
    @RequestMapping("/studentTeacher")
    public String StudentTeacher() {
        return "/html/studentTeacher";
    }

    /**
     * 比赛成绩管理
     * @return
     */
    @RequestMapping("/scoreTeacher")
    public String ScoreTeacher(){
        return "/html/scoreTeacher";
    }

    @RequestMapping("/teacher")
    public String Teacher(){
        return "/html/teacher";
    }
}
