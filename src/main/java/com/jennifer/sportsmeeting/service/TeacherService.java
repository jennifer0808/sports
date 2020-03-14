package com.jennifer.sportsmeeting.service;

import com.jennifer.sportsmeeting.bean.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> findAllTeacher();

    int modifyTeacher(Teacher teacher);

    int addTeacher(Teacher teacher);

    int removeTeacher(String id);
 }
