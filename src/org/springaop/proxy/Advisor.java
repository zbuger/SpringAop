package org.springaop.proxy;

import java.lang.reflect.Method;

/**
 * 
 * ���ʽӿ���.
 * 
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public interface Advisor {
	/**
	 * �����Ĳ���.
	 */
	public void doInAdvisor(Object proxy, Method method, Object[] args);
}
