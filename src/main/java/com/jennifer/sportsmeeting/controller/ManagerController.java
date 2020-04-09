package com.jennifer.sportsmeeting.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.jennifer.sportsmeeting.bean.Student;
import com.jennifer.sportsmeeting.exception.MyException;
import com.jennifer.sportsmeeting.service.ManagerService;
import com.jennifer.sportsmeeting.service.StudentService;
import com.jennifer.sportsmeeting.service.excelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    @Autowired
    private excelService  omsAttendanceService;

    @GetMapping(value = "/studentManager")
    public String StudentManager() {
        return "html/studentManager";
    }

    @ResponseBody
    @RequestMapping("/showData")
    public Map<String, Object> StudentManagerPage(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "15") int limit,
            String sUsername) {
        System.out.println("sUsername:" + sUsername);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            List<Student> list = studentService.findByPage(page, limit, sUsername);
            logger.info("list:" + list + ";page:" + page + ";limit:" + limit);
            int count = studentService.queryCount();
            System.out.println("count:"+count);
            map.put("code", 0);
            map.put("msg", "");
            map.put("count", count);//todo:25需要进行数据库查询
            map.put("data", list);
        } catch (Exception e) {
            throw new MyException(11, e.getMessage());
        }
        return map;
    }

    //导入
    @RequestMapping("readExcel")
    @ResponseBody
    public Map readExcel(@RequestParam MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        logger.info("fileName:"+fileName);
        Map map = new HashMap();
        try {
            a = studentService.readExcel(fileName, file);
            if (a) {
                map.put("code", 0);
                map.put("msg", "导入EXCEL成功！");
                return map;
            } else {
                map.put("code", 1);
                map.put("msg", "导入EXCEL失败！");
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }



//test分页1
//    @GetMapping(value = "/studentManager" )
//    public String StudentManager(){
//        return "html/test";
//    }

    //test 分页2
//    @ResponseBody
//    @RequestMapping("/showData")
//    public Map<String,Object> methodx(
//            @RequestParam(required=false,defaultValue="1") int page,
//            @RequestParam(required=false,defaultValue="15") int limit,
//            String keyWord){
//        System.out.println("keyWord:"+keyWord);
//        List<Student> list = studentService.findByPage(page,limit);//pageSize相当于limit角色
//        logger.info("list:"+list+";page:"+page+";limit:"+limit);
//        PageInfo<Student> pageInfo = new PageInfo<Student>(list);
//
//        Map<String,Object> map=new HashMap<String,Object>();
//        map.put("code",0);
//        map.put("msg","");
//        map.put("count",pageInfo.getTotal());
//        map.put("data",list);
//        System.out.println(map.toString());
//        return map;
//    }


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
    /**
     * 系统统计
     *
     * @return
     */
    @RequestMapping("/testexcel")
    public String excel(){
        return "html/testexcel";
    }

    /**
     * 导入考勤模板
     *
     * @param
     * @return
     */
    @RequestMapping("/get/import_attendance")
    public String importTemplate(@RequestParam("file") MultipartFile file) {
        String str = "";
        Map<String, String> resObj = new HashMap<>();
        if (!file.isEmpty()) {
            try {

                String filename = file.getOriginalFilename();

                str = omsAttendanceService.importService(filename, file);
            } catch (IOException e) {
                logger.error("考勤查看的导入数据保存出错", e);
                resObj.put("msg", "error");
                resObj.put("code", "1");
                return JSONObject.toJSONString(resObj);
            }
            resObj.put("msg", str);
            resObj.put("code", "0");
            return JSONObject.toJSONString(resObj);
        } else {
            return null;
        }
    }


















//与return "redirect:/main"搭配使用
//    @RequestMapping("/main")
//    public String goMain(Map<String,Object> map){
//        map.put("age",30);
//        return "main";
//    }


}
