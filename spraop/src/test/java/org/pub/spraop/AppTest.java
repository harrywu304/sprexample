package org.pub.spraop;

import javax.annotation.Resource;

import org.junit.Test;
import org.pub.spraop.service.HelloWorld;

import base.BaseJunit4Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends BaseJunit4Test {
	
	@Resource(name="helloWorldImpl1")
	private HelloWorld hw1;
	
	@Resource(name="helloWorldImpl2")
	private HelloWorld hw2;
	

	/**
	 * Rigourous Test :-)
	 */
	//@Test
	public void testApp() {
		hw1.printHelloWorld();
		System.out.println();
		System.out.println();
		hw2.printHelloWorld();
		System.out.println();
	}
	
	
	@Test
	public void testApp2() {
//		hw1.printHelloWorld();
//		System.out.println();
		String rt = hw1.doPrint(123, "harry");
		System.out.println("rt:"+rt);
//		System.out.println();
//		hw1.printThrow();
//		System.out.println();
	}
}
