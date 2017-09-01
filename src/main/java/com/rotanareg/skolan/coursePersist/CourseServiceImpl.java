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
        CourseEntity c = new CourseEntity(course.getName(),course.getDescription(),course.getCourseNr());
        em.persist(c);

    }

    @Override
    public void updateCourse(Course course) {
        CourseEntity c = em.find(CourseEntity.class,course.getId());
        c.setName(course.getName());
        c.setDescription(course.getDescription());
        c.setCourseNr(course.getCourseNr());
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
        Course cd = new Course(c.getId(),c.getName(),c.getDescription(),c.getCourseNr());

        return cd;
    }

    @Override
    public List<Course> getCourses() {
       List<CourseEntity> courseEntityList = em.createNamedQuery("selectAllCourses").getResultList();
       if (courseEntityList.isEmpty()){
           CourseEntity a = new CourseEntity("Engelska",
                   "Du som behärskar engelska kommer långt. Engelska är ett världsspråk och antalet engelsktalande människor i världen ökar ständigt. Men engelska är inte bara samtal. Det är också litteratur att läsa och texter att skriva. Välkommen till oss när du vill förbättra din engelska!",
                   "E1234A");
           em.persist(a);
           CourseEntity b = new CourseEntity("Svenska",
                   "Utbildningen är individualiserad och innan antagning sker en intestning. Du kan delta i utbildningen även om du inte har avslutat din Svenska för invandrare, SFI. Korta vägen pågår i 25 veckor och därutöver ingår 5 veckors praktik. Utbildningen utförs av Folkuniversitetet i Umeå i samarbete med Umeå universitet. Det finns möjlighet till individuell förlängning.",
                   "Sv234B");
           em.persist(b);
           CourseEntity c = new CourseEntity("allmän datakunskap",
                   "Kom igång och lär dig data från början. Folkuniversitetet är en erfaren data- och IT-utbildare. Vi har kurser för både nybörjare och erfarna dataanvändare, för juniorer såväl som seniorer och inom både allmän datakunskap och enskilda datorprogram.",
                   "DK234C");
           em.persist(c);
       }
       return courseEntityList.stream().
               map(c->new Course(c.getId(),c.getName(),c.getDescription(),c.getCourseNr())).
               collect(Collectors.toList());
    }

    @Override
    public List<Course> getCoursesContaining(String filter) {
        List<CourseEntity> courseEntityList = em.createNamedQuery("selectSomeCourses").setParameter("filt",filter).getResultList();

        return courseEntityList.stream().
                map(c->new Course(c.getId(),c.getName(),c.getDescription(),c.getCourseNr())).
                collect(Collectors.toList());
    }

}
