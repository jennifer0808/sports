package com.jennifer.sportsmeeting.mapper;

import com.jennifer.sportsmeeting.bean.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface CourseMapper {
    List<Course> selectListCourse();

    int updateCourse(Course course);

    int insertCourse(Course course);

    int deleteCourse(String id);
}
