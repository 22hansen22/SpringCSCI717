package com.jcg.spring.hibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.jcg.spring.hibernate.pojo.User;

public class AuthService {

	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);

	private AuthService() { }

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings( { "unchecked", "deprecation" } )
	public boolean findUser(String uname,String upwd) {
		log.info("Checking the user in the database");
		boolean isValidUser = false;
		String sqlQuery = "from User u where u.user_name=? and u.user_password=?";
		try {
			List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, uname, upwd);
			if(userObj != null && userObj.size() > 0) {
				log.info("Id= " + userObj.get(0).getId() + ", Name= " + userObj.get(0).getUser_name() + ", Password= " + userObj.get(0).getUser_password()+", Type="+userObj.get(0).getUser_type());
				isValidUser = true;
			}
		} catch(Exception e) {
			isValidUser = false;
			log.error("An error occurred while fetching the user details from the database1", e);	
		}
		return isValidUser;
	}
	
	public User findUser2(String uname,String upwd) {
		String sqlQuery = "from User u where u.user_name=? and u.user_password=?";
		if(findUser(uname, upwd)==true) {
			try {
				List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, uname, upwd);
				return userObj.get(0);
			} catch(Exception e) {
				log.error("An error occurred while fetching the user details from the database2", e);	
			}
			
		}
		return null;
	}
	
	//this should be list students instead
	public List<User> listUsers(){
		String sqlQuery = "from User u where u.user_type=?";
	    try {
		    List<User> listU = (List<User>)hibernateTemplate.find(sqlQuery, "student");
		    return listU;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		return null;
	}
	
	public List<Integer> listUserIDs(){
		List<Integer> listOfUserIDs=new ArrayList();
		String sqlQuery = "from User u where u.user_type=?";
	    try {
		    List<User> listU = (List<User>)hibernateTemplate.find(sqlQuery, "student");
		    for(int i=0; i<listU.size();i++) {
		    	listOfUserIDs.add((int) listU.get(i).getId());
		    }
		    return listOfUserIDs;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		return null;
	}
}