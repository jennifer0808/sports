package com.jennifer.sportsmeeting.exception;

public class ManagerException extends RuntimeException{
    /**
     * 状态码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public ManagerException(Integer code,String msg){
        super(msg);
        this.code=code;
    }


}
