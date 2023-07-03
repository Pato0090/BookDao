package it.betacom.dao;

import java.util.List;

import it.betacom.model.Book;

public interface BookDao {
	
	List<Book> getAllBooks();
	Book getBookById(String id);
	void insertBook(Book book);
	void deleteBook(Book book);
	void updateBook(Book book);

}
