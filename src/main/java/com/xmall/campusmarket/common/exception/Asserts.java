package com.xmall.campusmarket.common.exception;

import com.xmall.campusmarket.common.api.ErrorCode;
import com.xmall.campusmarket.common.utils.CommonUtils;

import java.util.Collection;

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

    public static void fail(ErrorCode errorCode) {
        throw new ApiException(errorCode);
    }

    public static void assertEquals(Object actual, Object expected, String msg){
        if(expected != null || actual != null) {
            if (expected == null || !expected.equals(actual)) {
                fail(msg);
            }
        }
    }

    public static void assertEquals(Object actual, Object expected, ErrorCode errorCode){
        if(expected != null || actual != null) {
            if (expected == null || !expected.equals(actual)) {
                fail(errorCode);
            }
        }
    }

    public static void assertTrue(boolean b, String msg){
        if(!b) {
            fail(msg);
        }
    }

    public static void assertTrue(boolean b, ErrorCode errorCode){
        if(!b) {
            fail(errorCode);
        }
    }

    public static void assertFalse(boolean b, String msg){
        if(b) {
            fail(msg);
        }
    }

    public static void assertFalse(boolean b, String msg, ErrorCode errorCode){
        if(b) {
            fail(errorCode);
        }
    }

    public static void assertNull(Object b, String msg){
        if(b!=null) {
            fail(msg);
        }
    }

    public static void assertNull(Object b, String msg, ErrorCode errorCode){
        if(b!=null) {
            fail(errorCode);
        }
    }

    public static void assertNotNull(Object b, String msg){
        if(b==null) {
            fail(msg);
        }
    }

    public static void assertNotNull(Object b, String msg, ErrorCode errorCode){
        if(b==null) {
            fail(errorCode);
        }
    }

    public static void assertNotEmpty(Collection b, String msg){
        if(b==null || b.isEmpty()) {
            fail(msg);
        }
    }

    public static void assertNotEmpty(Collection b, String msg, ErrorCode errorCode){
        if(b==null || b.isEmpty()) {
            fail(errorCode);
        }
    }

    public static void assertNotNullAndEmpty(Object b, String msg){
        if(CommonUtils.isEmpty(b)) {
            fail(msg);
        }
    }

    public static void assertNotNullAndEmpty(Object b, String msg, ErrorCode errorCode){
        if(CommonUtils.isEmpty(b)) {
            fail(errorCode);
        }
    }

    public static void assertNullAndEmpty(Object b, String msg){
        if(!CommonUtils.isEmpty(b)) {
            fail(msg);
        }
    }

    public static void assertNullAndEmpty(Object b, String msg, ErrorCode errorCode){
        if(!CommonUtils.isEmpty(b)) {
            fail(errorCode);
        }
    }

    public static void assertEmpty(Collection b, String msg){
        if(null !=b && b.size()>0) {
            fail(msg);
        }
    }

    public static void assertEmpty(Collection b, String msg, ErrorCode errorCode){
        if(null !=b && b.size()>0) {
            fail(errorCode);
        }
    }


}
