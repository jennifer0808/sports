package com.jennifer.sportsmeeting.service;

import com.jennifer.sportsmeeting.bean.Course;

import java.util.List;

public interface CourseService {

    List<Course> findAllCourse();

    int modifyCourse(Course course);

    int addCourse(Course course);

    int removeCourse(String id);
}
