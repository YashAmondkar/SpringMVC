package com.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Book;


@Repository
public class BookRepositoryImpl implements BookRepository {

	@Autowired
	JdbcTemplate jdbcTemplate; 
	
	
	private final class BooksRowMapper implements RowMapper<Book>{

		@Override
		public Book mapRow(ResultSet rs, int index) throws SQLException {
			Book book = new Book();

			book.setTitle(rs.getString("title"));
			book.setIsbn(rs.getInt("isbn"));
			book.setLanguages(rs.getString("languages"));
			book.setPublisher(rs.getString("publisher"));
			book.setAuthorName(rs.getString("authorName"));
			
			return book;

		}
	}

	
	/* (non-Javadoc)
	 * @see com.repository.BookRepository#addBookDetails(com.bean.Book)
	 */
	@Override
	public void addBookDetails(Book book) throws Exception {
		String queryInsert = "insert into BookDetails(title,isbn,languages,publisher,authorName) values (?,?,?,?,?)";
		int rowsAffected = jdbcTemplate.update(queryInsert, book.getTitle(),book.getIsbn(),book.getLanguages(),book.getPublisher(),book.getAuthorName());
		
		if(rowsAffected != 1){
			throw new Exception("Insertion Failed for query : " + queryInsert);
		}		
	}
	
	@Override
	public void editBookDetails(Book book) throws Exception {
		String queryUpdate = "update BookDetails set title = ?,languages = ?,publisher = ?,authorName = ? where isbn =?";
				
		int rowsAffected = jdbcTemplate.update(queryUpdate, book.getTitle(),book.getLanguages(),book.getPublisher(),book.getAuthorName(),book.getIsbn());
		
		if(rowsAffected != 1){
			throw new Exception("Updation Failed for query : " + queryUpdate);
		}		
	}
	

	@Override
	public List<Book> getAllBooks() throws Exception{
		
		String querySelectAll = "select * from BookDetails";
		
		List<Book> allBooks = jdbcTemplate.query(querySelectAll, new BooksRowMapper());
		
		return allBooks;
	}


	@Override
	public Book modifyBookDetails(String isbn) throws Exception {

		String querySelect = "select * from BookDetails where isbn=" + isbn;
		List<Book> bookDetail = jdbcTemplate.query(querySelect, new BooksRowMapper());				
		
		if(bookDetail.isEmpty()) {
			return null;
		}else if(bookDetail.size() == 1) {
			return bookDetail.get(0);
		}else {
			throw new IncorrectResultSizeDataAccessException("Incorrect Result size", 1);
		}
				
	}


	@Override
	public void deleteBookDetails(String isbn) throws Exception {		
		
		String queryDelete = "delete from BookDetails where isbn=" + isbn;
		int rowsAffected = jdbcTemplate.update(queryDelete);
		
		if(rowsAffected != 1){
			throw new Exception("Deletion Failed for query : " + queryDelete);
		}		
		
	}
	
}
