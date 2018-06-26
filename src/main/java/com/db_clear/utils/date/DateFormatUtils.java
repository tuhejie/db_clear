package com.db_clear.utils.date;

import java.util.Calendar;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.db_clear.enums.date.DateStyle;
import com.db_clear.enums.math.IntegerVal;
import com.db_clear.utils.string.StringUtils;



/**
 * @remark: 日期格式化工具类
 * @title: DateFormatUtils.java
 * @author: weiyanhao
 * @date: 2018年4月20日 下午11:09:55
 */
public class DateFormatUtils extends org.apache.commons.lang3.time.DateFormatUtils {
	
	private static final String QUARTER_PATTERN = "第{0}季度";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * @TODO: 获取当前日期
	 * @author: weiyanhao
	 * @date: 2018年4月20日 下午11:16:58
	 * @return 
	 */
	public static String getDay() {
		return formatYYYY_MM_DD(new Date());
	}
	
	/**
	 * @TODO: 获取当前时间
	 * @author: weiyanhao
	 * @date: 2018年4月20日 下午11:18:34
	 * @return
	 */
	public static String getTime() {
		return formatHH_MM_SS(new Date());
	}
	
	/**
	 * @TODO: 获取当前日期时间
	 * @author: weiyanhao
	 * @date: 2018年4月20日 下午11:18:51
	 * @return
	 */
	public static String getDate() {
		return formatYYYY_MM_DD_HH_MM_SS(new Date());
	}
	
	public static String formatYYYY_MM_DD_HH_MM_SS(Date date) {
		return format(date, DateStyle.YYYY_MM_DD_HH_MM_SS.getValue());
	}
	
	public static String formatYYYY_MM_DD(Date date) {
		return format(date, DateStyle.YYYY_MM_DD.getValue());
	}
	
	public static String formatHH_MM_SS(Date date) {
		return format(date, DateStyle.HH_MM_SS.getValue());
	}
	
	public static String formatYYYY(Date date) {
		return format(date, DateStyle.YYYY.getValue());
	}
	
