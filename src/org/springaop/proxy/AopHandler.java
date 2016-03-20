package org.springaop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP������.
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public class AopHandler implements InvocationHandler {
	// ��Ҫ�����Ŀ�����
	private Object target;

	// ����ǰ�ù���
	Advisor beforeAdvisor;

	// �������ù���
	Advisor afterAdvisor;

	/**
	 * ���ô���Ŀ����󣬲����ɶ�̬�������.
	 * 
	 * @param target ����Ŀ�����
	 * @return ���ض�̬�������
	 */
	public Object setObject(Object target) {
		// ���ô���Ŀ�����
		this.target = target;
		// ���ݴ���Ŀ��������ɶ�̬�������
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
		return obj;
	}

	/**
	 * ��������ǰ�ô������ڷ���ִ��ǰִ��ǰ�ô��� �������˺��ô������ڷ������ú���ú��ô���.
	 * 
	 * @param proxy
	 *            �������
	 * @param method
	 *            ���õ�ҵ�񷽷�
	 * @param args
	 *            �����Ĳ���
	 * @return ���ؽ����Ϣ
	 * @throws Throwable
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// ����ҵ�񷽷���ǰ�ô���
		if (beforeAdvisor != null) {
			beforeAdvisor.doInAdvisor(proxy, method, args);
		}
		// ִ��ҵ�񷽷���������ƣ�
		Object result = method.invoke(target, args);
		// ����ҵ�񷽷��ĺ��ô���
		if (afterAdvisor != null) {
			afterAdvisor.doInAdvisor(proxy, method, args);
		}
		// ���ؽ������
		return result;
	}

	/**
	 * ���÷�����ǰ�ù���.
	 * 
	 * @param advisor
	 *            ������ǰ�ù���
	 */
	public void setBeforeAdvisor(Advisor advisor) {
		this.beforeAdvisor = advisor;
	}

	/**
	 * ���÷����ĺ��ù���.
	 * 
	 * @param advisor
	 *            �����ĺ��ù���
	 */
	public void setAfterAdvisor(Advisor advisor) {
		this.afterAdvisor = advisor;
	}
}