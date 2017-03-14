/**
 * 
 */
package org.pub.sprmybatis.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.junit.Test;
import org.pub.sprmybatis.bean.PayOrder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import base.BaseJunit4Test;

/**
 * @author wuhuoxin 2016年12月12日 下午6:52:10
 *
 */
public class PayOrderDaoTest extends BaseJunit4Test {
	
	@Resource
	private PayOrderDao payOrderDao;
	
	@Test
	public void testSelectPayOrderById(){
		String payOrderId = "o1b56qac0pcsajDU5sQSjanCihh-0qJd";
		PayOrder payOrder = payOrderDao.selectPayOrderById(payOrderId);
		assertNotNull(payOrder);
	}

	/**
	 * Test method for {@link org.pub.sprmybatis.dao.PayOrderDao#updatePayOrderResult(org.pub.pay.bean.PayOrder)}.
	 */
	@Test
	@Transactional
	//rollback default is true
	@Rollback(true)	
	public void testUpdatePayOrderResult() {
		PayOrder payOrder = new PayOrder();
		payOrder.setPayStatus(0);
		payOrder.setPayOrderId("o1b56qac0pcsajDU5sQSjanCihh-0qJd");
		payOrder.setFirstSucChannelId("alipay");
		payOrder.setFirstSucTrxId("e9a77bcb-b5d4-484f-a0c1-b6817274920f");
		payOrder.setFirstSucNotifyTime(Timestamp.valueOf("2016-12-13 12:12:12"));
		
//		payOrder.setFirstSucChannelId(null);
//		payOrder.setFirstSucTrxId(null);
//		payOrder.setFirstSucNotifyTime(null);		
		int rt = payOrderDao.updatePayOrderResult(payOrder);
		assertEquals(1,rt);
	}

}
