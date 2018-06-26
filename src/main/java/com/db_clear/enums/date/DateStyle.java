/**
 * 
 */
package com.db_clear.enums.date;

/**
 * 此类描述的是：时间戳格式.
 * @title com.maoxf.admin.enums.DateStyle.java
 * @description TODO 
 * @author zr_le  
 * @date 2018年6月4日 下午3:18:00
 */
public enum DateStyle {
	
	// #####################################(- :)分割########################################
	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss"),
	YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm"),
	YYYY_MM_DD_HH("yyyy-MM-dd HH"),
	YYYY_MM_DD("yyyy-MM-dd"),
	YYYY_MM("yyyy-MM"),
	YYYY("yyyy"),
	
	MM_DD_HH_MM_SS("MM-dd HH:mm:ss"),
	MM_DD_HH_MM("MM-dd HH:mm"),
	MM_DD_HH("MM-dd HH"),
	MM_DD("MM-dd"),
	MM("MM"),
	
	DD_HH_MM_SS("dd HH:mm:ss"),
	DD_HH_MM("dd HH:mm"),
	DD_HH("dd HH"),
	DD("dd"),
	
	HH_MM_SS("HH:mm:ss"),
	HH_MM("HH:mm"),
	HH("HH"),
	
	MM_SS("mm:ss"),
	mm("mm"),
	
	ss("ss"),
	
	YYYY_MM_DD_00_00_00("yyyy-MM-dd 00:00:00"),
	YYYY_MM_DD_23_59_59("yyyy-MM-dd 23:59:59"),
	// #####################################(- :)分割########################################
	
	// #####################################("")分割########################################
	YYYYMMDDHHMMSS("yyyyMMddHHmmss"),
	YYYYMMDDHHMM("yyyyMMddHHmm"),
	YYYYMMDDHH("yyyyMMddHH"),
	YYYYMMDD("yyyyMMdd"),
	YYYYMM("yyyyMM"),
	
	MMDDHHMMSS("MMddHHmmss"),
	MMDDHHMM("MMddHHmm"),
	MMDDHH("MMddHH"),
	MMDD("MMdd"),
	
	DDHHMMSS("ddHHmmss"),
	DDHHMM("ddHHmm"),
	DDHH("ddHH"),
	
	HHMMSS("HHmmss"),
	HHMM("HHmm"),
	
	MMSS("mmss"),
	// #####################################("")分割########################################

	POINT_YYYY_MM_DD("yyyy.MM.dd"),

	/** MM/dd. */
	MM_DD_EN("MM/dd"),
	/** yyyy/MM. */
	YYYY_MM_EN("yyyy/MM"),
	/** yyyy/MM/dd. */
	YYYY_MM_DD_EN("yyyy/MM/dd"),
	/** MM/dd HH:mm. */
	MM_DD_HH_MM_EN("MM/dd HH:mm"),

	/** MM/dd HH:mm:ss. */
	MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss"),
	/** yyyy/MM/dd HH:mm. */
	YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm"),

	/** yyyy/MM/dd HH:mm:ss. */
	YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss"),

	/** MM月dd日. */
	MM_DD_CN("MM月dd日"),
	/** yyyy年MM月. */
	YYYY_MM_CN("yyyy年MM月"),
	/** yyyy年MM月dd日. */
	YYYY_MM_DD_CN("yyyy年MM月dd日"),
	/** MM月dd日 HH:mm. */
	MM_DD_HH_MM_CN("MM月dd日 HH:mm"),

	/** yyyyMMdd. */
	YYYY_MM_DD_NONE_STYLE("yyyyMMdd"),

	/** MM月dd日 HH:mm:ss. */
	MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss"),
	/** yyyy年MM月dd日 HH:mm. */
	YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm"),

	/** yyyy年MM月dd日 HH:mm:ss. */
	YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss");

	/** The value. */
	private String value;

	/**
	 * The Constructor.
	 *
	 * @param value
	 *            the value
	 */
	DateStyle(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
