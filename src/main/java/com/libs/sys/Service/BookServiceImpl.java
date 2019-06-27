package com.libs.sys.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.libs.sys.Entity.Book;
import com.libs.sys.Dao.BookDao;
import com.libs.sys.Service.BookService;



@Service
public class BookServiceImpl implements BookService {
	
	
	@Autowired
	@Qualifier("bookDaoImpl")
	BookDao bookdao;

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookdao.addBook(book);

	}


	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		return bookdao.getAllBooks();
	}

	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		bookdao.deleteBook(id);
	}

	

	public Book updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookdao.updateBook(book);
	}


	@Override
	public List<Book> searchBook(String query) {
		// TODO Auto-generated method stub
		return bookdao.searchBook(query);
	}

	@Override
	public Book getBook(String name, String author, String publisher) throws RuntimeException {
		// TODO Auto-generated method stub
		if(bookdao.getBook(name,author,publisher)!=null) {
			throw new RuntimeException("book already exists");
		}
		return null;
	}


	@Override
	public void increaseCount(int bookID) {
		// TODO Auto-generated method stub
		
		bookdao.increaseCount(bookID);
	}

}
