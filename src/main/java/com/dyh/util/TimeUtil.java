package com.dyh.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Date 2019/12/4 17:45
 * @Author 丁宇辉
 */
public class TimeUtil {

    /**
     * 根据时间计算出当前对应的时间字符串
     * @param date
     * @return
     */
    public static String dateSCore(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
        String format = simpleDateFormat.format(date);
        return format;
    }

    /**
     * 获得指定时间
     * @param time - 正数为之后，负数为之前，数字代表天数
     * @return
     */
    public static String beforeTime(int time){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,time);
        Date beforeTime = calendar.getTime();

        String dateSCore = dateSCore(beforeTime);
        return dateSCore;
    }
}
