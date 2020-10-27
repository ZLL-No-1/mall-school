package com.xmall.campusmarket.common.exception;

import com.xmall.campusmarket.common.api.IErrorCode;

/**
 * Created with IntelliJ IDEA.
 * Description: 自定义API异常
 *
 * @author: zl
 * @date: 2020-10-27
 */
public class ApiException extends RuntimeException {

    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
