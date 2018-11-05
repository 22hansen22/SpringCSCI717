package com.jcg.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.jcg.spring.hibernate.pojo.ExitTicketEntry;
import com.jcg.spring.hibernate.pojo.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.service.*;
import org.jboss.logging.Logger;


public class ExitTicketService {

	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);
	
	@Autowired
	private SessionFactory sessionFactory;


	private ExitTicketService() { }

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public List<ExitTicketEntry> listExitTickets(){
		String sqlQuery = "from ExitTicketEntry";
	    try {
		    List<ExitTicketEntry> listU = (List<ExitTicketEntry>)hibernateTemplate.find(sqlQuery);
		    return listU;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		log.info("entro en listExitTickets");
		return null;
	}
	
	public List<Integer> listETIDs(){
		List<Integer> listOfExitTicketIDs=new ArrayList();
		String sqlQuery = "from ExitTicketEntry";
	    try {
	    	List<ExitTicketEntry> listET = (List<ExitTicketEntry>)hibernateTemplate.find(sqlQuery);
		    for(int i=0; i<listET.size();i++) {
		    	listOfExitTicketIDs.add((int) listET.get(i).getId());
		    }
		    return listOfExitTicketIDs;
	    }catch(Exception e) {
			log.error("An error occurred while querying the database", e);	
	    }
		return null;
	}
	
	public void addEntryET(ExitTicketEntry exitTicketEntry) {
		log.info("adding entry in database");
		try {
			hibernateTemplate.save(exitTicketEntry);
		}
		catch(Exception e) {
			log.info("error adding an entry in the database->"+e.toString());
		}
	}
	
	@Transactional
	public void deleteById(Class<?> type, long id) {
		log.info("entro 1 ------");
		ExitTicketEntry e=(ExitTicketEntry) hibernateTemplate.load(type,id);
		hibernateTemplate.delete(e);
	}
}