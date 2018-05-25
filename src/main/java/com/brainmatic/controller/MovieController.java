package com.brainmatic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.brainmatic.dto.ErrorMessage;
import com.brainmatic.dto.MovieForm;
import com.brainmatic.model.Movie;
import com.brainmatic.service.GenreService;
import com.brainmatic.service.MovieService;

@Controller
@RequestMapping("/input/movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private GenreService genreService;

	@Autowired
	private HttpSession session;

	@RequestMapping(method = RequestMethod.GET)
	public String inputMovie(Model model) {
		if (session.getAttribute("CURRENT_USER") != null) {
			model.addAttribute("listGenre", genreService.findAll());
			model.addAttribute("movieForm", new MovieForm());
			return "inputmovie";
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(MovieForm movieForm, Model model) {
		if (movieService.findByCode(movieForm.getCode()) == null) {
			Movie movie = new Movie();
			movie.setCode(movieForm.getCode());
			movie.setTitle(movieForm.getTitle());
			movie.setImage(movieForm.getImage());
			movie.setSinopsis(movieForm.getSinopsis());
			movie.setGenre(genreService.findGenreById(movieForm.getGenre().getId()));
			movieService.save(movie);
			return "redirect:/";
		} else {
			ErrorMessage msg = new ErrorMessage();
			msg.getMessages().add("Code already registered");
			session.setAttribute("ERROR", msg);
			return "redirect:/input/movie";
		}
	}
}
