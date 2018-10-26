package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;

public class ExitTicketEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String title, dateET;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDateET() {
		return dateET;
	}
	public void setDateET(String dateET) {
		this.dateET = dateET;
	}

	
	
}