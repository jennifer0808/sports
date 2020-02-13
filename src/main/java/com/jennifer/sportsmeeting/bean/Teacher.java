package com.jennifer.sportsmeeting.bean;

/* s_id  s_username  s_password  s_class    s_major  s_sex*/

public class Teacher {
    private String sid;
    private String susername;
    private String spassword;
    private String sclass;
    private String smajor;
    private Character  ssex;

    public Teacher(){
    }

    public Teacher(String sid, String susername, String spassword, String sclass, String smajor, Character ssex) {
        this.sid = sid;
        this.susername = susername;
        this.spassword = spassword;
        this.sclass = sclass;
        this.smajor = smajor;
        this.ssex = ssex;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSusername() {
        return susername;
    }

    public void setSusername(String susername) {
        this.susername = susername;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public Character getSsex() {
        return ssex;
    }

    public void setSsex(Character ssex) {
        this.ssex = ssex;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "sid='" + sid + '\'' +
                ", susername='" + susername + '\'' +
                ", spassword='" + spassword + '\'' +
                ", sclass='" + sclass + '\'' +
                ", smajor='" + smajor + '\'' +
                ", ssex=" + ssex +
                '}';
    }
}
