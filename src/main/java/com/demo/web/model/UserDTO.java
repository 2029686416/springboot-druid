package com.demo.web.model;

import java.io.Serializable;

/**
*@author:liuhao
*@version:2020年4月19日下午5:41:22
*@description:
*/
public class UserDTO extends User implements Serializable{
	private int page;
	private int rows;
	private String ztmc;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getZtmc() {
		return ztmc;
	}
	public void setZtmc(String ztmc) {
		this.ztmc = ztmc;
	}
}
