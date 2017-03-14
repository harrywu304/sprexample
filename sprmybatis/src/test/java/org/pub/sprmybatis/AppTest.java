package org.pub.sprmybatis;

import org.pub.sprmybatis.bean.PayOrder;
import org.pub.sprmybatis.dao.PayOrderDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	PayOrderDao dao = context.getBean(PayOrderDao.class);
    	PayOrder payOrder = dao.selectPayOrderById("o1b56qac0pcsajDU5sQSjanCihh-0qJd");
        assertNotNull( payOrder );
    }
}
