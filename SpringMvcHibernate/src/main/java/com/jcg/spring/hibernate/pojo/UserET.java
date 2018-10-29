package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;

public class UserET implements Serializable {

	private static final long serialVersionUID = 1L;

	private int answerId,user_id,ticket_id;
	private String answer, dateAnswer;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDateAnswer() {
		return dateAnswer;
	}
	public void setDateAnswer(String dateAnswer) {
		this.dateAnswer = dateAnswer;
	}
	
	
	
}