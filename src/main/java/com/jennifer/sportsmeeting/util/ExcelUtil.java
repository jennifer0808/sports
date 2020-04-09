package com.jennifer.sportsmeeting.util;

import com.jennifer.sportsmeeting.bean.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtil {
    public static Student SplitMethod(StringBuffer str) throws ParseException {
        Student student = new Student();
        String[] splitStr = str.toString().split(";");
        for (int i = 0; i <= splitStr.length; i++) {
            student.setsId(splitStr[0]);
            student.setsUsername(splitStr[1]);
            student.setsPassword(splitStr[2]);
            student.setsClass(splitStr[3]);
            student.setsMajor(splitStr[4]);
            student.setsSex(Character.valueOf(splitStr[5].charAt(0)));
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//注意月份是MM
//            student.setCreateTime(simpleDateFormat.parse(splitStr[6]));

            Date currentTime = new Date();
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String dateString = formatter.format(currentTime);
            student.setCreateTime(currentTime);
        }

        return student;

    }

}
