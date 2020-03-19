package com.jennifer.sportsmeeting.service;

import com.github.pagehelper.Page;
import com.jennifer.sportsmeeting.bean.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生业务层
 */
public interface StudentService {

    /**
     * 查询所有
     */
    List<Student> findAllStudent();

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    List<Student> findByPage(int pageNo,int pageSize,String keyWord);

    /**
     * 修改
     * @param student
     * @return
     */
    int modifyStudent(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    int removeStudent(String id);

    /**
     * 增加
     * @param student
     * @return
     */
    int addStudent(Student student);
}
