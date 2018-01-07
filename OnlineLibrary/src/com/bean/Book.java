package com.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Book {
	
	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String title;
	
	@NotNull
	private Integer isbn;
	
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String languages;

	@NotEmpty
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String publisher;
	
	@Pattern(regexp="^[a-zA-Z0-9\\s]+$")
	private String authorName;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getIsbn() {
		return isbn;
	}
	
	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}
	
	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}		
}
