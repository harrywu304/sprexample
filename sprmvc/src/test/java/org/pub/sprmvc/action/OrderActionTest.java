/**
 * 
 */
package org.pub.sprmvc.action;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.BaseJunit4Test;

/**
 * @author wuhuoxin 2016年12月6日 下午5:30:38
 *
 */
public class OrderActionTest extends BaseJunit4Test {
	
	@Resource
	private OrderAction orderAction;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.pub.sprmvc.action.OrderAction#order(java.lang.String, java.lang.String, org.pub.sprmvc.bean.PayOrder)}.
	 */
	@Test
	public void testOrder() {
		orderAction.order("123", "1.0", null);
	}

}
