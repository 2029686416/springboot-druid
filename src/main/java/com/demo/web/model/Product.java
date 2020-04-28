package com.demo.web.model;

import java.io.Serializable;

/**
*@author:liuhao
*@version:2020年4月19日下午2:18:37
*@description:
*/
public class Product  implements Serializable {
	private String id;
	
	private String name;
	
	private Integer price;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
