/**
 * 
 */
package org.pub.sprtask.service;


/**
 * 发货通知服务（业务方订单支付状态通知服务）
 * @author wuhuoxin 2016年12月14日 上午11:10:34
 *
 */
public interface DeliverNotifyService {
	
	/**
	 * 分钟级别异步通知回放
	 */
	public void minutelyAsyncNotify();
	
}
