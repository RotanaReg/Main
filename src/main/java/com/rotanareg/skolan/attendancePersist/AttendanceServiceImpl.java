/******************************
 * EJB - Enterprise bean (EJB), som stödjer tjänsten AttendanceService.
 ******************************/

package com.rotanareg.skolan.attendancePersist;

import com.rotanareg.skolan.coursePersist.*;
import com.rotanareg.skolan.userPersist.*;
import com.rotanareg.skolan.domains.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Marko K. Seppänen.
 */
@Stateless
public class AttendanceServiceImpl implements AttendanceService {
    @PersistenceContext
    EntityManager em;

    // (C)reate / add.
    @Override
    public void addAttendance(AttendanceDomain ad){
        AttendanceEntity dom = new AttendanceEntity(ad.getDate(), ad.isHasAttended());    // Create the Data Object Model
        em.persist(dom);
    }

    // (R)ead / get.
/*    @Override
    public AttendanceDomain getAttendance(Long id){
        Course c = em.find(Course.class, id);
        return new CourseDomain(c.getId(), c.getName(), c.getCode());
    }

    // (U)pdate.
    @Override
    public void updateAttendance(AttendanceDomain attendance){
        Course c = em.find(Course.class, course.getId());
        c.setName(course.getName());
        c.setCode(course.getCode());
        em.merge(c);

    }

    // (D)elete.
    @Override
    public void deleteAttendance(Long id){
        Course c = em.find(Course.class, id);
        em.remove(c);
    }
*/

    @Override
    public List<AttendanceDomain> getAttendances() {
        /*Query query = em.createQuery("select a from Course a where a.code = :lname and a.name = :fname", Course.class);
        query.setParameter("lname", "Karlsson");
        query.setParameter("fname", "Kalle");
        */
        /*Query query = em.createQuery("select a from Attendance a where a.code = :lname and a.name = :fname", AttendanceEntity.class);
        query.setParameter("lname", "Karlsson");
        query.setParameter("fname", "Kalle");
        */
        //List<CourseEntity> courseEntityList = em.createNamedQuery("selectAllCourses").getResultList();

        /*
        List<AttendanceEntity> courseRecords = query.getResultList();
        System.out.println("course Size " + courseRecords.size());
        */

        List<AttendanceEntity> entityList = em.createNamedQuery("selectAll").getResultList();
        List<AttendanceDomain> domainList = new ArrayList();

/*        return entityList.stream().
                //map(a -> new AttendanceDomain(a.getId(), a.getDate(), a.isHasAttended())).
                map(a -> new AttendanceDomain(a.getId(), a.getDate(), a.isHasAttended())).
                collect(Collectors.toList());
                */
        for(AttendanceEntity e: entityList){
            // TODO: completer below
            // AttendanceDomain(Long id, CourseEntity eCourse, UserEntity eUser, Date date, boolean hasAttended):
            domainList.add(new AttendanceDomain(e.getId(), e.getCourse(), e.getUser(), e.getDate(), e.isHasAttended()));
        }
        return domainList; 
    }
/*
    @Override
    public List<CourseDomain> getCoursesNameContain(String filter) {

        List<Course> l = em.createNamedQuery("selectSome").setParameter("filt", filter).getResultList();

        return l.stream().
                map(p -> new CourseDomain(p.getId(), p.getName(), p.getCode())).
                collect(Collectors.toList());

    }
*/
    public String getCourseNr(Long id) {
        AttendanceEntity e = em.find(AttendanceEntity.class, id);
        return e.getCourse().getCourseNr();
    }

    public String getCourseName(Long id) {
        AttendanceEntity e = em.find(AttendanceEntity.class, id);
        return e.getCourse().getName();
    }

}
