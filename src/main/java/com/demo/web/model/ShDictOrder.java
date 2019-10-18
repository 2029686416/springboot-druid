package com.demo.web.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class ShDictOrder {
    private String id;

    private String orderNo;

    private Object devId;

    private BigDecimal money;

    private BigDecimal way;

    private String payNo;

    private String tradeNo;

    private BigDecimal payStatus;

    private Date createTime;

    private Date finishTime;

    private String payMemo;

    
    
    
    

	

	

	public ShDictOrder() {
		super();
	}
	

	public ShDictOrder(String id, String orderNo, Object devId) {
		super();
		this.id = id;
		this.orderNo = orderNo;
		this.devId = devId;
	}


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

 











	public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Object getDevId() {
        return devId;
    }

    public void setDevId(Object devId) {
        this.devId = devId;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getWay() {
        return way;
    }

    public void setWay(BigDecimal way) {
        this.way = way;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public BigDecimal getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(BigDecimal payStatus) {
        this.payStatus = payStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getPayMemo() {
        return payMemo;
    }

    public void setPayMemo(String payMemo) {
        this.payMemo = payMemo;
    }

	@Override
	public String toString() {
		return "{ orderNo=" + orderNo + ", devId=" + devId + "}";
	}



	
    
    
}