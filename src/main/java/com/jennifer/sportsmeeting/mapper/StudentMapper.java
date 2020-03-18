package com.jennifer.sportsmeeting.mapper;

import com.github.pagehelper.Page;
import com.jennifer.sportsmeeting.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//为了声明Bean
@Mapper
public interface StudentMapper {
    /**
     * 查询所有
     */
     List<Student> selectListStudent();

    /**
     * 分页查询
     * @return
     */
     List<Student> selectByPage();

    /**
     * 修改
     * @param student
     * @return
     */
     int updateStudent(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
     int deleteStudent(String id);

    /**
     * 增加所有
     * @param student
     * @return
     */
     int insertStudent(Student student);

}