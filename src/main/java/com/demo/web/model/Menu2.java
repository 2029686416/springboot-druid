package com.demo.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
*@author:liuhao
*@version:2020年5月12日下午6:12:08
*@description:
*/
public class Menu2 implements Serializable{
	private String id;
	
	private String name;
	
	private String url;
	
	private String logo;
	
	private String parentid;
	
//	@JsonBackReference
	private List<Menu2> children;
	
	@JsonBackReference
	private Menu2 menu2;
	
	@JsonBackReference
	public Menu2 getMenu2() {
		return menu2;
	}
	@JsonBackReference
	public void setMenu2(Menu2 menu2) {
		this.menu2 = menu2;
	}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public List<Menu2> getChildren() {
		return children;
	}

	public void setChildren(List<Menu2> children) {
		this.children = children;
	}

}
