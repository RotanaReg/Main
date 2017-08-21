package com.rotanareg.skolan.course.demo01;


import com.rotanareg.skolan.course.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;


import static com.rotanareg.skolan.course.DateB.date;

    public class StudentServiceImpl {

        public static void main(String[] args) throws SQLException, ClassNotFoundException {

            System.out.println("\n\n>>> Executing : " + StudentServiceImpl.class.toString() + " <<<\n");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("rotanareg-persistence-unit");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            StudentService service = new StudentService(em);
            Student student = new Student("John", "Person", "john.person@gmail.com", date("01/11/1993"),"073823795" );

            // Creates and persists a student
            tx.begin();
            student = service.createStudent(student);
            tx.commit();
            Long id = student.getId();

            System.out.println("Student Persisted : " + student);

            // Finds the student
            student = service.findStudent(id);

            System.out.println("Student Found     : " + student);

            // Removes the student
            tx.begin();
            service.removeStudent(student);
            tx.commit();

            System.out.println("Student Removed");

            // Finds the student
            student = service.findStudent(id);

            System.out.println("Student Not Found : " + student);

            em.close();
            emf.close();
        }
    }



