package com.jcg.spring.hibernate.ctrl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.spring.hibernate.pojo.ExitTicketEntry;
import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.service.AuthService;
import com.jcg.spring.hibernate.service.ExitTicketService;

@Controller
@RequestMapping("/user")
public class ExitTicketController {
	
	@Autowired
	private ExitTicketService exitTicketService;			// This will auto-inject the authentication service into the controller.
	@Autowired
	private AuthService authenticateService;
	
	private static Logger log = Logger.getLogger(AuthService.class);
	
	@RequestMapping(value={"/exitTicketT"},params = "showETInput", method = RequestMethod.GET)
	public ModelAndView showETInput(){    
		log.info("entro en exitTicketT-showETInput");
	    ModelAndView mv = new ModelAndView("exitTicketT");
	    mv.addObject("showETInput", true);
	
	    return mv;
	}
	
	@RequestMapping(value={"/exitTicketT"},params = "showETList", method = RequestMethod.GET)
	public ModelAndView showETList(@RequestParam("showETList") String listType){    
		log.info("entro en exitTicketT-showETList");
	    ModelAndView mv = new ModelAndView("exitTicketT");
	    mv.addObject("showETList", true);
	    
	    LinkedList<String> etList=null;
	    if(listType.equals("showET"))
	    	etList = getList();
	    else if(listType.equals("showU"))
	    	etList = getListUsers();
	    
	    mv.addObject("etList", etList);
	    log.info("param->"+listType);
	    return mv;
	}
	
	private LinkedList<String> getList(){
	    LinkedList<String> list = new LinkedList<String>();
	    
	    //list all exit tickets
	    log.info("Listing all exit tickets");

	    try {
		    List<ExitTicketEntry> listET=exitTicketService.listExitTickets();
		    log.info("Im out "+listET.size());
		    for (int i=0; i<listET.size(); i++) {
		    	list.add(listET.get(i).getId()+" "+listET.get(i).getTitle());
		    }
		    return list;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    }
	}
	
	private LinkedList<String> getListUsers(){
	    LinkedList<String> list = new LinkedList<String>();
	    
	    //list all users
	    log.info("Listing all users");

	    try {
		    List<User> listU=authenticateService.listUsers();
		    log.info("Im out "+listU.size());
		    for (int i=0; i<listU.size(); i++) {
		    	list.add(listU.get(i).getUserRealName());
		    }
		    return list;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    	
	    }
	}
	
	private LinkedList<String> getListETbyUser(String id){
		
		
		return null;
	}
}