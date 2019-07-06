package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
	
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

			try {
				
				int studentID = 1;
				
				// now get a new session and start transaction
				session = factory.getCurrentSession();
				session.beginTransaction();
				
				// retrieve student based on the id: primary key
				System.out.println("\nGetting student with id: " + studentID);
				
				Student myStudent = session.get(Student.class, studentID);
				
				System.out.println("Updating students...");
				myStudent.setFirstName("Scooby");
				
				
				
				// commit the transaction
				session.getTransaction().commit();
				
				System.out.println("Done!");
			} 
			finally {
					factory.close();
				}
			}

		

	}


