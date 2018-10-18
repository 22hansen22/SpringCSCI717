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
public class controller2{

	@Autowired
	private AuthService authenticateService;	
	private static Logger log = Logger.getLogger(controller2.class);

	@RequestMapping(value = "/studentTimer")
	public String goToSCT1(HttpSession session) {
		log.info("entro en student Timer2");
		log.info("session "+session.getId());
		//return	new ModelAndView("studentTimer");
	    return "studentTimer";
	}
	
	@RequestMapping(value = "/teacherGroup")
	public String goToSCT2(HttpSession session) {
		log.info("entro en teacherGroup");
		log.info("session "+session.getId());
		//return	new ModelAndView("studentTimer");
	    return "teacherGroup";
	}
	
	
	// HOME redirection
	@RequestMapping(value = "/resultStudent")
	public ModelAndView goToSCT3(HttpSession session) {
		try {
			log.info("entro en student Timer2x");
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
		mv.setViewName("resultStudent");
	    return mv;
	    //return "resultStudent";
	}
}