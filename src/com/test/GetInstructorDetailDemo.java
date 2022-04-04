package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Instructor;
import com.instructor.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Get Instructor Instructor");
		//we need to refer from Instructor detail class to --> Instructor class
		
		int theId = 22;
		InstructorDetail instDetail = session.get(InstructorDetail.class, theId);
		
		System.out.println("instructorDetail: "+instDetail);
		System.out.println("the associated instructor: "+instDetail.getInstructor());
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
