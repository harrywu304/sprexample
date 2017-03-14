package org.pub.spraop;

import javax.annotation.Resource;

import org.pub.spraop.service.HelloWorld;
import org.springframework.stereotype.Component;

@Component
public class RunService {
	
	@Resource(name="helloWorldImpl1")
	private HelloWorld hw1;
	
	@Resource(name="helloWorldImpl2")
	private HelloWorld hw2;
	
	public void doSomething(){
		hw1.printHelloWorld();
		System.out.println();
		hw1.doPrint(123,"harry");
		System.out.println();
		hw2.printHelloWorld();
		System.out.println();
		hw2.doPrint(456,"demo");
	}
}
