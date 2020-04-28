package com.demo.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable{
	private String id;
	
	private String username;
	
	private String sex;
	
	private String hobby;
	
	private List<Product> productList;
	
	private Product product;

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	public String getHobby() {
		return hobby;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", sex=" + sex + ", hobby=" + hobby + "]";
	}
	public void setId(String id) {
		this.id = id;
	}

    public User() {
        super();
    }
    public User(String username, String sex, String hobby) {
        super();
        this.username = username;
        this.sex = sex;
        this.hobby = hobby;
    }
}
