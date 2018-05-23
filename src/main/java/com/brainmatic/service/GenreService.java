package com.brainmatic.service;

import java.util.Iterator;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmatic.model.Genre;
import com.brainmatic.repository.GenreRepo;

@Service("genreService")
@Transactional
public class GenreService {
	
	@Autowired
	private GenreRepo repo;	
	
	public Genre save(Genre genre) {
		return repo.save(genre);
	}
	
	public Genre findGenreById(long id) {
		return repo.findOne(id);
	}
	
	public Iterable<Genre> findAll(){
		return repo.findAllByOrderByNameAsc();
	}
	
}