	public static String formatQuarterYYYYQ(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH);
		StringBuilder now = new StringBuilder("");
		switch (m) {
			case 0:
			case 1:
			case 2:
				now.append(y).append(1);
				break;
			case 3:
			case 4:
			case 5:
				now.append(y).append(2);
				break;
			case 6:
			case 7:
			case 8:
				now.append(y).append(3);
				break;
			case 9:
			case 10:
			case 11:
				now.append(y).append(4);
				break;
	
			default:
				break;
		}
		return now.toString();
	}
	
	public static String formatYYYYMM(Date date) {
		return format(date, DateStyle.YYYYMM.getValue());
	}
	
	public static String formatYYYYMMDD(Date date) {
		return format(date, DateStyle.YYYYMMDD.getValue());
	}
	
	public static String formatYYYYMMDDHH(Date date) {
		return format(date, DateStyle.YYYYMMDDHH.getValue());
	}
	
	public static String formatHH(Date date) {
		return format(date, DateStyle.HH.getValue());
	}
	
	/**
	 * @title: TODO 年度字符串 2018 -> 18
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:50:30  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYY2YY(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.two.val());
		return year;
	}
	
	/**
	 * @title: TODO 季度字符串 2018-1 -> 20181
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:50:30  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYY_Q2YYYYQ(String originalDate) {
		return StringUtils.replaceAll(originalDate, StringUtils.STIKE, StringUtils.EMPTY);
	}
	
	/**
	 * @title: TODO 季度字符串 20181 -> 2018-1
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:50:30  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYQ2YYYY_Q(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.zero.val(), IntegerVal.four.val());
		// 季度
		String qval = StringUtils.substring(originalDate, IntegerVal.four.val());
		return new StringBuffer(year).append(StringUtils.STIKE).append(qval).toString();
	}
	
	/**
	 * @title: TODO 季度字符串 20181 -> 2018-第1季度
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:50:30  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYQ2YYYY_Q_CN(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.zero.val(), IntegerVal.four.val());
		// 季度
		String qval = StringUtils.substring(originalDate, IntegerVal.four.val());
		return new StringBuffer(year).append(StringUtils.STIKE).append(MessageFormat.format(QUARTER_PATTERN, qval)).toString();
	}
	
	/**
	 * @title: TODO 月字符串 2018-01 -> 201801
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:02  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYY_MM2YYYYMM(String originalDate) {
		return StringUtils.replaceAll(originalDate, StringUtils.STIKE, StringUtils.EMPTY);
	}
	
	/**
	 * @title: TODO 月字符串 201801 -> 2018-01
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:02  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYMM2YY_MM(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.two.val(), IntegerVal.four.val());
		// 月
		String month = StringUtils.substring(originalDate, IntegerVal.four.val());
		return new StringBuffer(year).append(StringUtils.STIKE).append(month).toString();
	}
	
	/**
	 * @title: TODO 月字符串 201801 -> 2018-01
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:02  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYMM2YYYY_MM(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.zero.val(), IntegerVal.four.val());
		// 月
		String month = StringUtils.substring(originalDate, IntegerVal.four.val());
		return new StringBuffer(year).append(StringUtils.STIKE).append(month).toString();
	}
	
	/**
	 * @title: TODO 日期字符串 2018-01-01 -> 20180101
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:32  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYY_MM_DD2YYYYMMDD(String originalDate) {
		return StringUtils.replaceAll(originalDate, StringUtils.STIKE, StringUtils.EMPTY);
	}
	
	/**
	 * @title: TODO 日期字符串 2018-01-01 -> 20180101
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:32  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYY_MM_DD2YYYYMMDD_EN(String originalDate) {
		return StringUtils.replaceAll(originalDate, StringUtils.STIKE, StringUtils.LEFT_SLASH);
	}
	
	/**
	 * @title: TODO 日期字符串 20180101 -> 18-01-01
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:32  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYMMDD2YY_MM_DD(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.two.val(), IntegerVal.four.val());
		// 月
		String month = StringUtils.substring(originalDate, IntegerVal.four.val(), IntegerVal.six.val());
		// 日
		String day = StringUtils.substring(originalDate, IntegerVal.six.val());
		return new StringBuffer(year).append(StringUtils.STIKE).append(month).append(StringUtils.STIKE).append(day).toString();
	}
	
	/**
	 * @title: TODO 日期字符串 20180101 -> 01-01
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:32  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYMMDD2MM_DD(String originalDate) {
		// 月
		String month = StringUtils.substring(originalDate, IntegerVal.four.val(), IntegerVal.six.val());
		// 日
		String day = StringUtils.substring(originalDate, IntegerVal.six.val());
		return new StringBuffer(month).append(StringUtils.STIKE).append(day).toString();
	}
	
	/**
	 * @title: TODO 日期字符串 20180101 -> 2018-01-01
	 * @description 
	 * @author zr_le  
	 * @date 2018年6月4日 下午3:51:32  
	 * @param originalDate
	 * @return
	 */
	public static String fromYYYYMMDD2YYYY_MM_DD(String originalDate) {
		// 年
		String year = StringUtils.substring(originalDate, IntegerVal.zero.val(), IntegerVal.four.val());
		// 月
		String month = StringUtils.substring(originalDate, IntegerVal.four.val(), IntegerVal.six.val());
		// 日
		String day = StringUtils.substring(originalDate, IntegerVal.six.val());
		return new StringBuffer(year).append(StringUtils.STIKE).append(month).append(StringUtils.STIKE).append(day).toString();
	}
	
	/**
	 * @TODO: 将日期转化为日期字符串。失败返回 ""
	 * @Author: tuhejie
	 * @Date: 2018年5月22日 下午3:47:18
	 * @param date 日期
	 * @param dateStyle 日期风格
	 * @return
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null && date != null) {
			try {
				dateString = getDateFormat(dateStyle.getValue()).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}
	
	/**
	 * 将日期转化为日期字符串。失败返回null。.
	 *
	 * @param date
	 *            日期
	 * @param parttern
	 *            日期格式
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, String parttern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(parttern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}
	
	/**
	 * @title:TODO 将日期字符串转化为日期。失败返回null。
	 * @Author: tuhejie
	 * @Date: 2018年5月22日 下午3:57:35
	 * @param date 日期字符串
	 * @param dateStyle 日期风格
	 * @return 日期
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (date != null && dateStyle != null) {
			if (date != null) {
				try {
					myDate = getDateFormat(dateStyle.getValue()).parse(date);
				} catch (Exception e) {
				}
			}
		}else {
			return null;
		}
		return myDate;
	}
	
	/**
	 * @title:TODO 获取SimpleDateFormat.
	 * @Date: 2018年5月22日 下午3:51:41
	 * @param parttern 日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException 异常：非法日期格式
	 */
	private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {
		return new SimpleDateFormat(parttern);
	}
	
	/**
	 * @title:TODO 创建时间：显示和当前时间时长 【1分钟内】，显示：刚刚 【1小时内】，显示：{分钟}分钟前 如：距离当前时间差59分钟，则显示：59分钟前；
	 * 			不满整数时间点则向上取整。如，距离当前时间差23分钟30秒，则显示：23分钟前 【1天以内】，显示：{小时}小时前 【1天以上】，显示：{天}天前
	 * @Description:
	 * @Author: tuhejie
	 * @Date: 2018年5月24日 上午9:45:46
	 * @param date
	 * @return
	 */
	public static String timeDistance(Date date) {
		if (date == null) {
			return StringUtils.EMPTY;
		}

		Date currentDate = new Date();
		Long dateMilliseconds = date.getTime();
		Long currentDateMilliseconds = currentDate.getTime();

		Long gapMilliseconds = currentDateMilliseconds - dateMilliseconds;
		if (gapMilliseconds < 1 * 60 * 1000) {
			return "刚刚";
		}

		if (gapMilliseconds < 1 * 60 * 60 * 1000) {
			Long min = gapMilliseconds / (1 * 60 * 1000);
			return min + "分钟";
		}

		if (gapMilliseconds < 24 * 60 * 60 * 1000) {
			Long hour = gapMilliseconds / (1 * 60 * 60 * 1000);
			return hour + "小时";
		}

		Long day = gapMilliseconds / (1 * 24 * 60 * 60 * 1000);
		return day + "天";
	}
	
}