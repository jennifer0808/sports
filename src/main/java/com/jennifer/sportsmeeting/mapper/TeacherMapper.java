package com.jennifer.sportsmeeting.mapper;

import com.jennifer.sportsmeeting.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeacherMapper {
    /**
     * 查询所有
     * @return
     */
    List<Teacher> selectListTeacher();

    /**
     * 修改
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    /**
     * 插入-批量插入
     * @param teacher
     * @return
     */
    int insertTeacher(Teacher teacher);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteTeacher(String id);

}
