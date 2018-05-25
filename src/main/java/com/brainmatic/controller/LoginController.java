package com.brainmatic.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmatic.dto.ErrorMessage;
import com.brainmatic.dto.LoginForm;
import com.brainmatic.model.User;
import com.brainmatic.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String prosesLogin(LoginForm loginForm, Model model) {
		User user = userService.login(loginForm.getEmail(), 
				loginForm.getPassword());
		if (user != null) {
			session.setAttribute("CURRENT_USER", user);
			return "redirect:/";
		} else {
			// error message
			ErrorMessage msg = new ErrorMessage();
			msg.getMessages().add("Invalid email or Password");
			session.setAttribute("ERROR", msg);
			model.addAttribute("loginForm", new LoginForm());
			return "redirect:/login";
		}
	}

}
