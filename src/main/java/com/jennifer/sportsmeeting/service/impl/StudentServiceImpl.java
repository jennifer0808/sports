package com.jennifer.sportsmeeting.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jennifer.sportsmeeting.bean.Student;
import com.jennifer.sportsmeeting.mapper.StudentMapper;
import com.jennifer.sportsmeeting.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(value = "studentService")
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {
private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询列表--TODO：查询不用做事务
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



    /**
     * 分页查询
     * @param page 页号
     * @param limit 每页显示记录数-limit
     * @return
     */
    @Override
    public List<Student> findByPage(int page, int limit,String keyWord) {
        page=(page-1)*limit;
        List<Student> list = studentMapper.selectByPage(page,limit,keyWord);
        logger.info("list:"+list.size());
        return list;
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @Override
    public int modifyStudent(Student student) {
        return 0;
    }

    @Override
    public int removeStudent(String id) {
        return 0;
    }

    @Override
    @Transactional
    public int addStudent(Student student) {
        return 0;
    }
}
