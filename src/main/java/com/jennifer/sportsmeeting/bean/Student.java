package com.jennifer.sportsmeeting.bean;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * s_id  s_username  s_password  s_class    s_major  s_sex  create_time
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String sId;
    private String sUsername;
    private String sPassword;
    private String sClass;
    private String sMajor;
    private Character sSex;
    private Date createTime;

    public Student(){super();}

    public Student(String sId, String sUsername, String sPassword, String sClass, String sMajor, Character sSex, Date createTime) {
        this.sId = sId;
        this.sUsername = sUsername;
        this.sPassword = sPassword;
        this.sClass = sClass;
        this.sMajor = sMajor;
        this.sSex = sSex;
        this.createTime = createTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsUsername() {
        return sUsername;
    }

    public void setsUsername(String sUsername) {
        this.sUsername = sUsername;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    public Character getsSex() {
        return sSex;
    }

    public void setsSex(Character sSex) {
        this.sSex = sSex;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sUsername='" + sUsername + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", sClass='" + sClass + '\'' +
                ", sMajor='" + sMajor + '\'' +
                ", sSex='" + sSex + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
