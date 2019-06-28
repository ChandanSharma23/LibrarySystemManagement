package com.libs.sys.Service;

import java.util.List;

import com.libs.sys.Dao.RecordDao;
import com.libs.sys.Entity.Record;
import com.libs.sys.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.libs.sys.Entity.Book;
import com.libs.sys.Dao.BookDao;


@Service
public class BookServiceImpl implements BookService {
	
	
	@Autowired
	@Qualifier("bookDaoImpl")
	BookDao bookdao;

    @Autowired
    @Qualifier("recordDaoImpl")
    RecordDao recordDao;

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
	public List<Book> searchBook(String query, User user) {
		// TODO Auto-generated method stub
        List<Integer> booksOwned = recordDao.getRecordsByUserId(user.getId());

            return bookdao.searchBook(query,booksOwned);

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
	public void returnBook(int id) {
	Book	book = bookdao.getBookById(id);
	int	count = book.getCopiesIssued() -1;
	book.setCopiesIssued(count);
		bookdao.updateBook(book);

	}
	

}
