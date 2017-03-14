package org.pub.spraop.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

@Component
public class ServiceThrowAdvice implements ThrowsAdvice {
	
	public void afterThrowing(Exception ex){
		System.out.println("ServiceThrowAdvice afterThrowing: "+ex);
	}

}
