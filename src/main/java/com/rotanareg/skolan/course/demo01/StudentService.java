package com.rotanareg.skolan.course.demo01;
import com.rotanareg.skolan.course.Student;

import javax.persistence.EntityManager;


public class StudentService {

        //Attributes
        private EntityManager em;

        //Constructors
        public StudentService(EntityManager em) {
            this.em = em;
        }

        //Public Methods
        public Student createStudent(Student course) {
            em.persist(course);
            return course;
        }

        public void removeStudent(Student course) {
            em.remove(em.merge(course));
        }

        public Student findStudent(Long id) {
            return em.find(Student.class, id);
        }
    }



