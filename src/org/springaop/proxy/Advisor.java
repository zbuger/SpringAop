package org.springaop.proxy;

import java.lang.reflect.Method;

/**
 * 
 * 顾问接口类.
 * 
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public interface Advisor {
	/**
	 * 所做的操作.
	 */
	public void doInAdvisor(Object proxy, Method method, Object[] args);
}
