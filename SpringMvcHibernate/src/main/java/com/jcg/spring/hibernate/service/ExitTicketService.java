package com.jcg.spring.hibernate.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Propagation;

import com.jcg.spring.hibernate.pojo.ExitTicketEntry;
import com.jcg.spring.hibernate.pojo.User;


public class ExitTicketService {

	private HibernateTemplate hibernateTemplate;
	private static Logger log = Logger.getLogger(AuthService.class);
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
		//hibernateTemplate.save(exitTicketEntry);
		try {
			hibernateTemplate.saveOrUpdate(exitTicketEntry);
//		Session session = sessionFactory.openSession();
//		Transaction tx = session.getTransaction();
//		try {
//			tx.begin();
//			session.saveOrUpdate(exitTicketEntry);
//			tx.commit();
		}
		catch(Exception e) {
			log.info("error adding an entry in the database->"+e.toString());
		}
	}
	
//	public boolean deleteById(int id) {
//		log.info("deleting entry in database");
//		//hibernateTemplate.save(exitTicketEntry);
//		ExitTicketEntry et=new ExitTicketEntry();
//		et.setId(id);
//		try {
//			hibernateTemplate.delete(et);
//			return true;
//		}
//		catch(Exception e) {
//			log.info("error adding an entry in the database->"+e.toString());
//		}
//		return false;
//	}
//	
//	public boolean deleteById2(int id) {
//		
//		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//		org.hibernate.query.Query query=session.createQuery("delete ExitTicketEntry where id = :ID");
//		query.setParameter("ID", id);
//		
//		int result = query.executeUpdate();
//		
//		return false;
//		
//	}
	
	public boolean deleteById(Class<?> type, int id) {
	    Object persistentInstance = hibernateTemplate.load(type, id);
	    if (persistentInstance != null) {
	    	hibernateTemplate.delete(persistentInstance);
	        return true;
	    }
	    return false;
//		try {
//			ExitTicketEntry et=new ExitTicketEntry();
//			et.setId(id);
//			hibernateTemplate.delete(et);
//			return true;
//		}catch(Exception e) {
//			log.error("error deleting Exit Ticket");
//		}
//		return false;
	}
}