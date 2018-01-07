package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Book;
import com.service.BookService;

@Controller
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/admin/addbook")
	public String bookInsertion(Model model){
		model.addAttribute("book",new Book());
		return "AddBook";
	}
		
	@RequestMapping("/admin/insert")
	public String addBookDetails(@Valid @ModelAttribute("book") Book book,BindingResult result) throws Exception{
		
		if(result.hasErrors()) {
			return "AddBook";
		}
		
		try {			
			bookService.addBookDetails(book);
			return "redirect:allbooks";
		} catch (Exception e) {
			e.printStackTrace();
			return "AddBook";
		}				
	}
	
	@RequestMapping("/admin/saveedit")
    public String editBookDetails(@Valid @ModelAttribute("book") Book book,BindingResult result) throws Exception{
		
		if(result.hasErrors()) {
			return "redirect:allbooks";
		}
		
		try {			
			bookService.editBookDetails(book);
			return "redirect:allbooks";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:allbooks";
		}				
	}
		
	@RequestMapping("/admin/allbooks")
	public String fetchAllBooks(Model model) {
		
		List<Book> listOfBooks;
		
		try {
			listOfBooks = bookService.getAllBooks();
			model.addAttribute("listBook", listOfBooks);
			return "Books";
		} catch (Exception e) {
			e.printStackTrace();
			return "adminLibraryHome";
		}
		
	}
	
	@RequestMapping("/user/books")
	public String AllBooks() throws Exception {		
		return "redirect:viewbooks";
	}
	
	@RequestMapping("/user/viewbooks")
	public String viewAllBooks(Model model) {		
        List<Book> listOfBooks;
		
		try {
			listOfBooks = bookService.getAllBooks();
			model.addAttribute("listBook", listOfBooks);
			return "ViewBooks";
		} catch (Exception e) {
			e.printStackTrace();
			return "Home";
		}		
	}
	
	@RequestMapping("/admin/editbook")
	public String modifyBookDetails(@RequestParam("isbn") String isbn,Model model) {	
		Book book;
		try {
			book = bookService.modifyBookDetails(isbn);
			model.addAttribute(book);
			return "EditBook";
		} catch (Exception e) {			
			e.printStackTrace();
			return "redirect:allbooks";
		}		
	}

	@RequestMapping("/admin/deletebook")
	public String deleteBookDetails(@RequestParam("isbn") String isbn) {
		try {
			bookService.deleteBookDetails(isbn);
			return "redirect:allbooks";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:allbooks";
		}
	}

}
