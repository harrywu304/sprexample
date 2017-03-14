/**
 * 
 */
package org.pub.sprmybatis.dao;

import java.sql.Timestamp;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import org.pub.sprmybatis.bean.PayOrder;

/**
 * 支付订单Dao
 * @author wuhuoxin 2016年12月1日 上午10:11:06
 *
 */
@Repository
public interface PayOrderDao {
	
	public int insertPayOrder(PayOrder payOrder);
	
	/**
	 * 根据业务订单号查找支付订单
	 * @param appId 
	 * @param orderId
	 * @return
	 */
	public PayOrder selectPayOrderByOrderId(@Param("appId") String appId, @Param("orderId") String orderId);
	
	/**
	 * 更新业务订单送单时间
	 * @param payOrderId
	 * @param orderSubmitTime
	 * @param returnUrl
	 * @return
	 */
	public int updatePayOrderSubmitTimeAndReturnUrl(@Param("payOrderId") String payOrderId, @Param("orderSubmitTime") Timestamp orderSubmitTime
			,@Param("returnUrl") String returnUrl);
	
	/**
	 * 根据支付订单号查找支付订单
	 * @param payOrderId
	 * @return
	 */
	public PayOrder selectPayOrderById(String payOrderId);	
	
	/**
	 * 更新支付订单的支付结果信息
	 * @param payOrder
	 * @return
	 */
	public int updatePayOrderResult(PayOrder payOrder); 
	
	/**
	 * 更新应用端支付状态通知的结果
	 * @param payOrderId
	 * @return
	 */
	public int updateAppNotifyStatus(@Param("payOrderId") String payOrderId, @Param("appNotifyTime") Timestamp appNotifyTime);
	
	/**
	 * 根据支付订单号和订单状态获取订单信息
	 * @param  payOrderId
	 * @param payStatus
	 * @return
	 */
	public PayOrder selectPayOrderByPayOrderIdAndPayStatus(@Param("payOrderId") String payOrderId, @Param("payStatus") int payStatus);
	
}
