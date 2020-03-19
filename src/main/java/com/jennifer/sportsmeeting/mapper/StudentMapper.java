package com.jennifer.sportsmeeting.mapper;

import com.github.pagehelper.Page;
import com.jennifer.sportsmeeting.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//为了声明Bean
@Mapper
public interface StudentMapper {


    /**
     * 分页查询
     * @return
     */
     List<Student> selectByPage(@Param("page")int page,@Param("limit")int limit,@Param("keyWord")String keyWord);

     int selectAllCount(@Param("parameter") String keyWord);




    /**
     * 查询所有
     */
    List<Student> selectListStudent();

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