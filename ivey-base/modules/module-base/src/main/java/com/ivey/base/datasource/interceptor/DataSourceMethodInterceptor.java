package com.ivey.base.datasource.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import com.ivey.base.datasource.dynamic.DBContextHolder;
import com.ivey.base.module.dao.member.MemberBaseDao;
import com.ivey.base.module.dao.platform.PlatformBaseDao;

public class DataSourceMethodInterceptor implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {

	public void afterThrowing(RuntimeException rx) {

	}

	/**
	 * 对未知异常的处理.
	 */
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
		System.out.println("*************************************");
		System.out.println("Error happened in class: " + target.getClass().getName());
		System.out.println("Error happened in method: " + method.getName());

		for (int i = 0; i < args.length; i++) {
			System.out.println("arg[" + i + "]: " + args[i]);
		}

		System.out.println("Exception class: " + ex.getClass().getName());
		System.out.println("*************************************");
	}

	/**
	 * 对NumberFormatException异常的处理
	 */
	public void afterThrowing(Method method, Object[] args, Object target, NumberFormatException ex) throws Throwable {
		System.out.println("*************************************");
		System.out.println("Error happened in class: " + target.getClass().getName());
		System.out.println("Error happened in method: " + method.getName());

		for (int i = 0; i < args.length; i++) {
			System.out.println("args[" + i + "]: " + args[i]);
		}

		System.out.println("Exception class: " + ex.getClass().getName());
		System.out.println("*************************************");
	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		System.err.println("Method returning ");

	}

	public void before(Method method, Object[] args, Object target) throws Throwable {

		if (target instanceof MemberBaseDao) {
			System.err.println("Member database");
			DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_MEMBER);

		} else if (target instanceof PlatformBaseDao) {
			System.err.println("PLatform database");
			DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_PLATFORM);
		}
	}

}