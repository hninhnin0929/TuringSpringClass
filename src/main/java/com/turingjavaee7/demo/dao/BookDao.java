package com.turingjavaee7.demo.dao;

import java.util.List;

import com.turingjavaee7.demo.model.Book;

public interface BookDao {

	List<Book> getAllBooks();
	Book getBookById(String id);
	void saveBook(Book book);
	void updateBook(Book book);
	void deleteBookById(String id);
}
