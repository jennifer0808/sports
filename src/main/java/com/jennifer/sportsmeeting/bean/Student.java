package com.jennifer.sportsmeeting.bean;
/*t_id  t_username  t_password*/

public class Student {
    private String tid;
    private String tusername;
    private String tpassword;

    public Student(){
    }

    public Student(String tid, String tusername, String tpassword) {
        this.tid = tid;
        this.tusername = tusername;
        this.tpassword = tpassword;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTusername() {
        return tusername;
    }

    public void setTusername(String tusername) {
        this.tusername = tusername;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    @Override
    public String toString() {
        return "Student{" +
                "tid='" + tid + '\'' +
                ", tusername='" + tusername + '\'' +
                ", tpassword='" + tpassword + '\'' +
                '}';
    }
}
