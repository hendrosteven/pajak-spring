package com.brainmatic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmatic.model.Movie;
import com.brainmatic.service.MovieService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private MovieService movieService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		Iterable<Movie> movies = movieService.findAll();
		model.addAttribute("listMovie", movies); 
		return "index";
	}
}
