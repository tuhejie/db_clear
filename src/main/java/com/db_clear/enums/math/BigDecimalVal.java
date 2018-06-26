package com.db_clear.enums.math;

import java.math.BigDecimal;

/**
 * int 0-10
 * 
 * @title: com.ymfs.web.enums.BigDecimalVal：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2018年4月20日 下午5:37:12
 */
public enum BigDecimalVal {
	
	zero(0), one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), eleven(11), one_hundred(100);

	private BigDecimal val;

	private BigDecimalVal(int val) {
		this.val = new BigDecimal(val);
	}

	public BigDecimal getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = new BigDecimal(val);
	}

	public BigDecimal val() {
		return val;
	}

}
