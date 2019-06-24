package com.libs.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.libs.sys.Entity.User;
import com.libs.sys.Service.UserService;
import java.util.Date;


@Controller
public class HomeController {

	@Autowired
	@Qualifier("userServiceimpl")
	UserService userService;
	
	public static User userLoggedIn = null;

	@RequestMapping(value="/")
	public String getHomePage(Model model) {
		model.addAttribute("user",new User());
    return "login";
	}
	@RequestMapping(value="/save")
	public String getHomePage4(@ModelAttribute("user") User user) {
		userService.createUser(user);
	    return "login";
	}
	

	@RequestMapping(value="/dashBoard")
	public String getHomePage1(@ModelAttribute("user") User user, Model model) {
		if(userLoggedIn == null) {
				userLoggedIn = userService.login(user.getRoll(), user.getPassword());
			if(userLoggedIn!= null) {
				model.addAttribute("user", userLoggedIn);
				 return "dashboard";
			}else {
				model.addAttribute("message", "login Failed");
				model.addAttribute("user", new User());
				return "login";
			}
	   
		}else {
			model.addAttribute("user",userLoggedIn);
			return "dashboard";
		}
	}
	@RequestMapping(value="/logout")
	public String getHomePage5(Model model) {
		userLoggedIn = null;
		model.addAttribute("user", new User());
	    return "login";
	}
	
	@RequestMapping(value="/borrow")
	public String getHomePage2() {
    return "borrow";
	}
	@RequestMapping(value="/return")
	public String getHomePage3() {
    return "return";
	}
}
