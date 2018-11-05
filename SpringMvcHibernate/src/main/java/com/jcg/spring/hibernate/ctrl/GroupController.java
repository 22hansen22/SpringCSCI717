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

import com.jcg.spring.hibernate.pojo.User;
import com.jcg.spring.hibernate.service.AuthService;

@Controller
@RequestMapping("/user")
public class GroupController {
	
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
	
	@RequestMapping(value={"/teacherGroup"},params = "group", method = RequestMethod.GET)
	public ModelAndView listStudents2(@RequestParam("groupSize")String groupSize){    
		log.info("entro en group Students ");
	    LinkedList<String> list = getList();
	    ModelAndView mv = new ModelAndView("teacherGroup");
	    mv.addObject("lists", list);
	    
	    LinkedList<String> listc=(LinkedList)list.clone();
	    Collections.shuffle(listc);
	    LinkedList<LinkedList<String>> slist = new LinkedList<LinkedList<String>>();
	    //int groupSize=3;
	    int groupSizex=Integer.parseInt(groupSize);
	    int numGroups=listc.size()/groupSizex;
	    if (listc.size() % groupSizex >0) numGroups+=1;
	    for (int i=0; i<numGroups;i++) {
	    	slist.add(new LinkedList<String>());
	    }
	    int counter1=0;
	    for (int i=0; i<listc.size();i++) {
	    	slist.get(counter1).add(listc.get(i));
	    	if(((i+1) % groupSizex)==0)	counter1+=1;
	    }
	    mv.addObject("slists", slist);
	    String gmsg="Making groups of "+groupSizex +" people";
	    mv.addObject("gmsg", gmsg);

	
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
		    	list.add(listU.get(i).getUser_realname());
		    }
		    return list;
	    }catch(Exception e) {
		    log.error("Listing unsuccesful");
	    	return null;
	    	
	    }
	}
}