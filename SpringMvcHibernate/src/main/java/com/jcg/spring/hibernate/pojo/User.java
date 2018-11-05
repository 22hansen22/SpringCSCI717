package com.jcg.spring.hibernate.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User implements Serializable {

	//private static final long serialVersionUID = 1L;

	private long id;
	private String user_name, user_password, user_type,user_realname;

    private Set<UserET> userETs= new HashSet<UserET>();
    
    public User() {
    }
 
    public User(String user_name,String user_password,String user_type,String user_realname) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_type = user_type;
        this.user_realname=user_realname;
    }
     
    public void addExitTicketEntry(UserET group) {
        this.userETs.add(group);
    }
    
    @Id
	@GeneratedValue
	@Column(name="user_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "user")
    public Set<UserET> getUserETs() {
        return userETs;
    }
 
    public void setUserETs(Set<UserET> userETs) {
        this.userETs = userETs;
    }
    
    public void addUserETs(UserET userETs) {
        this.userETs.add(userETs);
    } 
    
	/***********************************************/
    
    public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public String getUser_realname() {
		return user_realname;
	}

	public void setUser_realname(String user_realname) {
		this.user_realname = user_realname;
	}

	
	
}