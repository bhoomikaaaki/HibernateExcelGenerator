package com.bhoomi.sprig.HibernateExcelGenerator;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Database {
	
	public List<Student> importData()
	{
		
		SessionFactory sessionFactory = null;
		
		Session session= null;
		
		List <Student> list  = null;
		
		try
		{			
		
		
			Configuration cfg = new Configuration();
		
			cfg.configure("hibernate.cfg.xml");
		
			sessionFactory = cfg.buildSessionFactory();
		
			session = sessionFactory.openSession();
			
			Transaction transaction = session.beginTransaction();
			
			Query query = session.createQuery("from Student");
			
			list = query.list();
			
			
			
			Student student=new Student(123,"bhoomi",21,"female");
			
			session.save(student);
			
			list = query.list();
			
			 
			 
			 transaction.commit();

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if( session!=null )
			{
				session.close();
			}
			
			if( sessionFactory !=null)
			{
				sessionFactory.close();
			}
			
		}
			
		return list;
	}


}
