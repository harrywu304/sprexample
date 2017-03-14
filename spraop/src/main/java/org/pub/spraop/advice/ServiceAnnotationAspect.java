package org.pub.spraop.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAnnotationAspect {

	@Before("execution(* org.pub.spraop.service.HelloWorld.doPrint(..)) && args(id,name)")
	public void doBeforeCheck(int id, String name) {
		System.out.println("ServiceAnnotationAspect doBeforeCheck");
		System.out.println("id:" + id);
		System.out.println("name:" + name);
	}

	@AfterReturning(pointcut = "execution(* org.pub.spraop.service.HelloWorld.doPrint(..))", returning = "retVal")
	public void doReturnCheck(Object retVal) {
		System.out.println("ServiceAnnotationAspect doReturnCheck:" + retVal);
	}
	
	//使用Around可以对方法进行加强
	@Around("execution(* org.pub.spraop.service.HelloWorld.doPrint(..))")
	public Object processTx(ProceedingJoinPoint jp)  
	        throws java.lang.Throwable { 
		System.out.println("Around  method : before ");  
        System.out.println("method  name:" + jp.getSignature());  
        System.out.println("method  arguments" + Arrays.toString(jp.getArgs()));  
        System.out.println("target:" + jp.getTarget());  
        try{  
            Object result = jp.proceed();  
            System.out.println("Around method : after "); 
            return  result;  
        }catch(IllegalArgumentException e){  
            System.out.println("Around method : throw  an  exception ");  
            throw  e;  
        } 
         
	}

}
