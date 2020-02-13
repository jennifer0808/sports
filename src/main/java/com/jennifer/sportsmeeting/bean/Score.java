package com.jennifer.sportsmeeting.bean;
/*c_id  s_id  c_name first_score  final_score  score*/

public class Score {
    private String cid;
    private String sid;
    private String cname;
    private Integer first_score;
    private Integer final_score;
    private Integer score;

    public Score(){
    }

    public Score(String cid, String sid, String cname, Integer first_score, Integer final_score, Integer score) {
        this.cid = cid;
        this.sid = sid;
        this.cname = cname;
        this.first_score = first_score;
        this.final_score = final_score;
        this.score = score;
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

    public Integer getFirst_score() {
        return first_score;
    }

    public void setFirst_score(Integer first_score) {
        this.first_score = first_score;
    }

    public Integer getFinal_score() {
        return final_score;
    }

    public void setFinal_score(Integer final_score) {
        this.final_score = final_score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "cid='" + cid + '\'' +
                ", sid='" + sid + '\'' +
                ", cname='" + cname + '\'' +
                ", first_score=" + first_score +
                ", final_score=" + final_score +
                ", score=" + score +
                '}';
    }
}
