package com.jennifer.sportsmeeting.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jennifer.sportsmeeting.bean.Student;
import com.jennifer.sportsmeeting.service.ManagerService;
import com.jennifer.sportsmeeting.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 控制层
 */

@Controller
public class ManagerController {
    private final static Logger logger = LoggerFactory.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;
    @Autowired
    private StudentService studentService;


    /**
     * 学生信息管理-查询所有
     *
     * @return
     */
//    @RequestMapping("/studentManager")
//    public ModelAndView StudentManager(ModelAndView modelAndView) {
//        ModelAndView mv = new ModelAndView();
//        List<Student> list = studentService.findAllStudent();
//        mv.addObject("studentList", list);//页面对list进行判空
//        mv.setViewName("/html/studentManager");
//        return mv;
//    }


    @GetMapping("/studentManager")
    public String StudentManager(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        List<Student> list = studentService.findByPage(pageNum,6);//pageSize相当于limit角色
        logger.info("list:"+list+";pageNum:"+pageNum);
        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "/html/studentManager";
    }




    /**
     * 裁判员信息管理
     *
     * @return
     */
    @RequestMapping("/teacherManager")
    public String TteacherManager() {
        return "/html/teacherManager";
    }

    /**
     * 比赛项目信息管理
     *
     * @return
     */
    @RequestMapping("/courseManager")
    public String CourseManager() {
        return "/html/courseManager";
    }

    /**
     * 参赛成绩管理-学生参赛信息列表
     *
     * @return
     */
    @RequestMapping("/studentCourseManager")
    public String StudentCourseManager() {
        return "/html/studentCourseManager";
    }

    /**
     * 参赛成绩管理-学生比赛成绩列表
     *
     * @return
     */
    @RequestMapping("/scoreManager")
    public String ScoreManager() {
        return "/html/scoreManager";
    }

    /**
     * 管理员管理
     *
     * @return
     */
    @RequestMapping("/manager")
    public String Manager() {
        return "/html/manager";
    }


//与return "redirect:/main"搭配使用
//    @RequestMapping("/main")
//    public String goMain(Map<String,Object> map){
//        map.put("age",30);
//        return "main";
//    }


}
