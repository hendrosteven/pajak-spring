package com.brainmatic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmatic.model.Movie;
import com.brainmatic.repository.MovieRepo;

@Service("movieService")
@Transactional
public class MovieService {

	@Autowired
	private MovieRepo repo;
	
	public Movie save(Movie movie) {
		return repo.save(movie);
	}
	
	public Movie findById(long id) {
		return repo.findOne(id);
	}
	
	public Movie findByCode(String code) {
		return repo.findByCode(code);
	}
	
	public Iterable<Movie> findAll(){
		return repo.findAll();
	}
	
	public List<Movie> findByGenreId(long id){
		return repo.findByGenreId(id);
	}
	
	
	public List<Movie> findByTitle(String title){
		return repo.findByTitleContaining(title);
	}
}
