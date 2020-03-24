package com.example.mybatisplus.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description : 日期转换工具类
 * @Author : huzhiting
 * @Date: 2020-03-24 16:56
 */
public class LocalDateUtil {

    public static String formatDate(LocalDate localDate,String format){
        if(localDate == null){
            return "";
        }
        DateTimeFormatter date = DateTimeFormatter.ofPattern(format);
        return date.format(localDate);
    }

    public static String formatDate(LocalDateTime localDateTime, String format){
        if(localDateTime == null){
            return "";
        }
        DateTimeFormatter date = DateTimeFormatter.ofPattern(format);
        return date.format(localDateTime);
    }
}
