package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "exit_ticket")
public class ExitTicketEntry implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private String dateET;
	private Set<UserET> userETs= new HashSet<UserET>();
	
	public ExitTicketEntry() {
    }
 
    public ExitTicketEntry(String title,String dateET) {
        this.title = title;
        this.dateET = dateET;
    }     
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "ticket_id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	@OneToMany(mappedBy = "exitTicketEntry", orphanRemoval=true)
    public Set<UserET> getUserETs() {
        return userETs;
    }
 
    public void setUserETs(Set<UserET> userETs) {
        this.userETs = userETs;
    }
     
    public void addUserETs(UserET userETs) {
        this.userETs.add(userETs);
    }
	

	
	
}