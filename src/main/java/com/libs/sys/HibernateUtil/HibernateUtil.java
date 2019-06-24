package com.libs.sys.HibernateUtil;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.libs.sys.Entity.User;

public class HibernateUtil 
{
		private static SessionFactory sf;
		
		static {
			try {
				sf =  new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(User.class).buildSessionFactory();
				  }catch(Exception e) {
				System.out.println(e);
			}
		}

		public static SessionFactory getSF() {
			return sf;
		}

		private static void buildSessionFactory() {
			// TODO Auto-generated method stub
			
		}

		private static Object addAnnotatedClass(Class<User> class1) {
			// TODO Auto-generated method stub
			return null;
		}

}
