package com.demo.web.model;

import java.util.List;

/**
*@author:liuhao
*@version:2020年5月12日下午6:12:08
*@description:
*/
public class Menu {
	private Integer id;
	
	private String name;
	
	private String url;
	
	private String logo;
	
	private String parentid;
	
	private List<Menu> children;
	
 	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

}
