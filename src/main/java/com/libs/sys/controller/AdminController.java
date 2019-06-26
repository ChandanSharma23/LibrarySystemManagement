package com.libs.sys.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.libs.sys.Entity.Book;
import com.libs.sys.Service.BookService;

@Controller

public class AdminController {
	
	@Autowired
	@Qualifier("bookServiceImpl")
	BookService bookService;

	@RequestMapping(value="/books")
	@ResponseBody
	public List<Book> listBook() throws IOException {
		return bookService.getAllBook();
		
	}
	
	@RequestMapping(value = "/updateBooks", method = RequestMethod.POST)
	@ResponseBody
	public Boolean newContact(@RequestBody Book book, @RequestParam Boolean isNewBook){
     if ( isNewBook ==true)
     { 
    		 
				bookService.getBook(book.getName(), book.getAuthor(), book.getPublisher());
				bookService.addBook(book);
			
    	 	
     }else {
    	 bookService.updateBook(book);
     }
    	 
	
	return true;
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	@ResponseBody
	public void newContact1(@RequestParam Integer id) {
		System.out.print(id);
		bookService.deleteBook(id);
	}

}
