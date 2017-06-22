package com.niit.Shopingcart.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.niit.shopinngcart1.dao.SupplierDao;
import com.niit.shopinngcart1.dao.UserDao;
import com.niit.shopinngcart1.dao.UserSignUPDao;
import com.niit.shopinngcart1.model.Editor;
import com.niit.shopinngcart1.model.User;
import com.niit.shopinngcart1.model.UserSignUP;

@Controller
public class UserController {
	@Autowired
	private SupplierDao supplierdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private User usr;
	@Autowired
	private UserSignUPDao usersignupdao;
	
	static int registrationid=30000;
	

	

	// it opens the login page
	@RequestMapping("/login")
	  
	public String myLoginPage(HttpSession session,HttpServletResponse response,HttpServletRequest request)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName();
			session = request.getSession(true);
			session.setAttribute("loggedInUser", username);
			if(username.equals("null")||username.equals("anonymousUser"))
			{
				return "login1";
			}
			else
			{
				return "redirect:/j_spring_security_Logout";
			}
		
	
	}


	//registration page adding feilds of user		
	@RequestMapping("/register")
	  
	public String myRegisterPage(Model model)
	{
		model.addAttribute("msg","true");
		model.addAttribute("usersignup",new UserSignUP());
		return "registration";
	}
	@RequestMapping("/register1")
	  
	public String myRegisterPage2(Model model)
	{
		model.addAttribute("msg2","true");
		model.addAttribute("usersignup",new UserSignUP());
		return "registration";
	}
	@RequestMapping("/register2")
	  
	public String myRegisterPage1(Model model)
	{
		model.addAttribute("usersignup",new UserSignUP());
		model.addAttribute("msg11","true");
		model.addAttribute("success","registerd successfully!");
		return "Home1";
	}


	@InitBinder
	public void initbinder(WebDataBinder binder)
	{
		binder.registerCustomEditor(String.class, "mobilenumber",new Editor() );
		
	}
	@RequestMapping(value="signup",method=RequestMethod.POST)
	public String mySignUp( @ModelAttribute("usersignup") @Valid UserSignUP signup,BindingResult result,Model model)
	{

	if(result.hasErrors())
	{
	
	model.addAttribute("msg","true");
		return "registration";
	}
	List<UserSignUP> list=usersignupdao.getAllUsers();
	for(UserSignUP l:list)
	{
		System.out.println(l.getUsername());
		System.out.println(signup.getUsername());
	
		if(l.getUsername().equals(signup.getUsername()))
		{
			System.out.println("maheshahha");
			model.addAttribute("msg","true");
			model.addAttribute("msg12","user Already exists");
			return "registration";
		}
	}
	
	   signup.setRegistrationid(registrationid++);
		usersignupdao.save(signup);
		System.out.println(signup.getUsername());
		usr.setUsername(signup.getUsername());
		usr.setPassword(signup.getPassword());
		usr.setRole(signup.getRole());
		usr.setStatus(signup.isStatus());
	       
	      userdao.save(usr);
		

		return "redirect:/register2";
	}
	@RequestMapping("/updateuser")
	

	public String updateSup(@Valid @ModelAttribute("usersignup")UserSignUP usersignup,BindingResult result,Model model)
	{
		System.out.println("mahesha");
		if (result.hasErrors()) {
			ModelAndView mv=new ModelAndView("registration");
			model.addAttribute("user",usersignupdao.getSingleuser(usersignup.getUsername()));
			model.addAttribute("msg1","true");
			model.addAttribute("usersignup",new UserSignUP());
			return "registration";
		    
		  }
		usersignup.setRegistrationid(registrationid++);
		System.out.println("mahesh");
		if(usersignup.getUsername().equals("mahesh123")||usersignup.getUsername().equals("mahesh"))
	    {
	    	usersignup.setRole("ROLE_ADMIN");
	    }
	    else
	    {
	    	usersignup.setRole("ROLE_USER");
	    }

		usersignupdao.update(usersignup);
		
		usr.setUsername(usersignup.getUsername());
		usr.setPassword(usersignup.getPassword());
		usr.setRole(usersignup.getRole());
		usr.setStatus(usersignup.isStatus());
	       
	      userdao.update(usr);
	      
	     
		return "redirect:/userhome";
		
	}
	@RequestMapping("/userview")
	public ModelAndView userview()
	{
		
		ModelAndView mv2=new ModelAndView("registration");
		mv2.addObject("usersignup",new UserSignUP());
		mv2.addObject("user",usersignupdao.getAllUsers());
		mv2.addObject("msg2","true");
		return mv2;
		
	}

	
	@RequestMapping("/viewofeachuser")
	public String viewSup(@RequestParam String username) {
	
				
		return "redirect:/eachuserview";
	}
	@RequestMapping("/eachuserview")
	public String viewSup1(HttpSession session,Model model) {
		String username=(String)session.getAttribute("loggedInUser");
	
	       model.addAttribute("usersignup",new UserSignUP());
	       model.addAttribute("user1",usersignupdao.getSingleuser(username));
	       model.addAttribute("msg3","true");
	       
	     return "registration";
	}
	@RequestMapping("/edituser")
	public String editSup(@RequestParam String username) {
	
		return "redirect:/useredit";
	}
	@RequestMapping("/useredit")
	public String viewSup2(HttpSession session,Model model) {
		String username=(String)session.getAttribute("loggedInUser");
	
	       model.addAttribute("usersignup",new UserSignUP());
	       model.addAttribute("user",usersignupdao.getSingleuser(username));
	       model.addAttribute("msg1","true");
	       
	     return "registration";
	}
	@ResponseBody
	@RequestMapping("student")
	public User m()
	{
		User s=new User();
		s.setPassword("MAHESH");
		s.setRole("mmmam");
		
		return s;
	}
	@ResponseBody
	@RequestMapping("student/{name}")
	public User m1(@PathVariable  String name)
	{
		User s=new User();
		s.setPassword("MAHESH");
		s.setRole("mmmam");
		s.setUsername(name);
		
		return s;
	}
	
	
	
}
	


	 
	

