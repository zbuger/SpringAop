package org.springaop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * AOP处理器.
 * @author dinghui
 * @Creation date: 2008-9-16
 */
public class AopHandler implements InvocationHandler {
	// 需要代理的目标对象
	private Object target;

	// 方法前置顾问
	Advisor beforeAdvisor;

	// 方法后置顾问
	Advisor afterAdvisor;

	/**
	 * 设置代理目标对象，并生成动态代理对象.
	 * 
	 * @param target 代理目标对象
	 * @return 返回动态代理对象
	 */
	public Object setObject(Object target) {
		// 设置代理目标对象
		this.target = target;
		// 根据代理目标对象生成动态代理对象
		Object obj = Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
		return obj;
	}

	/**
	 * 若定义了前置处理，则在方法执行前执行前置处理， 若定义了后置处理，则在方法调用后调用后置处理.
	 * 
	 * @param proxy
	 *            代理对象
	 * @param method
	 *            调用的业务方法
	 * @param args
	 *            方法的参数
	 * @return 返回结果信息
	 * @throws Throwable
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 进行业务方法的前置处理
		if (beforeAdvisor != null) {
			beforeAdvisor.doInAdvisor(proxy, method, args);
		}
		// 执行业务方法（反射机制）
		Object result = method.invoke(target, args);
		// 进行业务方法的后置处理
		if (afterAdvisor != null) {
			afterAdvisor.doInAdvisor(proxy, method, args);
		}
		// 返回结果对象
		return result;
	}

	/**
	 * 设置方法的前置顾问.
	 * 
	 * @param advisor
	 *            方法的前置顾问
	 */
	public void setBeforeAdvisor(Advisor advisor) {
		this.beforeAdvisor = advisor;
	}

	/**
	 * 设置方法的后置顾问.
	 * 
	 * @param advisor
	 *            方法的后置顾问
	 */
	public void setAfterAdvisor(Advisor advisor) {
		this.afterAdvisor = advisor;
	}
}