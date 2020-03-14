package com.jennifer.sportsmeeting.service.impl;

import com.jennifer.sportsmeeting.bean.Teacher;
import com.jennifer.sportsmeeting.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "teacherService")
public class TeacherServiceImpl implements TeacherService {

    @Override
    public List<Teacher> findAllTeacher() {
        return null;
    }

    @Override
    public int modifyTeacher(Teacher teacher) {
        return 0;
    }

    @Override
    public int addTeacher(Teacher teacher) {
        return 0;
    }

    @Override
    public int removeTeacher(String id) {
        return 0;
    }
}
