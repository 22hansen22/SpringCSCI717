package com.jcg.spring.hibernate.ctrl;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.service.AuthService;

@Controller
@RequestMapping("/user")
public class LoginCtrl {

	@Autowired
	private AuthService authenticateService;			// This will auto-inject the authentication service into the controller.

	private static Logger log = Logger.getLogger(LoginCtrl.class);

	// Checks if the user credentials are valid or not.
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateUsr(@RequestParam("username")String username,@RequestParam("password")String password, HttpSession session) {
		String msg = "";
		String type="";
		boolean isValid = authenticateService.findUser(username, password);
		log.info("Is user valid?= " + isValid);

		ModelAndView mv=new ModelAndView();
		User u=null;
		if(isValid) {
			msg = "Welcome " + username + "!";
			u=authenticateService.findUser2(username, password);
			type=u.getType();
		} else {
			msg = "Invalid credentials";
			type="none";
		}
		
		log.info("What type of user?= " + type);
		//return new ModelAndView("result", "output", msg);	//output is the attribute
		
		
		if(type.equals("student"))
			mv.setViewName("resultStudent");
		else if (type.equals("teacher"))
			mv.setViewName("resultTeacher");
		else
			//default to old result
			mv.setViewName("result");
		
		mv.addObject("output", msg);
		mv.addObject("type", type);
		mv.addObject("userRealName", u.getUserRealName());
		
		//session Attributes
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		log.info("sessionID="+session.getId());
		
		return mv;
	}
}