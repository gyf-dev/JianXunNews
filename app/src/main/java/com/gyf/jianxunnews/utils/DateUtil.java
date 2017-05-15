package com.gyf.jianxunnews.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * 日期工具类
 */
public class DateUtil {
    /**
     * The constant DATE_FORMAT_DATETIME.
     */
    private static final SimpleDateFormat DATE_FORMAT_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * The constant DATE_FORMAT_DATE.
     */
    private static final SimpleDateFormat DATE_FORMAT_DATE = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * The constant DATE_FORMAT_TIME.
     */
    private static final SimpleDateFormat DATE_FORMAT_TIME = (SimpleDateFormat) SimpleDateFormat.getTimeInstance();

    /**
     * Format data time string.
     * 格式化日期时间
     *
     * @param date the date
     * @return the string
     */
    public static String formatDataTime(long date) {
        return DATE_FORMAT_DATETIME.format(new Date(date));
    }

    /**
     * Format date string.
     * 格式化日期
     *
     * @param date the date
     * @return the string
     */
    public static String formatDate(long date) {
        return DATE_FORMAT_DATE.format(new Date(date));
    }

    /**
     * Format time string.
     * 格式化时间
     *
     * @param date the date
     * @return the string
     */
    public static String formatTime(long date) {
        return DATE_FORMAT_TIME.format(new Date(date));
    }

    /**
     * Format date custom string.
     * 自定义格式的格式化日期时间
     *
     * @param beginDate the begin date
     * @param format    the format
     * @return the string
     */
    public static String formatDateCustom(String beginDate, String format) {
        return new SimpleDateFormat(format).format(new Date(Long.parseLong(beginDate)));
    }

    /**
     * Format date custom string.
     * 自定义格式的格式化日期时间
     *
     * @param beginDate the begin date
     * @param format    the format
     * @return the string
     */
    public static String formatDateCustom(Date beginDate, String format) {
        return new SimpleDateFormat(format).format(beginDate);
    }

