package com.jennifer.sportsmeeting.bean;

/*c_id s_id c_name c_num */

public class StudentCourse {
    private String cid;
    private String sid;
    private String cname;
    private String cnum;

    public StudentCourse(){}

    public StudentCourse(String cid, String sid, String cname, String cnum) {
        this.cid = cid;
        this.sid = sid;
        this.cname = cname;
        this.cnum = cnum;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                ", cname='" + cname + '\'' +
                ", cnum='" + cnum + '\'' +
                '}';
    }
}
