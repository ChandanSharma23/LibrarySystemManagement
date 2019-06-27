package com.libs.sys.Dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.libs.sys.Dao.RecordDao;
import com.libs.sys.Entity.Record;
import com.libs.sys.Entity.User;
import com.libs.sys.HibernateUtil.HibernateUtil;
import com.libs.sys.Model.UserBookDetails;
@Repository
public class RecordDaoImpl implements RecordDao {

	@Override
	public void addRecord(Record record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Record updateRecord(Record record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserBookDetails> getUserDetails(int id) {
		System.out.println("sup");
		Session session = HibernateUtil.getSF().openSession();
		List<Object[]> r =null;
		try {
			session.beginTransaction();
			System.out.println("getting the Details for User...");
			 Query q = session.createSQLQuery("select BUID,BID,UID, Date_Of_Issue ,Date_Of_Return ,  Approved ,username ,roll ,Name ,Author ,Publisher from record r left join user u on u.id = r.uid left join book b on r.bid = b.bookid where u.id = :id");
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
			if(row[5]!=null) {
				b.setApproved(  Boolean.valueOf(row[5].toString()));
			}
			b.setUserName(row[6].toString());
			b.setRollNumber(Integer.parseInt(row[7].toString()));
			b.setBookName(row[8].toString());
			b.setAuthor(row[9].toString());
			b.setPublisher(row[10].toString());
			books.add(b);
		}
	
		return books;
	}

}
