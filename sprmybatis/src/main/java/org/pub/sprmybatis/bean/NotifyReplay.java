/**
 * 
 */
package org.pub.sprmybatis.bean;

import java.sql.Timestamp;

/**
 * 需进行支付状态异步通知的订单记录
 * @author wuhuoxin 2016年12月15日 下午3:51:30
 *
 */
public class NotifyReplay {
	
	/**
	 * 支付订单ID
	 */
	private String payOrderId;
	
	/**
	 * 应用ID
	 */
	private String appId;
	
	/**
	 * 通知次数，同步通知算第一次
	 */
	private int notifyCount;
	
	/**
	 * 最后一次尝试通知的时间
	 */
	private Timestamp lastTryTime;
	
	private Timestamp createTime;

	private Timestamp updateTime;
	
	/**
	 * 用于通知回放的全参数Url
	 */
	private String fullNotifyUrl;

	/**
	 * @return the payOrderId
	 */
	public String getPayOrderId() {
		return payOrderId;
	}

	/**
	 * @param payOrderId the payOrderId to set
	 */
	public void setPayOrderId(String payOrderId) {
		this.payOrderId = payOrderId;
	}

	/**
	 * @return the notifyCount
	 */
	public int getNotifyCount() {
		return notifyCount;
	}

	/**
	 * @param notifyCount the notifyCount to set
	 */
	public void setNotifyCount(int notifyCount) {
		this.notifyCount = notifyCount;
	}

	/**
	 * @return the lastTryTime
	 */
	public Timestamp getLastTryTime() {
		return lastTryTime;
	}

	/**
	 * @param lastTryTime the lastTryTime to set
	 */
	public void setLastTryTime(Timestamp lastTryTime) {
		this.lastTryTime = lastTryTime;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the fullNotifyUrl
	 */
	public String getFullNotifyUrl() {
		return fullNotifyUrl;
	}

	/**
	 * @param fullNotifyUrl the fullNotifyUrl to set
	 */
	public void setFullNotifyUrl(String fullNotifyUrl) {
		this.fullNotifyUrl = fullNotifyUrl;
	}

	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	
}
