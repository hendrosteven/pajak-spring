package com.brainmatic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brainmatic.model.Movie;

public interface MovieRepo extends CrudRepository<Movie, Long> {
	
	public List<Movie> findByTitleContaining(String title);
	
	public List<Movie> findByGenreId(Long id);
	
	public Movie findByCode(String code);
}
