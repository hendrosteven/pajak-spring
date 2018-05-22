package com.brainmatic.service;

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
	
	public Iterable<Movie> findAll(){
		return repo.findAll();
	}
}
