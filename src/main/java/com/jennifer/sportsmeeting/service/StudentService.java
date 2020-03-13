package com.jennifer.sportsmeeting.service;

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
