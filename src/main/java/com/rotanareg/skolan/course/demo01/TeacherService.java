package com.rotanareg.skolan.course.demo01;

import com.rotanareg.skolan.course.Teacher;

import javax.persistence.EntityManager;

public class TeacherService {


    //Attributes

    private EntityManager em;

    //Constructors

    public TeacherService(EntityManager em) {
        this.em = em;
    }

    //Public Methods

    public Teacher createTeacher(Teacher course) {
        em.persist(course);
        return course;
    }

    public void removeTeacher(Teacher course) {
        em.remove(em.merge(course));
    }

    public Teacher findTeacher(Long id) {
        return em.find(Teacher.class, id);
    }
}

