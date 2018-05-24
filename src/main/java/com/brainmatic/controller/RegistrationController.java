package com.brainmatic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmatic.dto.ErrorMessage;
import com.brainmatic.dto.RegistrationForm;
import com.brainmatic.model.User;
import com.brainmatic.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	@RequestMapping(method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("regForm", new RegistrationForm());
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String onRegister(RegistrationForm regForm, Model model) {
		User user = new User();
		user.setEmail(regForm.getEmail());
		user.setPassword(regForm.getPassword());
		user.setFullName(regForm.getFullName());
		
		User newUser = userService.register(user);
		
		if(newUser!=null) {	
			return "redirect:/";
		}else {
			//add messages
			ErrorMessage msg = new ErrorMessage();
			msg.setMessage("Email already registered");
			session.setAttribute("ERROR", msg);
			return "redirect:/register";
		}
	}
	
}
