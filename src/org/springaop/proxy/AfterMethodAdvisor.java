package org.springaop.proxy;

import java.lang.reflect.Method;


/**
 * 
 * �����ĺ��ù��ʣ�����ɷ����ĺ��ò���.
 * 
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public class AfterMethodAdvisor implements Advisor {
	/**
	 * �ڷ���ִ�к������еĲ���.
	 */
	public void doInAdvisor(Object proxy, Method method, Object[] args) {
		System.out.println("after process " + method);
	}
}