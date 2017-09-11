package com.rotanareg.skolan.coursePersist;

import com.rotanareg.skolan.domains.Course;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;


@Stateless
public class CourseServiceImpl implements CourseService{
    @PersistenceContext
    EntityManager em;

    @Override
    public void addCourse(Course course) {

            if (!course.getCourseTitle().isEmpty() || !course.getCourseCode().isEmpty() || !course.getDescription().isEmpty()) {
                CourseEntity c = new CourseEntity(course.getCourseTitle(), course.getDescription(), course.getCourseCode());
                em.persist(c);
            }


    }

    @Override
    public void updateCourse(Course course) {
        CourseEntity c = em.find(CourseEntity.class,course.getId());
        c.setCourseTitle(course.getCourseTitle());
        c.setDescription(course.getDescription());
        c.setCourseCode(course.getCourseCode());
        em.merge(c);
    }

    @Override
    public void removeCourse(Long id) {
        CourseEntity c = em.find(CourseEntity.class, id);
        em.remove(c);
    }

    @Override
    public Course getCourse(Long id) {
        CourseEntity c = em.find(CourseEntity.class,id);
        Course cd = new Course(c.getId(),c.getCourseTitle(),c.getDescription(),c.getCourseCode());

        return cd;
    }

    @Override
    public List<Course> getCourses() {
       List<CourseEntity> courseEntityList = em.createNamedQuery("selectCourses").getResultList();
       if (courseEntityList.isEmpty()){
           CourseEntity a = new CourseEntity("Engelska",
                   "Du som behärskar engelska kommer långt. Engelska är ett världsspråk och antalet engelsktalande människor i världen ökar ständigt. Men engelska är inte bara samtal. Det är också litteratur att läsa och texter att skriva. Välkommen till oss när du vill förbättra din engelska!",
                   "E1234A");
           em.persist(a);
           CourseEntity b = new CourseEntity("Svenska",
                   "Utbildningen är individualiserad och innan antagning sker en intestning. Du kan delta i utbildningen även om du inte har avslutat din Svenska för invandrare, SFI. Korta vägen pågår i 25 veckor och därutöver ingår 5 veckors praktik. Utbildningen utförs av Folkuniversitetet i Umeå i samarbete med Umeå universitet. Det finns möjlighet till individuell förlängning.",
                   "Sv234B");
           em.persist(b);
           CourseEntity c = new CourseEntity("Allmän datakunskap",
                   "Kom igång och lär dig data från början. Folkuniversitetet är en erfaren data- och IT-utbildare. Vi har kurser för både nybörjare och erfarna dataanvändare, för juniorer såväl som seniorer och inom både allmän datakunskap och enskilda datorprogram.",
                   "DK234C");
           em.persist(c);
       }
       return courseEntityList.stream().
               map(c->new Course(c.getId(),c.getCourseTitle(),c.getDescription(),c.getCourseCode())).
               collect(Collectors.toList());
    }

    @Override
    public List<Course> getCoursesContaining(String filter) {
        List<CourseEntity> courseEntityList = em.createNamedQuery("selectSomeCourses").setParameter("filt",filter).getResultList();

        return courseEntityList.stream().
                map(c->new Course(c.getId(),c.getCourseTitle(),c.getDescription(),c.getCourseCode())).
                collect(Collectors.toList());
    }

}
