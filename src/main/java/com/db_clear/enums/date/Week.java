package com.db_clear.enums.date;

/**
 * @title:TODO 星期格式
 * @Description: 
 * @author: tuhejie
 * @PackageName: com.thj.enums.date
 * @ClassName: Week
 * @Date: 2018年6月15日 上午10:28:23
 */
public enum Week {

	/** The MONDAY. */
	MONDAY("星期一", "Monday", "Mon.", 1),

	/** The TUESDAY. */
	TUESDAY("星期二", "Tuesday", "Tues.", 2),

	/** The WEDNESDAY. */
	WEDNESDAY("星期三", "Wednesday", "Wed.", 3),

	/** The THURSDAY. */
	THURSDAY("星期四", "Thursday", "Thur.", 4),

	/** The FRIDAY. */
	FRIDAY("星期五", "Friday", "Fri.", 5),

	/** The SATURDAY. */
	SATURDAY("星期六", "Saturday", "Sat.", 6),

	/** The SUNDAY. */
	SUNDAY("星期日", "Sunday", "Sun.", 7);

	/**
	 * 中文名称
	 */
	String cnName;

	/**
	 * 英文名称
	 */
	String enName;

	/**
	 * 英文简称
	 */
	String enShortName;

	/**
	 * 星期对应天数
	 */
	int number;

	/**
	 * @param cnName 中文名称
	 * @param enName 英文名称
	 * @param enShortName 英文简称
	 * @param number 星期对应天数
	 */
	Week(String cnName, String enName, String enShortName, int number) {
		this.cnName = cnName;
		this.enName = enName;
		this.enShortName = enShortName;
		this.number = number;
	}

	/**
	 * 获取中文名称
	 *
	 * @return the chinese name
	 */
	
	public String getChineseName() {
		return cnName;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getEnglishName() {
		return enName;
	}

	/**
	 * Gets the short name.
	 *
	 * @return the short name
	 */
	public String getEnglishShortName() {
		return enShortName;
	}

	/**
	 * Gets the number.
	 *
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
}
