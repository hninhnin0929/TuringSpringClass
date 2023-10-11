package com.turingjavaee7.demo.service;

import java.util.List;

import com.turingjavaee7.demo.model.Book;

import lombok.Data;

public interface BookService {

	List<Book> getAllBook();
	Book getBookById(String id);
}
