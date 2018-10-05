package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String loginName, name, password, type;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return loginName;
	}

	public void setLogin(String login) {
		this.loginName = loginName;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}