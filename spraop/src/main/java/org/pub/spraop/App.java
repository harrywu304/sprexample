package org.pub.spraop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {
	
	public static void main(String[] args){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		RunService runService = ctx.getBean(RunService.class);
		runService.doSomething();
	}
	


}
