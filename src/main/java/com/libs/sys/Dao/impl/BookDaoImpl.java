package com.libs.sys.Dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.libs.sys.Entity.Book;
import com.libs.sys.HibernateUtil.HibernateUtil;

import com.libs.sys.Dao.BookDao;

@Repository
public class BookDaoImpl implements BookDao {

	
	public void addBook(Book book) {

		// create session
		Session session = HibernateUtil.getSF().openSession();
		
		try {			
			// create a student object
			System.out.println("Creating new book object.."  );
		
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the book...");
			session.save(book);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(Exception ex) {
			System.out.println(ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}


		

	}

	
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSF().openSession();
		
		System.out.println("All the Books...");
	
		
		List<Book> list = null;
		try {
			session.beginTransaction();
		list = session.createQuery("from Book", Book.class).list();
		System.out.println(list.size());
		
		session.getTransaction().commit();
	}
		catch(Exception ex) {
			System.out.println(ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
		return list;
	
	}

	public Book updateBook(Book book) {
		Session session = HibernateUtil.getSF().openSession();
		try {
			session.beginTransaction();
			System.out.println("Updating  the book...");
			
			session.update(book);
			
			
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			System.out.println(ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
		return book;	}

	
	public void deleteBook(int id) {
		// TODO Auto-generated method stub
		 Session session = HibernateUtil.getSF().openSession();
		 
		 try {
			 
				session.beginTransaction();
				System.out.println("deleting the Book...");
			 
		Book book = (Book) session.load(Book.class,id);
		 if(null!= book)
		 {
		 session.delete(book);
		 }
		 
		 session.getTransaction().commit();
		 
		}
		 catch(Exception ex) {
			 System.out.println(ex);
				session.getTransaction().rollback();
				
			}
			finally {
				session.close();
			}
	 
	 

	}

	
		



	@Override
	public List<Book> searchBook(String query) {
		Session session = HibernateUtil.getSF().openSession();
		System.out.println("Searching the book...");
	
		
		List<Book> list = null;
		try {
			session.beginTransaction();
			/*
			 * list= session.createCriteria(Book.class ).add(Restrictions.like("Name",
			 * "%"+query+"%")) .list();
			 */
			Query<Book> q = session.createQuery("from Book where name like :n");
			q.setString("n", '%'+query+'%');
			
			
			list= q.getResultList();
			
		System.out.println(" book..." + list.size());
		session.getTransaction().commit();
	}
		catch(Exception ex) {
			System.out.println(ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		return list;
	
	}


	@Override
	public Book getBook(String name, String author, String publisher) {
		Session session = HibernateUtil.getSF().openSession();
		Book b = null;
		try {
			session.beginTransaction();
			System.out.println("Getting  the book...");
		
		Query q = session.createQuery("from Book where name=:n and author=:a and publisher=:p");
			q.setString("n", name);
			q.setString("a", author);
			q.setString("p", publisher);
			
			b= (Book)q.getSingleResult();
			
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			System.out.println(ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		
		return b;
	}




	@Override
	public void increaseCount(int bookID) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSF().openSession();
		Book b = null;
		try {
			session.beginTransaction();
			System.out.println("Getting  the book...");
		
		Query q = session.createQuery("from Book where id=:n");
			q.setInteger("n", bookID);
		
			b= (Book)q.getSingleResult();
			
			b.setCopiesIssued(b.getCopiesIssued()+1);
			session.update(b);
			
			session.getTransaction().commit();
		}
		catch(Exception ex) {
			System.out.println(ex);
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		

		
	}


	@Override
	public Book getBookById(int bookID) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
