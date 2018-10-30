package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="userET")
public class UserET implements Serializable {

	private static final long serialVersionUID = 1L;

	private int answerId;
	private User user;
	private ExitTicketEntry exitTicketEntry;
	private String answer;
	private Date dateAnswer;
	
	@Id
	@GeneratedValue
	@Column(name="answerId")
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")  
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id")  
	public ExitTicketEntry getTicket() {
		return exitTicketEntry;
	}
	public void setTicket_id(ExitTicketEntry exitTicketEntry) {
		this.exitTicketEntry = exitTicketEntry;
	}
	
	@Column(name = "answer")
	public String getAnswer(){
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Column(name = "dateAnswer")
    @Temporal(TemporalType.DATE)
	public Date getDateAnswer() {
		return dateAnswer;
	}
	public void setDateAnswer(Date dateAnswer) {
		this.dateAnswer = dateAnswer;
	}
	
	/*
	 * answerId int NOT NULL,
  user_id int NOT NULL,
  ticket_id int NOT NULL,
  answer varchar(50) NOT NULL,
  dateAnswer date,*/
	
}