package com.jennifer.sportsmeeting.service.impl;

import com.jennifer.sportsmeeting.bean.Course;
import com.jennifer.sportsmeeting.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "courseService")
public class CourseServiceImpl implements CourseService {
    @Override
    public List<Course> findAllCourse() {
        return null;
    }

    @Override
    public int modifyCourse(Course course) {
        return 0;
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public int removeCourse(String id) {
        return 0;
    }
}
