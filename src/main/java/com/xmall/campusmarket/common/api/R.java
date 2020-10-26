package com.xmall.campusmarket.common.api;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description:通用返回对象
 *
 * @author: zl
 * @date: 2020-10-26
 */
@Data
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public R(){}

    public R(Integer code,String msg,T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> R<T> success(T data){
        return new R<T>();
    }
}
