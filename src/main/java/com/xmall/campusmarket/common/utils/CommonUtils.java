package com.xmall.campusmarket.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtils {
    /**
     * empty logic
     */
    public static boolean isEmpty(Object value){
        if(null == value){
            return true;
        }else if(value instanceof String){
            return StringUtils.isEmpty((String)value);
        }else if(value instanceof Object[]){
            return ((Object[])value).length == 0;
        }else if(value instanceof Map){
            return ((Map)value).isEmpty();
        }else if(value instanceof Collection){
            return ((Collection)value).isEmpty();
        }
        return false;
    }

    public static boolean hasEmpty(Object... objs) {
        for (Object obj : objs) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIsInteger(String input){
        Matcher mer = INT_PATTERN.matcher(input);
        return mer.find();
    }

    public static boolean checkIsDecimal(String input){
        Matcher mer = DECIMAL_PATTERN.matcher(input);
        return mer.find();
    }

    private static Pattern DECIMAL_PATTERN = Pattern.compile("^([1-9]\\d*\\.?\\d*)|(0\\.\\d*[1-9])$");
    private static Pattern INT_PATTERN = Pattern.compile("^[+-]?[0-9]+$");
}
