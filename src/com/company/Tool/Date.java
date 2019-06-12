package com.company.Tool;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Date {

    //转换日期的字符串为日期格式
    static String borrowTimeInterface(long time) {
        SimpleDateFormat df = (SimpleDateFormat) DateFormat.getInstance();
        df.applyPattern("yyyy-MM-dd");
        String s = df.format(time);
        return s;
    }

}
