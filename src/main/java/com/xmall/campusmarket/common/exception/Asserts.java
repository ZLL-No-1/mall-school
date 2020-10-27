package com.xmall.campusmarket.common.exception;

import com.xmall.campusmarket.common.api.IErrorCode;

/**
 * Created with IntelliJ IDEA.
 * Description: 断言处理类，用于抛出各种API异常
 *
 * @author: zl
 * @date: 2020-10-27
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
