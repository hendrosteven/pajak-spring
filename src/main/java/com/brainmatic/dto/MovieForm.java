package com.brainmatic.dto;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.brainmatic.model.Genre;

public class MovieForm {
	
	@NotEmpty(message = "Code is required")
	@Pattern(regexp = "MV[0-9]+",message = "Code must be start with MV")
	private String code;
	
	@NotEmpty(message = "Title is required")
	private String title;
	
	@NotEmpty(message = "Image is required")
	private String image;
	
	@NotEmpty(message = "Sinopsis is required")
	private String sinopsis;
	
	private Genre genre;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSinopsis() {
		return sinopsis;
	}
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
	
}
