package org.springaop.proxy;

import java.lang.reflect.Method;



/**
 * 
 * ����ǰ�ù��ʣ�����ɷ�����ǰ�ò���.
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public class BeforeMethodAdvisor implements Advisor {
	/**
	 * �ڷ���ִ��ǰ�����еĲ���.
	 */
	public void doInAdvisor(Object proxy, Method method, Object[] args) {
		System.out.println("before process ִ�з������ǣ�" + method.getName());
	}
}
