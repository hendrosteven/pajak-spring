package com.brainmatic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmatic.service.GenreService;
import com.brainmatic.service.MovieService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private MovieService movieService;
	@Autowired
	private GenreService genreService;

	@RequestMapping(method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("listMovie", movieService.findAll()); 
		model.addAttribute("listGenre", genreService.findAll());
		return "index";
	}
	
	@RequestMapping(value="/genre/{id}")
	public String findByGereId(@PathVariable("id") long id, Model model) {
		model.addAttribute("listMovie", movieService.findByGenreId(id)); 
		model.addAttribute("listGenre", genreService.findAll());
		return "index";
	}
}
