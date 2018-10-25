package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;

public class ExitTicketEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id, user_id;
	private String title, answer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	
}