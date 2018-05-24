package com.brainmatic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmatic.dto.GenreForm;
import com.brainmatic.model.Genre;
import com.brainmatic.service.GenreService;

@Controller
@RequestMapping("/input/genre")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(method = RequestMethod.GET)
	public String inputGenre(Model model) {
		if(session.getAttribute("CURRENT_USER")!=null) {
			model.addAttribute("genreForm", new GenreForm());
			return "inputgenre";
		}else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveGenre(GenreForm genreForm, Model model) {
		Genre genre = new Genre();
		genre.setName(genreForm.getGenreName());
		genreService.save(genre);
		return "redirect:/";
	}
}
