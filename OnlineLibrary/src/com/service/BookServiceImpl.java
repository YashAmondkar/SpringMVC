package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Book;
import com.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	/* (non-Javadoc)
	 * @see com.service.BookService#addBookDetails(com.bean.Book)
	 */
	@Override
	public void addBookDetails(Book book) throws Exception {
		bookRepository.addBookDetails(book);
	}
	
	@Override
	public void editBookDetails(Book book) throws Exception {
		bookRepository.editBookDetails(book);
	}
	
	@Override
	public List<Book> getAllBooks() throws Exception {
		return (bookRepository.getAllBooks());
	}

	@Override
	public Book modifyBookDetails(String isbn) throws Exception {
		return bookRepository.modifyBookDetails(isbn);
	}

	@Override
	public void deleteBookDetails(String isbn) throws Exception {
		bookRepository.deleteBookDetails(isbn);		
	}
	
}
