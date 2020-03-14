package com.jennifer.sportsmeeting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    /**
     * 学生信息管理
     * @return
     */
    @RequestMapping("/student")
    public String Student(){
        return "/html/student";
    }

    /**
     * 比赛成绩管理
     * @return
     */
    @RequestMapping("/scoreStudent")
    public String ScoreStudent(){
        return "/html/scoreStudent";
    }


}
