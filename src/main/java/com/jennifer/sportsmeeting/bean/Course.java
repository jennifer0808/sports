package com.jennifer.sportsmeeting.bean;

/*c_id c_name c_num boy_count girl_count boy_count_attend girl_count_attend*/

public class Course {
    private String cid;
    private String cname;
    private String cnum;
    private Integer boy_count;
    private Integer girl_count;
    private Integer boy_count_attend;
    private Integer girl_count_attend;

    public Course(){
    }

    public Course(String cid, String cname, String cnum, Integer boy_count, Integer girl_count, Integer boy_count_attend, Integer girl_count_attend) {
        this.cid = cid;
        this.cname = cname;
        this.cnum = cnum;
        this.boy_count = boy_count;
        this.girl_count = girl_count;
        this.boy_count_attend = boy_count_attend;
        this.girl_count_attend = girl_count_attend;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
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

    public Integer getBoy_count() {
        return boy_count;
    }

    public void setBoy_count(Integer boy_count) {
        this.boy_count = boy_count;
    }

    public Integer getGirl_count() {
        return girl_count;
    }

    public void setGirl_count(Integer girl_count) {
        this.girl_count = girl_count;
    }

    public Integer getBoy_count_attend() {
        return boy_count_attend;
    }

    public void setBoy_count_attend(Integer boy_count_attend) {
        this.boy_count_attend = boy_count_attend;
    }

    public Integer getGirl_count_attend() {
        return girl_count_attend;
    }

    public void setGirl_count_attend(Integer girl_count_attend) {
        this.girl_count_attend = girl_count_attend;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", cnum='" + cnum + '\'' +
                ", boy_count=" + boy_count +
                ", girl_count=" + girl_count +
                ", boy_count_attend=" + boy_count_attend +
                ", girl_count_attend=" + girl_count_attend +
                '}';
    }
}
