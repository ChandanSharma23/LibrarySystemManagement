package com.libs.sys.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.libs.sys.Entity.Book;



@Service
public interface BookService {

	public void addBook(Book book);

	public List<Book> getAllBook();

	public void deleteBook(int id);


	public Book updateBook(Book book);


	public List<Book> searchBook(String query);

	public Book getBook(String name, String author, String publisher)throws RuntimeException;


	public void increaseCount(int bookID);

	public void returnBook(int id);

	
}
