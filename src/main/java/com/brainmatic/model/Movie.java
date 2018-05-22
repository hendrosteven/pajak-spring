package com.brainmatic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 5, unique = true, nullable = false)
	private String code;

	@Column(length = 200, nullable = false)
	private String title;

	@Column(length = 1000)
	private String sinopsis;
	
	@Column(length=255)
	private String image;
	
	@ManyToOne
	private Genre genre;
}
