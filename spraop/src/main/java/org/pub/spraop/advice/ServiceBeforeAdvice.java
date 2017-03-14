package org.pub.spraop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class ServiceBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("ServiceBeforeAdvice before ...start");
		System.out.println(method.toString());
		if(args != null & args.length > 0){
			for(Object arg:args){
				System.out.println(arg);
			}
		}
		System.out.println(target);
		System.out.println("ServiceBeforeAdvice before ...end");
	}

}
