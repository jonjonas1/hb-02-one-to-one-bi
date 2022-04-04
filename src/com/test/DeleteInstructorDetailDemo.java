package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Instructor;
import com.instructor.InstructorDetail;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Get Instructor Instructor");
		//we need to refer from Instructor detail class to --> Instructor class
		
		int theId = 5;
		InstructorDetail instDetail = session.get(InstructorDetail.class, theId);
		
		// deleting instructor from instructor details
		System.out.println("instructorDetail: "+instDetail.getInstructor());
		System.out.println("Deleting instructor detail "+instDetail);
		
		// remove the associated object reference
		instDetail.getInstructor().setInstructorDetail(null);
		
		session.delete(instDetail);
		
		
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
