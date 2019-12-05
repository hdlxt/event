/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.sishuok.register;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-7-8 下午9:43
 * <p>Version: 1.0
 */
public class RegisterServiceIT {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config-register.xml");

		RegisterService registerService = context.getBean(RegisterService.class);

		registerService.register("long", "123");
	}
}
