package com.db_clear.enums.math;

/**
 * double 0-10
 * 
 * @title: com.ymfs.web.enums.DoubleVal：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2018年4月20日 下午5:37:12
 */
public enum DoubleVal {
	
	zero(0.00), one(1.00), two(2.00), three(3.00), four(4.00), five(5.00), six(6.00), seven(7.00), eight(8.00), nine(9.00), ten(10.00), eleven(11.00), one_hundred(100.00);

	private double val;

	private DoubleVal(double val) {
		this.val = val;
	}

	public double getVal() {
		return val;
	}

	public void setVal(double val) {
		this.val = val;
	}

	public double val() {
		return val;
	}

}
