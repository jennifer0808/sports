package com.jennifer.sportsmeeting.service.impl;

import com.jennifer.sportsmeeting.bean.Student;
import com.jennifer.sportsmeeting.mapper.StudentMapper;
import com.jennifer.sportsmeeting.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {
private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询列表--TODO：未做事务
     * @return
     */
    @Override
    public List<Student> findAllStudent() {
        List<Student> list = null;
        try {
            list = studentMapper.selectListStudent();
        }catch (Exception e){
            logger.error("StudentServiceImpl findAllStudent():"+e.getMessage());
        }
        return list;
    }

    @Override
    public int modifyStudent(Student student) {
        return 0;
    }

    @Override
    public int removeStudent(String id) {
        return 0;
    }

    @Override
    public int addStudent(Student student) {
        return 0;
    }
}
