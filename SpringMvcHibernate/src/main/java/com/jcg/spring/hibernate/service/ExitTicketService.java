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
	
	@Transactional
	public void addEntryET(ExitTicketEntry exitTicketEntry) {
		log.info("adding entry in database");
		//hibernateTemplate.save(exitTicketEntry);
		try {
			//hibernateTemplate.saveOrUpdate(exitTicketEntry);
			hibernateTemplate.save(exitTicketEntry);
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

	
	public boolean deleteById(Class<?> type, long id) {
//		Session session= sessionFactory.getCurrentSession();
//		Object persistentInstance = session.load(type, id);
//		session.delete(persistentInstance);
//		return true;
		
//		Session session;
//
//		try {
//		    session = sessionFactory.getCurrentSession();
//		} catch (HibernateException e) {
//		    session = sessionFactory.openSession();
//		}
//	    Object persistentInstance = session.load(type, id);
//	    //hibernateTemplate.
//	    log.info("Finish loading");
//	    if (persistentInstance != null) {
//	    	//log.info("just finished DELETE1 -"+persistentInstance);
//	    	session.delete(persistentInstance);
//	    	//log.info("just finished DELETE2 -"+persistentInstance);
//	        return true;
//	    }
//	    return false;
		//hibernateTemplate.bulkUpdate("DELETE from " + type.getName() + " where id=" + id);
		
//		Transaction bt=hibernateTemplate.getSessionFactory().getCurrentSession().beginTransaction();
//	    Object persistentInstance = hibernateTemplate.load(type, id);
//    	hibernateTemplate.delete(persistentInstance);
		
		log.info("entro 1 ------");
		ExitTicketEntry e=(ExitTicketEntry) hibernateTemplate.load(type,id);
		log.info("entro 2");
		//log.info("title of the one to be deleted-> "+e.getTitle());
		//e.getUserETs().remove(e);
		//e.getUserETs().clear();
		hibernateTemplate.delete(e);
		//hibernateTemplate.flush();
		
//		bt.commit();
		
		return true;

		
//		log.info("Deleting type-"+type+" with id-"+id);
//	    Object persistentInstance = hibernateTemplate.load(type, id);
//	    //hibernateTemplate.
//	    log.info("Finish loading");
//	    if (persistentInstance != null) {
//	    	//log.info("just finished DELETE1 -"+persistentInstance);
//	    	hibernateTemplate.delete(persistentInstance);
//	    	//log.info("just finished DELETE2 -"+persistentInstance);
//	        return true;
//	    }
//	    return false;
		
//		ExitTicketEntry e=(ExitTicketEntry)hibernateTemplate.get(type, id);
//		log.info(e);
//		hibernateTemplate.delete(e);
//	    
//		return false;
//	    
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