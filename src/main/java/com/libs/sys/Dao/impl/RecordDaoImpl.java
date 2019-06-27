package com.libs.sys.Dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.libs.sys.Dao.RecordDao;
import com.libs.sys.Entity.Book;
import com.libs.sys.Entity.Record;
import com.libs.sys.Entity.User;
import com.libs.sys.HibernateUtil.HibernateUtil;
import com.libs.sys.Model.UserBookDetails;
import com.libs.sys.HibernateUtil.HibernateUtil;

@Repository
public class RecordDaoImpl implements RecordDao {


	@Override
	public Record updateRecord(Record record) {
		// TODO Auto-generated method stub
Session session = HibernateUtil.getSF().openSession();
		
		try {			
			// create a student object
			System.out.println("Creating new book object.."  );
		
			
			// start a transaction
			session.beginTransaction();
			
			session.update(record);
			
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
		return record;
		
	}


	@Override
	public void addRecord(int bookID, int id) {
		// TODO Auto-generated method stub
		
		Record record = new Record();
		record.setBid(bookID);
		record.setUid(id);
	
		System.out.println(record);
		
Session session = HibernateUtil.getSF().openSession();
		
		try {			
			// create a student object
			System.out.println("Creating new record object.."  );
		
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the record...");
			session.save(record);
			
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

	@Override
	public List<UserBookDetails> getBooksTobeReturned() {
		// TODO Auto-generated method stub
		/*
		 * Session session = HibernateUtil.getSF().openSession(); Book b = null; try {
		 * session.beginTransaction(); System.out.println("Getting  the book...");
		 * 
		 * Query q = session.createQuery("from Book where id=:n"); q.setInteger("n",
		 * bookID);
		 * 
		 * b= (Book)q.getSingleResult();
		 * 
		 * b.setCopiesIssued(b.getCopiesIssued()+1); session.update(b);
		 * 
		 * session.getTransaction().commit(); } catch(Exception ex) {
		 * System.out.println(ex); session.getTransaction().rollback(); } finally {
		 * session.close(); }
		 */
		return null;
	}

	@Override
	public List<UserBookDetails> getBooksTobeIssued() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSF().openSession();
		List<Object[]> r = null;
		
		try {
			session.beginTransaction();
			System.out.println("getting the Details for User...");
			 Query q = session.createSQLQuery("select BUID,BID,UID, Date_Of_Issue ,Date_Of_Return ,  Approved ,username ,roll ,Name ,Author ,Publisher,Return_request from record r left join user u on u.id = r.uid left join book b on r.bid = b.bookid where Date_Of_Issue is null");
			 	 r = q.getResultList();
	      	   	session.getTransaction().commit();
		}
		catch(Exception ex) {
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		List<UserBookDetails> books = new ArrayList<UserBookDetails>();
		for(Object[] row : r){
			UserBookDetails b = new UserBookDetails();
			b.setBUId(Integer.parseInt(row[0].toString()));
			b.setBID(Integer.parseInt(row[1].toString()));
			b.setUID(Integer.parseInt(row[2].toString()));
			b.setDateIssued( (Date) row[3]);
			b.setDateReturned((Date) row[4]);
            if(row[5]!=null){
                b.setApproved(row[5].toString());
            }
			b.setUserName(row[6].toString());
			b.setRollNumber(Integer.parseInt(row[7].toString()));
			b.setBookName(row[8].toString());
			b.setAuthor(row[9].toString());
			b.setPublisher(row[10].toString());
            if(row[11]!=null){
                b.setReturnRequest(row[11].toString());
            }
			books.add(b);
		}

		return books;
	}

	@Override
	public List<UserBookDetails> getUserDetails(int id) {
		System.out.println("sup");
		Session session = HibernateUtil.getSF().openSession();
		List<Object[]> r =null;
		try {
			session.beginTransaction();
			System.out.println("getting the Details for User...");
			 Query q = session.createSQLQuery("select BUID,BID,UID, Date_Of_Issue ,Date_Of_Return , Approved ,username ,roll ,Name ,Author ,Publisher,Return_request from record r left join user u on u.id = r.uid left join book b on r.bid = b.bookid where u.id = :id");
			 		q.setInteger("id", id);
			 	 r = q.getResultList();
	      	   	session.getTransaction().commit();
		}
		catch(Exception ex) {
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		List<UserBookDetails> books = new ArrayList<UserBookDetails>();
		for(Object[] row : r){
			UserBookDetails b = new UserBookDetails();
			b.setBUId(Integer.parseInt(row[0].toString()));
			b.setBID(Integer.parseInt(row[1].toString()));
			b.setUID(Integer.parseInt(row[2].toString()));
			b.setDateIssued( (Date) row[3]);
			b.setDateReturned((Date) row[4]);
			if(row[5]!=null){
                b.setApproved(row[5].toString());
            }
			b.setUserName(row[6].toString());
			b.setRollNumber(Integer.parseInt(row[7].toString()));
			b.setBookName(row[8].toString());
			b.setAuthor(row[9].toString());
			b.setPublisher(row[10].toString());
			if(row[11]!=null){
                b.setReturnRequest(row[11].toString());
            }
			books.add(b);
		}

		return books;
	}

	@Override
	public void acceptRequest(int buid) {
		// TODO Auto-generated method stub
		Date date = new Date();

		Session session = HibernateUtil.getSF().openSession();
		Record r = null;
		try {
			session.beginTransaction();
			System.out.println("Getting  record...");

		Query q = session.createQuery("from Record where buid=:n");
			q.setInteger("n", buid);

			r= (Record) q.getSingleResult();

			r.setIssueDate(date);
			r.setApproved("approved");
			session.update(r);

			session.getTransaction().commit();
			System.out.println("Done...");
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
    public List<Integer> getRecordsByUserId(int id) {
        Session session = HibernateUtil.getSF().openSession();
        System.out.println("get book already owned by user");
        List<Integer> records = null;
        try {
            session.beginTransaction();
            /*
             * list= session.createCriteria(Book.class ).add(Restrictions.like("Name",
             * "%"+query+"%")) .list();
             */
            org.hibernate.Query<Integer> q = session.createQuery("select r.bid from Record r where r.uid = :i");
            q.setInteger("i",id);


            records= q.getResultList();

            session.getTransaction().commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
            session.getTransaction().rollback();
        }
        finally {
            session.close();
        }
        return records;
    }


    @Override
	public Record getRecordById(int id) {
		// TODO Auto-generated method stub
		Record rec= null ;
		Session session = HibernateUtil.getSF().openSession();
			try{ 
				rec = session.get(Record.class, id);
			} catch (HibernateException ex) {
				ex.printStackTrace();
				session.getTransaction().rollback();
			}finally {
				session.close();
			}
			
			return rec;
	
	}

}
