package com.jennifer.sportsmeeting.exception;

/**
 * 自定义异常
 */
public class MyException extends RuntimeException{
    /**
     * 状态码（声明 code 用于定义不同类型的自定义异常）
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MyException(Integer code, String msg){
        super(msg);
        this.code=code;
    }


}
