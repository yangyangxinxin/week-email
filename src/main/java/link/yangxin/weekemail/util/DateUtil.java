package link.yangxin.weekemail.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yangxin
 * @date 2018/9/7
 */
public class DateUtil {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        String imptimeBegin = sdf.format(cal.getTime());
        System.out.println("所在周星期一的日期：" + imptimeBegin);
        cal.add(Calendar.DATE, 2);
        String imptimeMi = sdf.format(cal.getTime());
        System.out.println("所在周星期三的日期：" + imptimeMi);
        cal.add(Calendar.DATE, 2);
        String imptimeEnd = sdf.format(cal.getTime());
        System.out.println("所在周星期五的日期：" + imptimeEnd);

    }

    /**
     * 获取上周五时间
     */
    public static Date lastFirday() {

        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 7 - dayOfWeek;
        calendar.add(Calendar.DATE, offset - 9);

        //这是从上周日开始数的到本周五为6
        return getFirstDayOfWeek(calendar.getTime(), 6);

    }


    /**
     * 获取上周一时间
     */
    public static Date lastMonday() {
        Calendar calendar = Calendar.getInstance();
        while (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            calendar.add(Calendar.DAY_OF_WEEK, -1);
        }
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int offset = 1 - dayOfWeek;
        calendar.add(Calendar.DATE, offset - 7);
        return getFirstDayOfWeek(calendar.getTime(), 2);
    }


    /**
     * 得到某一天的该星期的第一日 00:00:00
     *
     * @param date
     * @param firstDayOfWeek 一个星期的第一天为星期几
     * @return
     */
    public static Date getFirstDayOfWeek(Date date, int firstDayOfWeek) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        cal.setFirstDayOfWeek(firstDayOfWeek);//设置一星期的第一天是哪一天
        cal.set(Calendar.DAY_OF_WEEK, firstDayOfWeek);//指示一个星期中的某天
        cal.set(Calendar.HOUR_OF_DAY, 0);//指示一天中的小时。HOUR_OF_DAY 用于 24 小时制时钟。例如，在 10:04:15.250 PM 这一时刻，HOUR_OF_DAY 为 22。
        cal.set(Calendar.MINUTE, 0);//指示一小时中的分钟。例如，在 10:04:15.250 PM 这一时刻，MINUTE 为 4。
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}