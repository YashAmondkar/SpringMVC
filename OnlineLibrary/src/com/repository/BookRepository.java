package com.repository;

import java.util.List;

import com.bean.Book;

public interface BookRepository {

	public abstract void addBookDetails(Book book) throws Exception;
	public abstract void editBookDetails(Book book) throws Exception;
	public abstract List<Book> getAllBooks() throws Exception;
	public abstract Book modifyBookDetails(String isbn) throws Exception;
	public abstract void deleteBookDetails(String isbn) throws Exception;

}