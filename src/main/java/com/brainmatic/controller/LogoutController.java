package com.brainmatic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	@Autowired
	private HttpSession session;
	
	@RequestMapping(method = RequestMethod.GET)
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
}
