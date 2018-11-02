package com.jcg.spring.hibernate.ctrl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.spring.hibernate.pojo.ExitTicketEntry;
import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.pojo.UserET;
import com.jcg.spring.hibernate.service.AuthService;
import com.jcg.spring.hibernate.service.ExitTicketService;
import com.jcg.spring.hibernate.service.UserETService;

@Controller
@RequestMapping("/user")
public class ExitTicketController {
	
	@Autowired
	private ExitTicketService exitTicketService;			// This will auto-inject the authentication service into the controller.
	@Autowired
	private AuthService authenticateService;
	@Autowired
	private UserETService userEtService;
	
	private SessionFactory sessionFactory;

	
	private static Logger log = Logger.getLogger(AuthService.class);
	
	@RequestMapping(value={"/exitTicketT"},params = "showETInput", method = RequestMethod.GET)
	public ModelAndView showETInput(){    
		log.info("entro en exitTicketT-showETInput");
	    ModelAndView mv = new ModelAndView("exitTicketT");
	    mv.addObject("showETInput", true);
	    mv.addObject("command", new ExitTicketEntry());
	    return mv;
	}
	
	@RequestMapping(value = "/exitTicketT/addExitTicket", method = RequestMethod.GET)
	public String addUser(@ModelAttribute("SpringWeb") ExitTicketEntry exitTicketEntry, ModelMap model) {
		
		log.info("entro en insert a new ET");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.dd.yyyy");
		LocalDate localDate = LocalDate.now();
		exitTicketEntry.setDateET(dtf.format(localDate));
		
		exitTicketService.addEntryET(exitTicketEntry);
		
		return "redirect:/user/exitTicketT?showETList=showETList";
	}
	
	@RequestMapping(value={"/exitTicketT"},params = "showETList", method = RequestMethod.GET)
	public ModelAndView showETList(@RequestParam("showETList") String listType,@RequestParam(value="id", required=false) Integer id){    
		log.info("entro en exitTicketT-showETList");
	    ModelAndView mv = new ModelAndView("exitTicketT");
	    mv.addObject("showETList", listType);
	    
	    String headerx="";
	    if(listType.equals("showETList")) {
	    	List<ExitTicketEntry> etList = getList();
	    	mv.addObject("etList", etList);
    		mv.addObject("countList2", getNumberOfUsersPerET());
	    }
	    else if(listType.equals("showUserList")) {
	    	List<User> usersList = getListUsers();
    		mv.addObject("usersList", usersList);
    		mv.addObject("countList", getNumberOfETPerUser());
	    }
	    else if(listType.equals("showUsersForET")) {
	    	List<UserET> usersForET = getListUserByET(id);
	    	mv.addObject("usersForET", usersForET);
	    }
	    else if(listType.equals("showETForUser")) {
	    	List<UserET> etForUsers = getListETByUser(id);
	    	mv.addObject("etForUsers", etForUsers);
	    }
	    else if(listType.equals("deleteItem")) {
	    	if (id!=null) {
	    		//List<UserET> etForUsers = getListETByUser(id);
	    		//return "redirect:/user/exitTicketT?showETList=showETList";
	    		log.info("entro en delete item-> "+id);
	    		boolean result = exitTicketService.deleteById(ExitTicketEntry.class, id);
	    		//boolean result = exitTicketService.deleteById2(id);
	    		//boolean result = exitTicketService.deleteById(id);
	    		log.info("deleted?="+result+" ID#="+id);
	    		return new ModelAndView("redirect:/user/exitTicketT?showETList=showETList");
	    	}
	    	
	    }
	    
	    
	    if (id!=null) {
	    	//etList =getListETbyUser(id);
	    }
	    
	    
	    mv.addObject("headerx", headerx);
	    log.info("param->"+listType);
	    return mv;
	}
	
	private List<ExitTicketEntry> getList(){
	    try {
		    List<ExitTicketEntry> listET=exitTicketService.listExitTickets();
		    log.info("Im out "+listET.size());
		    return listET;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    }
	}
	
	private List<User> getListUsers(){
	    log.info("Listing all users");

	    try {
		    List<User> listU=authenticateService.listUsers();
		    log.info("Im out "+listU.size());
		    return listU;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    	
	    }
	}
	
	private List<UserET> getListETByUser(int id){
	    try {
		    List<UserET> listETbyUser=userEtService.findExitTicketsByUser(id);
		    return listETbyUser;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    }
	}
	
	private List<UserET> getListUserByET(int id){
	    try {
		    List<UserET> listETbyUser=userEtService.findUsersByExitTicket(id);
		    return listETbyUser;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    }
	}
	
	private List<Integer> getNumberOfETPerUser(){
		List<Integer> output=new ArrayList();
		List<Integer> l=authenticateService.listUserIDs();
		for(int i=0;i<l.size(); i++) {
			output.add(userEtService.countETByUserID(l.get(i)));
		}
		return output;
	}
	private List<Integer> getNumberOfUsersPerET(){
		List<Integer> output=new ArrayList();
		List<Integer> l=exitTicketService.listETIDs();
		for(int i=0;i<l.size(); i++) {
			output.add(userEtService.countUsersByETID(l.get(i)));
		}
		return output;
	}
}

