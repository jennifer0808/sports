package com.jennifer.sportsmeeting.util;

import com.jennifer.sportsmeeting.exception.Message;

import java.util.Date;

/**
 * 用于处理返回的数据以及信息类
 */
public class MessageUtil {

    /**
     * 成功并返回数据实体类
     * @param o
     * @param <E>
     * @return
     */
    public static <E>Message<E> ok(E o){
          return new Message<>(200,"success",o,new Date().getTime());
    }

    /**
     * 成功，但未返回数据实体类
     * @param <E>
     * @return
     */
    public static <E>Message<E> ok(){
        return  new Message<>(200,"success",null,new Date().getTime());
    }

    /**
     * 失败，有自定义异常返回
     * @param code
     * @param msg
     * @param <E>
     * @return
     */
    public static <E>Message<E> error(Integer code,String msg){
        return new Message<>(code,msg,null,new Date().getTime());
    }

}
