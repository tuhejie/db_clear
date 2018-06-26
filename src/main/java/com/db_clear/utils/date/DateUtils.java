package com.db_clear.utils.date;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.db_clear.enums.date.DateStyle;
import com.db_clear.enums.math.IntegerVal;
import com.db_clear.utils.math.NumberUtils;
import com.db_clear.utils.string.StringUtils;



/**
 * @remark: 日期工具类
 * @title: DataUtils.java
 * @author: weiyanhao
 * @date: 2018年4月15日 下午4:01:26
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

	public static final long MILLIS_30_DAY = 30 * MILLIS_PER_DAY;
	
	public static final long MILLIS_31_DAY = 31 * MILLIS_PER_DAY;
	
	public static final long MILLIS_365_DAY = 365 * MILLIS_PER_DAY;
	
	/**
	 * @title: TODO 获取当前时间的时间戳
	 * @description: 
	 * @author: create by weiyanhao
	 * @date: 2018年4月25日 下午2:24:00
	 * @return
	 */
	public static long getCurrentMilli() {
		return System.currentTimeMillis();
	}
	
	//-----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addYears(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.YEAR, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addYears(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.YEAR, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of years to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addQuarters(final String date, final int amount) throws ParseException {
    	int length = date.length();
    	String y = StringUtils.substring(date, IntegerVal.zero.val(), length - IntegerVal.one.val());
    	String q = StringUtils.substring(date, length - IntegerVal.one.val());
    	return y + (NumberUtils.toInt(q) + amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of months to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addMonths(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.MONTH, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of months to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addMonths(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of weeks to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addWeeks(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.WEEK_OF_YEAR, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of weeks to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addWeeks(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.WEEK_OF_YEAR, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of days to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addDays(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.DAY_OF_MONTH, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of days to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addDays(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.DAY_OF_MONTH, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of hours to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addHours(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.HOUR_OF_DAY, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of hours to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addHours(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.HOUR_OF_DAY, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addMinutes(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.MINUTE, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of minutes to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addMinutes(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.MINUTE, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of seconds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addSeconds(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.SECOND, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of seconds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addSeconds(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.SECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addMilliseconds(final String date, final DateStyle style, final int amount) throws ParseException {
        return add(date, style, Calendar.MILLISECOND, amount);
    }
    
    //-----------------------------------------------------------------------
    /**
     * Adds a number of milliseconds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    public static String addMilliseconds(final String date, final String style, final int amount) throws ParseException {
    	return add(date, style, Calendar.MILLISECOND, amount);
    }

    //-----------------------------------------------------------------------
    /**
     * Adds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    private static String add(final String date, final DateStyle style, final int calendarField, final int amount) throws ParseException {
        return add(date, style.getValue(), calendarField, amount);
    }
    //-----------------------------------------------------------------------
    
    //-----------------------------------------------------------------------
    /**
     * Adds to a date returning a new object.
     * The original {@code Date} is unchanged.
     *
     * @param date  the date, not null
     * @param calendarField  the calendar field to add to
     * @param amount  the amount to add, may be negative
     * @return the new {@code Date} with the amount added
     * @throws ParseException 
     * @throws IllegalArgumentException if the date is null
     */
    private static String add(final String date, final String pattern, final int calendarField, final int amount) throws ParseException {
    	final Date d = parseDate(date, pattern);
    	final Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(calendarField, amount);
    	return DateFormatUtils.format(c.getTime(), pattern);
    }
    //-----------------------------------------------------------------------
    
	/**
	 * @title:TODO 
	 * @Description: 获得某日的开始时间，即2018-01-01 00:00:00
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午4:50:58
	 * @param date 
	 * @return
	 */
	public static String getDayStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_00_00_00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 获得某日的开始时间，即2018-01-01 00:00:00
	 * @Description: 
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午4:52:40
	 * @param dateStr
	 * @return
	 */
	public static String getDayStartTime(String dateStr) {
		Date date = DateFormatUtils.StringToDate(dateStr, DateStyle.YYYY_MM_DD);
		return getDayStartTime(date);
	}
	
	/**
	 * @title:TODO 某日的结束时间，即2018-01-31 23:59:59
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午4:55:41
	 * @param date
	 * @return
	 */
	public static String getDayEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_23_59_59);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 某日的结束时间，即2018-01-31 23:59:59
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午4:56:48
	 * @param dateStr
	 * @return
	 */
	public static String getDayEndTime(String dateStr) {
		Date date = DateFormatUtils.StringToDate(dateStr, DateStyle.YYYY_MM_DD);
		return getDayEndTime(date);
	}
	
	/**
	 * @title:TODO 获得某月的开始时间，即2018-01-01 00:00:00
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午4:59:57
	 * @param date
	 * @return
	 */
	public static String getMonthStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			calendar.set(Calendar.DATE, 1);
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_00_00_00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 获得某月的开始日期，即2018-01-01
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午4:59:57
	 * @param date
	 * @return
	 */
	public static String getMonthStartDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			calendar.set(Calendar.DATE, 1);
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 获得某月的开始时间，即2018-01-01 00:00:00
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:00:08
	 * @param dateStr
	 * @return
	 */
	public static String getMonthStartTime(String dateStr) {
		Date date = DateFormatUtils.StringToDate(dateStr, DateStyle.YYYY_MM);
		return getMonthStartTime(date);
	}
	
	/**
	 * @title:TODO 某月的结束时间，即2018-01-31 23:59:59
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:00:37
	 * @param date
	 * @return
	 */
	public static String getMonthEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			calendar.set(Calendar.DATE, 1);
			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.DATE, -1);
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_23_59_59);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 某月的结束时间，即2018-01-31 23:59:59
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:00:37
	 * @param date
	 * @return
	 */
	public static String getMonthEndTime(String dateStr) {
		Date date = DateFormatUtils.StringToDate(dateStr, DateStyle.YYYY_MM);
		return getMonthEndTime(date);
	}
	
	/**
	 * @title:TODO 获取某年某季度的开始时间，即2018-01-1 00:00:00
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:05:03
	 * @param quarterStr: 2016-1 指2016第一季度
	 * @return
	 */
	public static String getQuarterStartTime(String quarterStr) {
		String[] dateArr = quarterStr.split("-");
		int i = Integer.parseInt(dateArr[1]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(dateArr[0]));
		String now = null;
		try {
			if (i == 1)
				calendar.set(Calendar.MONTH, 0);
			else if (i == 2)
				calendar.set(Calendar.MONTH, 3);
			else if (i == 3)
				calendar.set(Calendar.MONTH, 6);
			else if (i == 4)
				calendar.set(Calendar.MONTH, 9);
			calendar.set(Calendar.DATE, 1);
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_00_00_00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 某年某季度的结束时间，即2012-03-31 23:59:59
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:06:03
	 * @param quarterStr: 2016-1 指2016第一季度
	 * @return
	 */
	public static String getQuarterEndTime(String quarterStr) {
		String[] dateArr = quarterStr.split("-");
		int i = Integer.parseInt(dateArr[1]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, Integer.parseInt(dateArr[0]));
		String now = null;
		try {
			if (i == 1) {
				calendar.set(Calendar.MONTH, 2);
				calendar.set(Calendar.DATE, 31);
			} else if (i == 2) {
				calendar.set(Calendar.MONTH, 5);
				calendar.set(Calendar.DATE, 30);
			} else if (i == 3) {
				calendar.set(Calendar.MONTH, 8);
				calendar.set(Calendar.DATE, 30);
			} else if (i == 4) {
				calendar.set(Calendar.MONTH, 11);
				calendar.set(Calendar.DATE, 31);
			}
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_23_59_59);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 当某年的开始时间，即2018-01-01 00:00:00
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:08:43
	 * @param date:
	 * @return
	 */
	public static String getYearStartTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			calendar.set(Calendar.MONTH, 0);
			calendar.set(Calendar.DATE, 1);
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_00_00_00);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
	/**
	 * @title:TODO 当某年的开始时间，即2018-01-01 00:00:00
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:10:03
	 * @param dateStr
	 * @return
	 */
	public static String getYearStartTime(String dateStr) {
		return getYearStartTime(DateFormatUtils.StringToDate(dateStr, DateStyle.YYYY));
	}
	
	/**
	 * @title:TODO 当前年的结束时间，即2018-12-31 23:59:59
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月29日 下午5:11:29
	 * @param date
	 * @return
	 */
	public static String getYearEndTime(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String now = null;
		try {
			calendar.set(Calendar.MONTH, 11);
			calendar.set(Calendar.DATE, 31);
			now = DateFormatUtils.DateToString(calendar.getTime(), DateStyle.YYYY_MM_DD_23_59_59);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}
	
}
