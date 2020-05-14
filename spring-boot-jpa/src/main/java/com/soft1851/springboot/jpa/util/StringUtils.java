package com.soft1851.springboot.jpa.util;

/**
 * 描述:
 *
 * @author：Guorc
 * @create 2020-05-13 23:45
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String content){
        if (content != null && content.length() != 0){
            return false;
        }
        return true;
    }
}

