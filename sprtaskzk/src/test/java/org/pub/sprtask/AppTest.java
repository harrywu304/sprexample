package org.pub.sprtask;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration ({"/applicationContext.xml"})
public class AppTest 
{

	@Test
    public void testApp()
    {
        Object lock = new Object();
        synchronized (lock) {
            try {
				lock.wait();
			} catch (InterruptedException e) {
				System.out.println("主线程关闭中...");
			}
        }
    }
    
}
