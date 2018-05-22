package com.brainmatic.repository;

import org.springframework.data.repository.CrudRepository;

import com.brainmatic.model.Genre;

public interface GenreRepo extends CrudRepository<Genre, Long>{
	//definisi fungi lain
}
