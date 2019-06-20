package com.libs.sys.HibernateUtil;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
		private static SessionFactory sf;
		
		static {
			try {
				sf =  new Configuration()
						.configure("hibernate.cfg.xml")
						.buildSessionFactory();
			}catch(Exception e) {
				System.out.println(e);
			}
		}

		public static SessionFactory getSF() {
			return sf;
		}

}
