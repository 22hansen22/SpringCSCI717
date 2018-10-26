package com.jcg.spring.hibernate.ctrl;

import javax.servlet.http.HttpSession;
import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.service.AuthService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class GeneralController{

	@Autowired
	private AuthService authenticateService;	
	private static Logger log = Logger.getLogger(GeneralController.class);

	@RequestMapping(value = "/studentTimer")
	public String goToSCT1(HttpSession session) {
		log.info("go to studentTimer");
		log.info("session "+session.getId());
	    return "studentTimer";
	}
	
	@RequestMapping(value = "/exitTicketS")
	public String goToSCT2(HttpSession session) {
		log.info("entro en Exit Ticket Student");
		log.info("session "+session.getId());
	    return "exitTicketS";
	}
	
	@RequestMapping(value = "/exitTicketT")
	public String goToSCT3(HttpSession session) {
		log.info("entro en Exit Ticket Teacher");
		log.info("session "+session.getId());
		//return	new ModelAndView("studentTimer");
	    return "exitTicketT";
	}	
	
	// HOME redirection
	@RequestMapping(value = { "/resultStudent", "/resultTeacher"})
	public ModelAndView goToSCTX(HttpSession session) {
		try {
			log.info("entro en HOME redirection");
			//return	new ModelAndView("studentTimer");
			log.info("s1 "+session.getAttribute("username").toString());
			log.info("s2 "+session.getAttribute("password").toString());
		}
		catch(Exception e) {
			ModelAndView mv=new ModelAndView();
			mv.setViewName("errorPage");
			return mv;
		}
		//if all the info is in the cookie
		
		
		ModelAndView mv=new ModelAndView();
		User u=authenticateService.findUser2(session.getAttribute("username").toString(), session.getAttribute("password").toString());
		
		mv.addObject("output", "Welcome "+ u.getName());
		mv.addObject("type", u.getType());
		mv.addObject("userRealName", u.getUserRealName());
		
		if(u.getType()=="student")
			mv.setViewName("resultStudent");
		else
			mv.setViewName("resultTeacher");
	    return mv;
	    //return "resultStudent";
	}
}