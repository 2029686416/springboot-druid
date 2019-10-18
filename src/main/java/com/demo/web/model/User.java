package com.demo.web.model;

import java.io.Serializable;

import javax.persistence.*;

public class User implements Serializable{
	private String id;
	
	private String username;
	
	private String sex;
	
	private String hobby;
	
    public String getHobby() {
		return hobby;
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
