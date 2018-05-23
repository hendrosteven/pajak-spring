package com.brainmatic.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.brainmatic.model.Genre;

public interface GenreRepo extends CrudRepository<Genre, Long>{

	public List<Genre> findAllByOrderByNameAsc();
	
	public List<Genre> findAllByOrderByIdAsc();
}
