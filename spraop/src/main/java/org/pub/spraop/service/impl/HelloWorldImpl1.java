package org.pub.spraop.service.impl;

import org.pub.spraop.service.HelloWorld;
import org.springframework.stereotype.Service;

@Service("helloWorldImpl1")
public class HelloWorldImpl1 implements HelloWorld {

	@Override
	public void printHelloWorld() {
		System.out.println("Enter HelloWorldImpl1.printHelloWorld()");

	}

	@Override
	public String doPrint(int id, String name) {
		System.out.println("Enter HelloWorldImpl1.doPrint()");
		return id + name;
	}
	
	@Override
	public void printThrow() {
		doThrowException();
	}
	
	private void doThrowException(){
		throw new RuntimeException("test runtimeexception");
	}

}
