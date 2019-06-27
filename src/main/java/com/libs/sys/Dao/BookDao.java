package com.libs.sys.Dao;

import java.util.List;

import com.libs.sys.Entity.Book;



public interface BookDao {
	public void addBook(Book book);
	public List<Book> getAllBooks();
	public Book updateBook(Book book );
	public void deleteBook(int id);

	public List<Book> searchBook(String query);
	public Book getBook(String name, String author, String publisher);
	public Book getBookById(int id);

}
