package com.turingjavaee7.demo.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@NotBlank(message = "{required.book.title}")
	String id;
	
	@NotBlank(message = "title is required")
	@Size(min = 3, max = 100, message="Title must be between 3 and 100 characters")
	String title;
	
	@NotBlank(message = "author is mandatory")
	String author;
}
