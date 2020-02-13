package com.jennifer.sportsmeeting.bean;
/*
m_username m_password
*/

public class Manager {
    private String musername;
    private String mpassword;

    public Manager(){
    }

    public Manager(String musername, String mpassword) {
        this.musername = musername;
        this.mpassword = mpassword;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getMpassword() {
        return mpassword;
    }

    public void setMpassword(String mpassword) {
        this.mpassword = mpassword;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "musername='" + musername + '\'' +
                ", mpassword='" + mpassword + '\'' +
                '}';
    }
}
