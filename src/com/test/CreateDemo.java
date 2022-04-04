package com.test;

import org.hibernate.Session;

import com.Util.HibernateUtil;
import com.instructor.Instructor;
import com.instructor.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		System.out.println("Creating new Instructor");
//		Instructor inst = new Instructor("Chad", "Darby", "darby@gmail.com");
//		InstructorDetail instDetail = new InstructorDetail("www.youtube.com/abc", "loveToCode");

		Instructor inst = new Instructor("Joni", "Otash", "otashjoni@gmail.com");

		InstructorDetail instDetail = new InstructorDetail("www.youtube.com/jonio", "loveOtash");

		// associate the objects, mapping together
		inst.setInstructorDetail(instDetail);

		// save the instructor
		// Note: this will ALSO save the details object
		// because of CascadeType.All
		System.out.println("Saving instructor " + inst);
		session.save(inst);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
		System.out.println("Done!");
	}

}
