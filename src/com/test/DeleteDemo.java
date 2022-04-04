package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Instructor;
import com.instructor.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Deleting new Instructor");
		
		Instructor inst = session.get(Instructor.class, 3);
		
		if(inst != null) {
			//NOTE: will also delete associated details object
			//because of cascadeType.All
			session.delete(inst);
		}

		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
