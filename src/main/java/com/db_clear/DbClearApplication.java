package com.db_clear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages= {"com.db_clear.mappers"})
public class DbClearApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DbClearApplication.class, args);
	}
}
