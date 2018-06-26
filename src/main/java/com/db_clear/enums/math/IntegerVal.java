package com.db_clear.enums.math;

/**
 * int 0-10
 * 
 * @title: com.ymfs.web.enums.IntegerVal：
 * @description：TODO
 * @author: create by weiyanhao
 * @date: 2018年4月20日 下午5:37:12
 */
public enum IntegerVal {
	
	zero(0), one(1), two(2), three(3), four(4), five(5), six(6), seven(7), eight(8), nine(9), ten(10), one_hundred(100),
	minus_one(-1), minus_two(-2), minus_three(-3), minus_four(-4), minus_five(-5), minus_six(-6), minus_seven(-7), minus_eight(-8), 
	minus_nine(-9), minus_ten(-10)
	;
	
	private int val;

	private IntegerVal(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public int val() {
		return val;
	}

}
