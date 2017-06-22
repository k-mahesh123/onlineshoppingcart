package com.niit.Shopingcart.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;






@Controller
public class HomeController
{


	private static Logger log = LoggerFactory.getLogger(HomeController.class);
	
	//it opens first page when application is executed//
	@RequestMapping("/")
  
	public String myHomePage(Model model)
	{
		log.debug("Starting method of home page");
	
		model.addAttribute("msg11",true);
		log.debug("ending method of home page");
		return "Home1";
	}
	@RequestMapping("/*")
	  
	public String errorPage(Model model)
	{
		log.debug("Starting method of error page");
	
		model.addAttribute("msg13",true);
		log.debug("ending method of error page");
		return "Home1";
	}
	
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String checkUserstatus(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		log.debug("Starting method of checkuserstatus");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName(); // get username
		session = request.getSession(true);
		session.setAttribute("loggedInUser", username);
		if(username.equals("null")||username.equals("anonymousUser"))
		{
			log.debug("Ending method of checkuserstatus");
			return "login1";
		}
		else
		
			log.debug("Starting method of checkuserstatus as admin");
		
		if (request.isUserInRole("ROLE_ADMIN")) {
			Authentication auth1 = SecurityContextHolder.getContext().getAuthentication();
			String str = auth1.getName(); // get username
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);
		    
			
			log.debug("Ending method of checkuserstatus as admin");
			return "Home1";
		}
		
		else  
		{
			log.debug("Starting method of checkuserstatus as user");
			Authentication auth2 = SecurityContextHolder.getContext().getAuthentication();
			String str = auth2.getName();
			session = request.getSession(true);
			session.setAttribute("loggedInUser", str);
			
			log.debug("Endding method of checkuserstatus as user");
			return "Home1";
		}
		}
	
	@RequestMapping("/contact")
	public String contact(Model model) {
		log.debug("Starting method of contact");
		model.addAttribute("msg6","true");
		model.addAttribute("msg11","true");
		log.debug("Ending method of contact");
		return "Home1";
	}
	@RequestMapping("/userhome")
	public ModelAndView userhome() {
		log.debug("Starting method of userhome");
		
		return new ModelAndView("Home1");
	}
	
	@RequestMapping(value = "/fail2login", method = RequestMethod.GET)
	public ModelAndView loginerror() {
		log.debug("Starting method of error page");
		return new ModelAndView("login1", "error", true);
	}
	@RequestMapping(value = "/logoutsuccess", method = RequestMethod.GET)
	public String logout(Model model) {
		log.debug("Starting method of logout");
		model.addAttribute("msg","true");
		log.debug("Starting method of logout");
		return "Home1";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		log.debug("Starting method of home");
		model.addAttribute("msg11",true);
		log.debug("Starting method of home");
		return new ModelAndView("Home1");
	}
	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public ModelAndView adminhome() {
		log.debug("Starting method of adminhome");
		return new ModelAndView("Home1");
	}
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {
		
		log.debug("Starting of the method accessDenied");
		model.addAttribute("errorMessage", "You are not authorized to access this page");
		log.debug("Ending of the method accessDenied");
		return "error";

	}


}
