package com.jcg.spring.hibernate.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.jcg.spring.hibernate.pojo.ExitTicketEntry;
import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.pojo.UserET;

public class UserETService {

	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);

	private UserETService() { }

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
/*
	@SuppressWarnings( { "unchecked", "deprecation" } )
	public boolean findUser(String uname,String upwd) {
		log.info("Checking the user in the database");
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.name=? and u.password=?";
		try {
			List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, uname, upwd);
			if(userObj != null && userObj.size() > 0) {
				log.info("Id= " + userObj.get(0).getId() + ", Name= " + userObj.get(0).getName() + ", Password= " + userObj.get(0).getPassword()+", Type="+userObj.get(0).getType());
				isValidUser = true;
			}
		} catch(Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database", e);	
		}
		return isValidUser;
	}
	
	public User findUser2(String uname,String upwd) {
		String sqlQuery = "from User u where u.name=? and u.password=?";
		if(findUser(uname, upwd)==true) {
			try {
				List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, uname, upwd);
				return userObj.get(0);
			} catch(Exception e) {
				log.error("An error occurred while fetching the user details from the database", e);	
			}
			
		}
		return null;
	}
	*/
	public List<UserET> findExitTicketsByUser(int userId){
		String sqlQuery = "from UserET u where u.user.id=?";	// u where u.user_id=?
	    try {
	    	//User ux=new User();
	    	//ux.setId(userId);
	    	//User userx = (User) hibernateTemplate.get(User.class, new Integer(userId));
		    List<UserET> list = (List<UserET>)hibernateTemplate.find(sqlQuery, userId);
		    //List<UserET> list = (List<UserET>)hibernateTemplate.find(sqlQuery);
		    return list;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		log.info("entro en listExitTickets by UserID");
		return null;
		
	}
}