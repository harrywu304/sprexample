package org.pub.spraop.service.impl;

import java.util.zip.DataFormatException;

import org.pub.spraop.service.HelloWorld;
import org.springframework.stereotype.Service;

@Service("helloWorldImpl2")
public class HelloWorldImpl2 implements HelloWorld {

	@Override
	public void printHelloWorld() {
		System.out.println("Enter HelloWorldImpl2.printHelloWorld()");

	}

	@Override
	public String doPrint(int id, String name) {
		System.out.println("Enter HelloWorldImpl2.doPrint()");
		return id + name;
	}
	
	@Override
	public void printThrow(){
		try {
			doThrowException();
		} catch (DataFormatException e) {
			throw new ClassCastException("test ClassCastException");
		}
	}
	
	private void doThrowException() throws DataFormatException{
		throw new DataFormatException("test DataFormatException");
	}

}
