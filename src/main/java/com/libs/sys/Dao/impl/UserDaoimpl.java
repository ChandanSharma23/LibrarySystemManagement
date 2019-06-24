package com.libs.sys.Dao.impl;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.libs.sys.Dao.UserDao;
import com.libs.sys.Entity.User;
import com.libs.sys.HibernateUtil.HibernateUtil;

@Repository
public class UserDaoimpl implements UserDao {

	@Override
	public int addUser(User user) {
        Session session = HibernateUtil.getSF().openSession();
		Integer id =null;
		try {
				session.beginTransaction();
				id =(Integer)session.save(user);
		        session.getTransaction().commit();
			} catch (Exception ex) {
					ex.printStackTrace();
					session.getTransaction().rollback();
			}finally {
				session.close();
			}
		
		return id;
	}

	@Override
	public User fetchUserbyID(int id)  {
			
			Session session = HibernateUtil.getSF().openSession();
		    User s = null;
			try {
				session.beginTransaction();
				System.out.println("getting the User...");
				
		        s = session.get(User.class,id);
		     	session.getTransaction().commit();
			}
			catch(Exception ex) {
				session.getTransaction().rollback();
			}
			finally {
				session.close();
			}
		
	return s;
	}	

	@Override
	public void updateUser(User s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserID(int id) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("deprecation")
	@Override
	public User getUser(int roll, String password) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSF().openSession();
	    User s = null;
		try {
			session.beginTransaction();
			System.out.println("getting the User...");
			
	       Query q = session.createQuery(" from User where roll=:r and password = :p");
	    		   q.setInteger("r", roll);
	    		   q.setString("p", password);
	    		   
	      s = (User) q.getSingleResult();
	     	session.getTransaction().commit();
		}
		catch(Exception ex) {
			System.out.println(ex);
			
			session.getTransaction().rollback();
		}
		finally {
			session.close();
		}
		return s;

	}

	
}
