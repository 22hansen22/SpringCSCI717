package com.jcg.spring.hibernate.ctrl;

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

	private static Logger log = Logger.getLogger(controller2.class);

	
	@RequestMapping(value = "/studentTimer")
	public String goToSCT1() {
		log.info("entro en student Timer2");
		//return	new ModelAndView("studentTimer");
	    return "studentTimer";
	}
	
	@RequestMapping(value = "/resultStudent")
	public String goToSCT2() {
		log.info("entro en student Timer2x");
		//return	new ModelAndView("studentTimer");
	    return "resultStudent";
	}
}