package com.libs.sys.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.libs.sys.Entity.Book;
import com.libs.sys.Service.BookService;

@Controller
public class BorrowController {
	
	@Autowired
	@Qualifier("bookServiceImpl")
	BookService bookService;
	
	
	@RequestMapping(value="/searchbooks")
	@ResponseBody
	public List<Book> searchBook(@RequestParam String query) throws IOException {
		System.out.println(query);
		return bookService.searchBook(query);
		
	}

}