    /**
     * Gets time.
     * 获取系统日期
     *
     * @return the time
     */
    public static String getTime() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(System.currentTimeMillis());
        return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
    }

    /**
     * Gets date.
     * 获取系统时间
     *
     * @return the date
     */
    public static String getDate() {
        return new SimpleDateFormat("yyyyMMdd").format(System.currentTimeMillis());
    }

    /**
     * Get date time string.
     * 获取系统日期时间
     *
     * @return the string
     */
    public static String getDateTime() {
        return DATE_FORMAT_DATETIME.format(System.currentTimeMillis());
    }

    /**
     * Get date time string.
     * 获取系统日期时间
     *
     * @param format the format
     * @return the string
     */
    public static String getDateTime(String format) {
        return new SimpleDateFormat(format).format(System.currentTimeMillis());
    }


    /**
     * Subtract date long.
     * 计算两个时间差
     *
     * @param dateStart the date start
     * @param dateEnd   the date end
     * @return the long
     */
    public static long subtractDate(Date dateStart, Date dateEnd) {
        return dateEnd.getTime() - dateStart.getTime();
    }

    /**
     * Gets date after.
     * 得到几天后的时间
     *
     * @param d   the d
     * @param day the day
     * @return the date after
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * Gets date time after.
     * 得到当前时间指定毫秒后的时间
     *
     * @param mill the mill
     * @return the String
     */
    public static String getDateTimeAfter(long mill) {
        return DATE_FORMAT_DATETIME.format(System.currentTimeMillis() + mill);
    }

    /**
     * Get week of year int.
     * 获取当前时间为本年的第几周
     *
     * @return the int
     */
    public static int getWeekOfYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Gets week of month.
     * 获取当前时间为本月的第几周
     *
     * @return the week of month
     */
    public static int getWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.WEEK_OF_MONTH);
        return week - 1;
    }

    /**
     * Gets day of week.
     * 获取当前时间为本周的第几天
     *
     * @return the day of week
     */
    public static int getDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        if (day == 1) {
            day = 7;
        } else {
            day = day - 1;
        }
        return day;
    }

    /**
     * Gets start time of week.
     * 获取一周开始时间
     *
     * @return the start time of week
     * @throws ParseException the parse exception
     */
    public static Date getStartTimeOfWeek() throws ParseException {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        long time = System.currentTimeMillis();
        if (day > 1) {
            time = time - (day - 2) * 24 * 60 * 60 * 1000L;
        } else {
            time = time - 6 * 24 * 60 * 60 * 1000L;
        }
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date = sdf.parse(sdf.format(date));
        return date;
    }

    /**
     * Gets end time of week.
     * 获取一周结束时间
     *
     * @return the end time of week
     */
    public static Date getEndTimeOfWeek() {
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK);
        long time = System.currentTimeMillis();
        if (day > 1) {
            time = time + (8 - day) * 24 * 60 * 60 * 1000L;
        }
        Date date = new Date(time);
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf2.parse(sdf1.format(date) + " 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * Gets week of date.
     * 根据日期获取星期
     *
     * @param date the date
     * @return the week of date
     */
    public static int getWeekOfDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = null;
        Date targetDate = null;
        try {
            currentDate = sdf.parse(sdf.format(new Date()));
            targetDate = sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (currentDate.getTime() == targetDate.getTime()) {
            return getDayOfWeek();
        } else if (currentDate.getTime() < targetDate.getTime()) {
            return (int) ((targetDate.getTime() - currentDate.getTime()) / (24 * 60 * 60 * 1000)
                    + getDayOfWeek()) % 7;
        } else if (currentDate.getTime() > targetDate.getTime()) {
            return (int) (getDayOfWeek() + 7
                    - (currentDate.getTime() - targetDate.getTime()) / (24 * 60 * 60 * 1000) % 7) % 7;
        }
        return 0;
    }

    /**
     * Gets date list of week.
     * 根据日期获取一周的日期(从周一到周日)
     *
     * @param date the date
     * @return the date list of week
     * @throws ParseException the parse exception
     */
    public static List<Date> getDateListOfWeek(Date date) {
        List<Date> list = new ArrayList<Date>();
        int weekOfDate = getWeekOfDate(date);
        Date firstDay = new Date(date.getTime() - (weekOfDate - 1) * 24 * 60 * 60 * 1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            firstDay = sdf.parse(sdf.format(firstDay));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        list.add(firstDay);
        for (int i = 1; i < 7; i++) {
            if (i == 1) {
                list.add(new Date(firstDay.getTime() + i * 24 * 60 * 60 * 1000L));
            } else {
                list.add(new Date(firstDay.getTime() + (i + 1) * 24 * 60 * 60 * 1000L));
            }
        }
        return list;
    }

    /**
     * Gets age.
     * 根据日期返回年龄
     *
     * @param birthDate the birth date
     * @return the age
     */
    public static int getAge(Date birthDate) {

        if (birthDate == null)
            throw new RuntimeException("出生日期不能为null");

        int age = 0;

        Date now = new Date();

        SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
        SimpleDateFormat format_M = new SimpleDateFormat("MM");

        String birth_year = format_y.format(birthDate);
        String this_year = format_y.format(now);

        String birth_month = format_M.format(birthDate);
        String this_month = format_M.format(now);
        // 初步，估算
        age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);
        // 如果未到出生月份，则age - 1
        if (this_month.compareTo(birth_month) < 0) {
            age -= 1;
        }
        if (age < 0) {
            age = 0;
        }
        return age;
    }

    /**
     * Gets next date.
     * 获得第二条日期
     *
     * @return the next date
     * @throws Exception the exception
     */
    public static Date getNextDate() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        date.setDate(date.getDate() + 1);

        String str = format.format(date);
        return format.parse(str);
    }

    /**
     * Date to str string.
     * 日期转字符串
     *
     * @param date the date
     * @return the string
     */
    public static String date2Str(Date date) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = format.format(date);
        return str;
    }

    /**
     * Str to date date.
     * 字符串转日期
     *
     * @param str the str
     * @return the date
     */
    public static Date str2Date(String str) {
        return str2Date(str, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * String 2 date date.
     * 字符串转换成Date
     *
     * @param s     the s
     * @param style the style
     * @return the date
     */
    public static Date str2Date(String s, String style) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        simpleDateFormat.applyPattern(style);
        Date date = null;
        if (s == null || s.length() < 6) {
            return null;
        }
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * Is ampm string.
     * 判断是上午还是下午
     *
     * @param date the date
     * @return the string
     */
    public static String isAMPM(Date date) {
        GregorianCalendar ca = new GregorianCalendar();
        ca.setTime(date);
        return GregorianCalendar.AM_PM == 0 ? "am" : "pm";
    }


    /**
     * Time am pm night int.
     * 判断指定日期是上午，下午，晚上0-上午；1-下午；2-晚上；3-过期
     *
     * @param date the date
     * @return the int
     */
    public static String isAmPmNight(Date date) {
        String start = "00:00:00";
        String night = "23:59:59";
        String am = "12:00:00";
        String pm = "18:00:00";

        SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
        Date d_start = null;
        Date d_night = null;
        Date d_am = null;
        Date d_pm = null;
        try {
            d_start = s.parse(start);
            d_night = s.parse(night);
            d_am = s.parse(am);
            d_pm = s.parse(pm);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Date paramsTime = str2Date(formatTime(date.getTime()), "HH:mm:ss");

        if (paramsTime.after(d_start) && paramsTime.before(d_am)) {
            return "am";
        }
        if (paramsTime.after(d_am) && paramsTime.before(d_pm)) {
            return "pm";
        }
        if (paramsTime.after(d_pm) && paramsTime.before(d_night)) {
            return "night";
        }
        return "";
    }

    /**
     * Is leap year boolean.
     * 判断是否为闰年
     * @param date the date
     * @return the boolean
     */
    public static boolean isLeapYear(Date date) {

        /**
         * 详细设计： 1.被400整除是闰年，否则： 2.不能被4整除则不是闰年 3.能被4整除同时不能被100整除则是闰年
         * 3.能被4整除同时能被100整除则不是闰年
         */
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
        gc.setTime(date);
        int year = gc.get(Calendar.YEAR);
        if ((year % 400) == 0)
            return true;
        else if ((year % 4) == 0) {
            if ((year % 100) == 0)
                return false;
            else
                return true;
        } else
            return false;
    }

}
