package com.rotanareg.skolan.course.demo01;

import com.rotanareg.skolan.course.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;


import static com.rotanareg.skolan.course.DateB.date;

public class TeacherServiceImpl {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("\n\n>>> Executing : " + TeacherServiceImpl.class.toString() + " <<<\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("rotanareg-persistence-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        TeacherService service = new TeacherService(em);
        Teacher teacher = new Teacher("Pernila", "Johansson", "pernila.johansson@gmail.com", date("1973-11-25"),"072123465" );

        // Creates and persists a teacher
        tx.begin();
        teacher = service.createTeacher(teacher);
        tx.commit();
        Long id = teacher.getId();

        System.out.println("Teacher Persisted : " + teacher);

        // Finds the teacher
        teacher = service.findTeacher(id);

        System.out.println("Teacher Found     : " + teacher);

        // Removes the teacher
        tx.begin();
        service.removeTeacher(teacher);
        tx.commit();

        System.out.println("Teacher Removed");

        // Finds the teacher
        teacher = service.findTeacher(id);

        System.out.println("Teacher Not Found : " + teacher);

        em.close();
        emf.close();
    }
}


