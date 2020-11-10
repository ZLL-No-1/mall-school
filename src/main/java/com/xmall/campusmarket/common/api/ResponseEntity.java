package com.xmall.campusmarket.common.api;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * Description: 通用返回对象
 *
 * @author: zl
 * @date: 2020-10-26
 */
@Data
public class ResponseEntity<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResponseEntity(){}

    public ResponseEntity(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> ResponseEntity<T> success(T data){
        return new ResponseEntity<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMessage(),data);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @param  message 提示信息
     */
    public static <T> ResponseEntity<T> success(T data, String message) {
        return new ResponseEntity<T>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     */
    public static <T> ResponseEntity<T> failed(ErrorCode errorCode) {
        return new ResponseEntity<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     * @param errorCode 错误码
     * @param message 错误信息
     */
    public static <T> ResponseEntity<T> failed(ErrorCode errorCode, String message) {
        return new ResponseEntity<T>(errorCode.getCode(), message, null);
    }

    /**
     * 失败返回结果
     * @param message 提示信息
     */
    public static <T> ResponseEntity<T> failed(String message) {
        return new ResponseEntity<T>(ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> ResponseEntity<T> failed() {
        return failed(ResultCode.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> ResponseEntity<T> validateFailed() {
        return failed(ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     * @param message 提示信息
     */
    public static <T> ResponseEntity<T> validateFailed(String message) {
        return new ResponseEntity<T>(ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> ResponseEntity<T> unauthorized(T data) {
        return new ResponseEntity<T>(ResultCode.UNAUTHORIZED.getCode(), ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> ResponseEntity<T> forbidden(T data) {
        return new ResponseEntity<T>(ResultCode.FORBIDDEN.getCode(), ResultCode.FORBIDDEN.getMessage(), data);
    }
}
