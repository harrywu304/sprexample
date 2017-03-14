package org.pub.spraop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class ServiceReturnAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ServiceReturnAdvice afterReturning...start");
		System.out.println(returnValue);
		System.out.println("ServiceReturnAdvice afterReturning...end");
	}

}
