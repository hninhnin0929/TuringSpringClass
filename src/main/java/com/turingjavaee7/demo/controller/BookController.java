package com.turingjavaee7.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("cart")
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;
	
	@ModelAttribute
	void addEmptyBook(Model model) {
		log.info("Add Empty Book");
		List<String> category = new ArrayList<String>();
		category.add("Sci Fi");
		category.add("Art");
		category.add("Fiction");
		model.addAttribute("category", category);
	}
	
	@ModelAttribute
	void cartItem(Model model) 
	{
		
		List<String> cart = new ArrayList<String>();
		model.addAttribute("", cart);
	}
	
	@GetMapping("/new")
	String bookForm(Model model) {
		
		Book book = new Book();
		model.addAttribute("book", book);
		return "/books/newBook";
	}
	
	@PostMapping("/new")
	String createBook(@ModelAttribute Book book, BindingResult result) {
		
		log.info("Create book " + book);
		return "/books/newBook";
	}
	
	@GetMapping
	String getAllBook(Model model) {
		
		List<Book> books = this.bookService.getAllBook();
		model.addAttribute("books", books);
		return "books/book";
	}
	
	@GetMapping("/{id}")
	String getBookById(Model model, 
			@PathVariable String id, 
			@ModelAttribute("category") List<String> category) {
		
//		List<Book> modelBooks = (ArrayList<Book>)model.getAttribute("books");
		log.info("Get book by Id size", category.size());
		Book book = this.bookService.getBookById(id);
		
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		
		model.addAttribute("books", books);
		return "books/book";
	}
	
	@GetMapping("/cart")
	String cardForm(Model model) 
	{
		log.info("Cart form");
		List<String> cart = new ArrayList<String>();
		model.addAttribute("cart", cart);
		
		return "/books/cart";
	}
	
	@PostMapping("/cart")
	String cartFormSubmit(Model model, 
			@ModelAttribute("cart") ArrayList<String> cart,
			@RequestParam String bookId) {
		
		log.info("Cart form submit bookId "+bookId);
		cart.add(bookId);
//		List<String> cart = new ArrayList<String>();
//		model.addAttribute("cart", cart);
		log.info("Cart Item " + cart.size());
		return "/books/cart";
	}
}


