package org.springaop.proxy;

import java.lang.reflect.Method;


/**
 * 
 * 方法的后置顾问，它完成方法的后置操作.
 * 
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public class AfterMethodAdvisor implements Advisor {
	/**
	 * 在方法执行后所进行的操作.
	 */
	public void doInAdvisor(Object proxy, Method method, Object[] args) {
		System.out.println("after process " + method);
	}
}