/**
 * 
 */
package com.demo.web.model;

import java.io.Serializable;

/**
 * @Title: Orders.java
 * @Package com.demo.web.model
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: liuhao
 * @date: 2019年6月5日 下午3:38:26
 * @version V1.0 注意：本内容仅限于上海正先电子科技有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Orders implements Serializable {
	public static final String WAIT_BUYER_PAY = "WAIT_BUYER_PAY";//等待交易

	public static final String TRADE_SUCCESS = "TRADE_SUCCESS";//交易成功

	public static final String TRADE_CLOSED = "TRADE_SUCCESS";//交易关闭

	public static final String UNKNOWN_STATE = "UNKNOWN_STATE";//未知状态

	private String id; // 订单id

	private String orderNum; // 订单号

	private String orderStatus; // 订单状态

	private Double orderAmount; // 订单金额

	private Double paidAmount; // 实际支付金额

	private String buyCounts; // 产品购买的个数

	private String createTime; // 订单创建时间

	private String paidTime; // 支付时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getBuyCounts() {
		return buyCounts;
	}

	public Double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Double orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public void setBuyCounts(String buyCounts) {
		this.buyCounts = buyCounts;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPaidTime() {
		return paidTime;
	}

	public void setPaidTime(String paidTime) {
		this.paidTime = paidTime;
	}

}
