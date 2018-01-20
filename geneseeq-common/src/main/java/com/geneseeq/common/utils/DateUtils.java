package com.geneseeq.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static DateUtils instance;

    private DateUtils() {
    }

    public static synchronized DateUtils getInstance() {
        if (instance == null) {
            instance = new DateUtils();
        }
        return instance;
    }


    public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";

    private static SimpleDateFormat simpleDateFormat;

    /**
     * Date类型转为指定格式的String类型
     */
    public static String DateToString(Date source, String pattern) {
        simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(source);
    }

    /**
     * unix时间戳转为指定格式的String类型
     * <p>
     * <p>
     * System.currentTimeMillis()获得的是是从1970年1月1日开始所经过的毫秒数 unix时间戳:是从1970年1月1日（UTC/GMT的午夜）开始所经过的秒数,不考虑闰秒
     */
    public static String timeStampToString(long source, String pattern) {
        simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = new Date(source * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 字符串转换为对应日期(可能会报错异常)
     */
    public static Date stringToDate(String source, String pattern) {
        simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
        }
        return date;
    }


    /**
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
     * 获得当前时间对应的指定格式
     */
    public static String currentFormatDate(String pattern) {
        simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());

    }

    /**
     * 获得当前时间戳(单位秒)
     *
     * @return 当前时间戳
     */
    public static long currentTimeStamp() {
        return System.currentTimeMillis() / 1000;
    }


    /**
     * date operation
     *
     * @param originalDate originalDate
     * @param opreation    operate
     * @param distance     distance
     * @return result Date
     */
    public static Date operate(Date originalDate, String opreation, int distance) {

        Date resultDate;

        Calendar cal = Calendar.getInstance();
        cal.setTime(originalDate);

        if (opreation.endsWith("-")) {
            cal.add(Calendar.DATE, -distance);
        }
        if (opreation.endsWith("+")) {
            cal.add(Calendar.DATE, distance);
        }

        resultDate = cal.getTime();
        return resultDate;
    }
}
