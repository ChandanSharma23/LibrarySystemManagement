package com.libs.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libs.sys.Entity.User;
import com.libs.sys.Model.UserBookDetails;
import com.libs.sys.Service.BookService;
import com.libs.sys.Service.RecordService;
import com.libs.sys.Service.UserService;

@Controller
public class HomeController {

	@Autowired
	@Qualifier("userServiceimpl")
	UserService userService;
	
	@Autowired
	@Qualifier("bookServiceImpl")
	BookService bookService;
	
	@Autowired
	@Qualifier("recordServiceImpl")
	RecordService recordService;
	
	public static User userLoggedIn = null;

	@RequestMapping(value="/")
	public String getHomePage(Model model) {
		model.addAttribute("user",new User());
    return "login";
	}
	@RequestMapping(value="/save")
	public String getHomePage4(@ModelAttribute("user") User user, Model model) {
	    User u= userService.getUserbyRoll(user.getRoll());
	    if(u== null)
	     {userService.createUser(user);
	     model.addAttribute("user",new User());   
	     }else {
	    	
	         model.addAttribute("message", "This roll number already exists"); 
	     }
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
	
	
	@RequestMapping(value="/return")
	public String getHomePage3() {
    return "return";
	}
	
	@RequestMapping(value="/userDetails")
	@ResponseBody
	public User getUserDetails() {
		User user =userLoggedIn;
		return user;
	}
	
	@RequestMapping(value="/userBookDetails")
	@ResponseBody
	public List<UserBookDetails>  getUserBookDetails() {
		System.out.println("yaaayyyyyyyyyy");
		int i =userLoggedIn.getId();
		return recordService.getUserDetails(i);
	}
	
	@RequestMapping(value = "/returnbook", method = RequestMethod.POST)
	@ResponseBody
	public void newContact1(@RequestParam Integer bid, @RequestParam Integer buid) {
		recordService.deleteRecord(buid);
		bookService.returnBook(bid);
	}
}