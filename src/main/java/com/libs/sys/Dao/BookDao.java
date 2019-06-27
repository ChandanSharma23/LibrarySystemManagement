package com.libs.sys.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.libs.sys.Entity.Book;


@Repository
public interface BookDao {
	public void addBook(Book book);
	public List<Book> getAllBooks();
	public Book updateBook(Book book );
	public void deleteBook(int id);

	public List<Book> searchBook(String query, List<Integer> booksOwned);
	public Book getBook(String name, String author, String publisher);
	public void increaseCount(int bookID);
	public Book getBookById(int id);


}
