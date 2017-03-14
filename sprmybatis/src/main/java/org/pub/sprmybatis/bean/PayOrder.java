package org.pub.sprmybatis.bean;

import java.sql.Timestamp;

/**
 * 支付订单
 * @author wuhuoxin 2016年11月22日 下午5:42:34
 * 
 */
public class PayOrder {
	
	/**
	 * 支付订单号
	 */
	private String payOrderId;
	
	/**
	 * 应用ID
	 */
	private String appId;
	
	/**
	 * 业务订单号，同一应用ID中业务订单号唯一
	 */
	private String orderId;
	
	/**
	 * 订单金额，单位分
	 */
	private int amount;
	
	/**
	 * 订单名称
	 */
	private String orderName;
	
	/**
	 * 订单详情描述
	 */
	private String orderContent;
	
	/**
	 * 业务订单创建时间
	 */
	private Timestamp orderCreateTime;
	
	/**
	 * 业务订单送单时间
	 */
	private Timestamp orderSubmitTime;
	
	/**
	 * 支付返回地址
	 */
	private String returnUrl;
	
	/**
	 * 用户ID
	 */
	private String userId;
	
	/**
	 * 商户主体编号，用于支付时直接进账到分校区财务帐号
	 */
	private String merCode;
	
	/**
	 * 附加数据，在查询接口和状态通知中原样返回
	 */
	private String attach;
	
	/**
	 * 支付状态
	 */
	private int payStatus;
	
	/**
	 * 成功支付的次数
	 */
	private int paySucCount;
	
	/**
	 * 最先成功支付的交易流水号
	 */
	private String firstSucTrxId;
	
	/**
	 * 最先成功支付的支付渠道ID
	 */
	private String firstSucChannelId;
	
	/**
	 * 最先成功支付的支付渠道通知时间
	 */
	private Timestamp firstSucNotifyTime;
	
	/**
	 * 订单签名
	 */
	private String sign;
	
	/**
	 * 应用端支付状态通知的结果
	 */
	private int appNotifyStatus;
	
	/**
	 * 应用端支付状态成功通知的时间戳
	 */
	private Timestamp appNotifyTime;
	
	/**
	 * 订单创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 订单更新时间
	 */
	private Timestamp updateTime;

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

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

	/**
	 * @return the orderName
	 */
	public String getOrderName() {
		return orderName;
	}

	/**
	 * @param orderName the orderName to set
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	/**
	 * @return the orderContent
	 */
	public String getOrderContent() {
		return orderContent;
	}

	/**
	 * @param orderContent the orderContent to set
	 */
	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}

	/**
	 * @return the orderCreateTime
	 */
	public Timestamp getOrderCreateTime() {
		return orderCreateTime;
	}

	/**
	 * @param orderCreateTime the orderCreateTime to set
	 */
	public void setOrderCreateTime(Timestamp orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	/**
	 * @return the orderSubmitTime
	 */
	public Timestamp getOrderSubmitTime() {
		return orderSubmitTime;
	}

	/**
	 * @param orderSubmitTime the orderSubmitTime to set
	 */
	public void setOrderSubmitTime(Timestamp orderSubmitTime) {
		this.orderSubmitTime = orderSubmitTime;
	}

	/**
	 * @return the returnUrl
	 */
	public String getReturnUrl() {
		return returnUrl;
	}

	/**
	 * @param returnUrl the returnUrl to set
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the payStatus
	 */
	public int getPayStatus() {
		return payStatus;
	}

	/**
	 * @param payStatus the payStatus to set
	 */
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
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
	 * @return the paySucCount
	 */
	public int getPaySucCount() {
		return paySucCount;
	}

	/**
	 * @param paySucCount the paySucCount to set
	 */
	public void setPaySucCount(int paySucCount) {
		this.paySucCount = paySucCount;
	}

	/**
	 * @return the firstSucTrxId
	 */
	public String getFirstSucTrxId() {
		return firstSucTrxId;
	}

	/**
	 * @param firstSucTrxId the firstSucTrxId to set
	 */
	public void setFirstSucTrxId(String firstSucTrxId) {
		this.firstSucTrxId = firstSucTrxId;
	}

	/**
	 * @return the firstSucChannelId
	 */
	public String getFirstSucChannelId() {
		return firstSucChannelId;
	}

	/**
	 * @param firstSucChannelId the firstSucChannelId to set
	 */
	public void setFirstSucChannelId(String firstSucChannelId) {
		this.firstSucChannelId = firstSucChannelId;
	}

	/**
	 * @return the firstSucNotifyTime
	 */
	public Timestamp getFirstSucNotifyTime() {
		return firstSucNotifyTime;
	}

	/**
	 * @param firstSucNotifyTime the firstSucNotifyTime to set
	 */
	public void setFirstSucNotifyTime(Timestamp firstSucNotifyTime) {
		this.firstSucNotifyTime = firstSucNotifyTime;
	}
	
	/**
	 * @return the appNotifyStatus
	 */
	public int getAppNotifyStatus() {
		return appNotifyStatus;
	}

	/**
	 * @param appNotifyStatus the appNotifyStatus to set
	 */
	public void setAppNotifyStatus(int appNotifyStatus) {
		this.appNotifyStatus = appNotifyStatus;
	}
	
	

	/**
	 * @return the appNotifyTime
	 */
	public Timestamp getAppNotifyTime() {
		return appNotifyTime;
	}

	/**
	 * @param appNotifyTime the appNotifyTime to set
	 */
	public void setAppNotifyTime(Timestamp appNotifyTime) {
		this.appNotifyTime = appNotifyTime;
	}
	
	/**
	 * @return the merCode
	 */
	public String getMerCode() {
		return merCode;
	}

	/**
	 * @param merCode the merCode to set
	 */
	public void setMerCode(String merCode) {
		this.merCode = merCode;
	}
	
	/**
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}

	/**
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PayOrder [payOrderId=" + payOrderId + ", appId=" + appId + ", orderId=" + orderId + ", amount=" + amount
				+ ", orderName=" + orderName + ", orderContent=" + orderContent + ", orderCreateTime=" + orderCreateTime
				+ ", orderSubmitTime=" + orderSubmitTime + ", returnUrl=" + returnUrl + ", userId=" + userId
				+ ", merCode=" + merCode + ", attach=" + attach + ", payStatus=" + payStatus + ", paySucCount="
				+ paySucCount + ", firstSucTrxId=" + firstSucTrxId + ", firstSucChannelId=" + firstSucChannelId
				+ ", firstSucNotifyTime=" + firstSucNotifyTime + ", sign=" + sign + ", appNotifyStatus="
				+ appNotifyStatus + ", appNotifyTime=" + appNotifyTime + ", createTime=" + createTime + ", updateTime="
				+ updateTime + "]";
	}
	
}
