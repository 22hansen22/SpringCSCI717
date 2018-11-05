package com.jcg.spring.hibernate.ctrl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jcg.spring.hibernate.pojo.ExitTicketEntry;
import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.service.AuthService;
import com.jcg.spring.hibernate.service.ExitTicketService;

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
	
	@Autowired
	private ExitTicketService exitTicketService;	

	@RequestMapping(value = "/studentTimer")
	public String goToSCT1(HttpSession session) {
		log.info("go to studentTimer");
		log.info("session "+session.getId());
	    return "studentTimer";
	}
	
	@RequestMapping(value = "/exitTicketS")
	public ModelAndView goToSCT2(HttpSession session) {
		log.info("entro en Exit Ticket Student");
		log.info("session "+session.getId());
		List<ExitTicketEntry> etList = getList();
		ModelAndView mv=new ModelAndView();
		mv.setViewName("exitTicketS");
    	mv.addObject("etList", etList);
	    return mv;
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
			//ModelAndView mv=new ModelAndView();
			//mv.setViewName("errorPage");
			//return mv;
			return new ModelAndView("redirect:/");
			//could use a redirect to login
		}
		//if all the info is in the cookie
		
		
		ModelAndView mv=new ModelAndView();
		User u=authenticateService.findUser2(session.getAttribute("username").toString(), session.getAttribute("password").toString());
		
		mv.addObject("output", "Welcome "+ u.getUser_name());
		mv.addObject("type", u.getUser_type());
		mv.addObject("userRealName", u.getUser_realname());
		
		if(u.getUser_type().equals("student"))
			mv.setViewName("resultStudent");
		else
			mv.setViewName("resultTeacher");
	    return mv;
	    //return "resultStudent";
	}
	
	//logout
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    return "redirect:/";
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
}