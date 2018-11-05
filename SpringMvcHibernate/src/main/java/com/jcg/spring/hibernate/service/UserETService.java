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

	public List<UserET> findExitTicketsByUser(long userId){
		String sqlQuery = "from UserET u where u.user.id=?";	// u where u.user_id=?
	    try {
		    List<UserET> list = (List<UserET>)hibernateTemplate.find(sqlQuery, userId);
		    return list;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		log.info("entro en listExitTickets by UserID");
		return null;
	}
	
	public List<UserET> findUsersByExitTicket(long exitTicketId){
		String sqlQuery = "from UserET u where u.exitTicketEntry.id=?";	
	    try {
		    List<UserET> list = (List<UserET>)hibernateTemplate.find(sqlQuery, exitTicketId);
		    return list;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		log.info("entro en  findUsersByExitTicket");
		return null;
	}
	
	public int countETByUserID(long userId){
		List<UserET> l=findExitTicketsByUser(userId);
		return l.size();
	}
	
	public int countUsersByETID(long exitTicketId){
		List<UserET> l=findUsersByExitTicket(exitTicketId);
		return l.size();
	}
}