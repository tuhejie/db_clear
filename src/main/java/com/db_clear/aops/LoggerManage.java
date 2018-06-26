package com.db_clear.aops;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @title:TODO 日志注解
 * @Description: 日志统一处理
 * @author: tuhejie
 * @PackageName: com.aop
 * @ClassName: LoggerManage
 * @Date: 2018年6月13日 下午4:36:32
 */
@Target(ElementType.METHOD)  
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LoggerManage {

	public String description();
}
