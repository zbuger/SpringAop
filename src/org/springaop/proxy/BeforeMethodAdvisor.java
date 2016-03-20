package org.springaop.proxy;

import java.lang.reflect.Method;



/**
 * 
 * 方法前置顾问，它完成方法的前置操作.
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public class BeforeMethodAdvisor implements Advisor {
	/**
	 * 在方法执行前所进行的操作.
	 */
	public void doInAdvisor(Object proxy, Method method, Object[] args) {
		System.out.println("before process 执行方法名是：" + method.getName());
	}
}
