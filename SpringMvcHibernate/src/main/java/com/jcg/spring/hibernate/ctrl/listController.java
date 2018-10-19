package com.jcg.spring.hibernate.ctrl;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.service.AuthService;

@Controller
@RequestMapping("/user")
public class listController {
	
	@Autowired
	private AuthService authenticateService;			// This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(AuthService.class);
	
	@RequestMapping(value={"/teacherGroup"}, method = RequestMethod.GET)
	public ModelAndView listStudents(){    
		log.info("entro en teacherGroup");
	    LinkedList<String> list = getList();
	    ModelAndView mv = new ModelAndView("teacherGroup");
	    mv.addObject("lists", list);
	
	    return mv;
	}
	
	@RequestMapping(params = "group", method = RequestMethod.POST)
	public ModelAndView listEmployee2(){    
		log.info("entro en group Students ");
	    LinkedList<String> list = getList();
	    ModelAndView mv = new ModelAndView("teacherGroup");
	    mv.addObject("lists", list);
	
	    return mv;
	}
	
	
	private LinkedList<String> getList(){
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
}