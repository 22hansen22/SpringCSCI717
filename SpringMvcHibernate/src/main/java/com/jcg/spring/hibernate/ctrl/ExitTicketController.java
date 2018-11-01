package com.jcg.spring.hibernate.ctrl;

import java.util.ArrayList;
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
	
	private static Logger log = Logger.getLogger(AuthService.class);
	
	@RequestMapping(value={"/exitTicketT"},params = "showETInput", method = RequestMethod.GET)
	public ModelAndView showETInput(){    
		log.info("entro en exitTicketT-showETInput");
	    ModelAndView mv = new ModelAndView("exitTicketT");
	    mv.addObject("showETInput", true);
	
	    return mv;
	}
	
	@RequestMapping(value={"/exitTicketT"},params = "showETList", method = RequestMethod.GET)
	public ModelAndView showETList(@RequestParam("showETList") String listType,@RequestParam(value="id", required=false) Integer id){    
		log.info("entro en exitTicketT-showETList");
	    ModelAndView mv = new ModelAndView("exitTicketT");
	    mv.addObject("showETList", true);
	    
	    //LinkedList<String> etList=null;
	    ArrayList<ArrayList<String>> etList=null;
	    String headerx="";
	    if(listType.equals("showET")) {
	    	etList = getList();
	    	log.info("entro en showET");
	    }
	    else if(listType.equals("showU"))
	    	//etList = getListUsers();
	    
	    //etList=null;
	    if (id!=null) {
	    	//etList =getListETbyUser(id);
	    }
	    
	    mv.addObject("etList", etList);
	    mv.addObject("headerx", headerx);
	    log.info("param->"+listType);
	    return mv;
	}
	
	private ArrayList<ArrayList<String>> getList(){
	    //List<List<String>> list = new List<>();
	    ArrayList<ArrayList<String>> listOLists = new ArrayList<ArrayList<String>>();
	    
	    //list all exit tickets
	    log.info("Listing all exit tickets");

	    try {
		    List<ExitTicketEntry> listET=exitTicketService.listExitTickets();
		    log.info("Im out "+listET.size());
		    for (int i=0; i<listET.size(); i++) {
		    	ArrayList<String> row = new ArrayList<String>();
		    	row.add(Integer.toString(listET.get(i).getId()));
		    	row.add(listET.get(i).getTitle());
		    	row.add(listET.get(i).getDateET());
		    	listOLists.add(row);
		    	//list.add(listET.get(i).getId()+" "+listET.get(i).getTitle()+" "+listET.get(i).getDateET());
		    }
		    return listOLists;
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
	
	private LinkedList<String> getListETbyUser(int id){
		//id of user
		LinkedList<String> list = new LinkedList<String>();
	    
	    //list all exit tickets
	    log.info("Listing all exit tickets for an specific user");

	    try {
		    List<UserET> listETbyUser=userEtService.findExitTicketsByUser(id);
		    log.info("#of elements in the list-> "+listETbyUser.size());
		    for (int i=0; i<listETbyUser.size(); i++) {
		    	list.add(listETbyUser.get(i).getUser().getId()+" "+listETbyUser.get(i).getExitTicketEntry().getTitle()
		    			+" "+listETbyUser.get(i).getAnswer());
		    }
		    return list;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    }
		
		//SQL query in the userET table to see which ET that user has
		//save results in list
		
	}
}