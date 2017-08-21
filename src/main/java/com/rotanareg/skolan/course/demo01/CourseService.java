package com.rotanareg.skolan.course.demo01;


import com.rotanareg.skolan.course.Course;

import javax.persistence.EntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CourseService {

    //Attributes
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("rotanaRegPU-persistence-unit"); //fyll i namnet på persistence unit i persistance fil
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    //Public methods
    public Course createCourse (Long id, String courseCode, String courseTitle, String description, String teacherFirstName, String teacherLastName){
        Course course = new Course();
        course.setId(id);
        course.setCourseCode(courseCode);
        course.setCourseTitle(courseTitle);
        course.setDescription(description);
        course.setTeacherFirstName(teacherFirstName);
        course.setTeacherLastName(teacherLastName);
        tx.begin();
        em.persist(course);
        tx.commit();
        return course;
    }

    public void removeCourse(Long id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            tx.begin();
            em.remove(course);
            tx.commit();
        }
    }

    public Course findCourse(Long id) {
        return em.find(Course.class, id);
    }

    }


