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

    @Override
    public void addAttendance(AttendanceDomain attendance) {
        if ((attendance.getCourseId() < 1) || (attendance.getUserId() < 1) || (attendance.getSqlDate() != null)){
            AttendanceEntity a = new AttendanceEntity(
                    (UserEntity) em.createNamedQuery("selectUserById").
                            setParameter("filt", attendance.getUserId()).
                            getSingleResult(),
                    (CourseEntity) em.createNamedQuery("selectCourseById").
                            setParameter("filt", attendance.getCourseId()).
                            getSingleResult(),
                    attendance.getSqlDate(),
                    attendance.isHasAttended());
            em.persist(a);
        }
    }

    @Override
    public List<AttendanceDomain> getAttendanceByUser(Long userId) {
        // get list for specific user
        List<AttendanceEntity> attendanceByUser = em.createNamedQuery("selectAttendanceByUserId").setParameter("filt", userId).getResultList();

        // test so the list is not empty
        if (!attendanceByUser.isEmpty()) {
            // return new list of AttendanceDomain objects
            return attendanceByUser.stream().
                    map(u -> new AttendanceDomain(
                            u.getId(), u.getUser().getId(), u.getCourse().getId(), u.getSqlDate(), u.isHasAttended())).
                    collect(Collectors.toList());
        } else {
            // If attendanceByUser was empty, return an empty AttendanceDomain List
            return new ArrayList<AttendanceDomain>();
        }
    }

    @Override
    public List<AttendanceDomain> getAttendanceByCourse(Long courseId) {
        // get list for specific course
        List<AttendanceEntity> attendanceByCourse = em.createNamedQuery("selectAttendanceByCourseId").setParameter("filt", courseId).getResultList();

        // test so the list is not empty
        if (!attendanceByCourse.isEmpty()) {
            // return new list of AttendanceDomain objects
            return attendanceByCourse.stream().
                    map(u -> new AttendanceDomain(
                            u.getId(), u.getUser().getId(), u.getCourse().getId(), u.getSqlDate(), u.isHasAttended())).
                    collect(Collectors.toList());
        } else {
            // If attendanceByCourse was empty, return an empty AttendanceDomain List
            return new ArrayList<AttendanceDomain>();
        }
    }

    @Override
    public List<AttendanceDomain> getAttendance() {
        // get list for all courses and users
        List<AttendanceEntity> attendance = em.createNamedQuery("selectAllAttendance").getResultList();

        // test so the list is not empty
        if (!attendance.isEmpty()) {
            // return new list of AttendanceDomain objects
            return attendance.stream().
                    map(u -> new AttendanceDomain(
                            u.getId(), u.getUser().getId(), u.getCourse().getId(), u.getSqlDate(), u.isHasAttended())).
                    collect(Collectors.toList());
        } else {
            // If attendance was empty, return an empty AttendanceDomain List
            return new ArrayList<AttendanceDomain>();
        }
    }

    @Override
    public void updateAttendance(AttendanceDomain attendance) {
        // Find Attendance to be updated
        AttendanceEntity attendanceEntity = em.find(AttendanceEntity.class,attendance.getId());

        // Update values
        attendanceEntity.setCourse(em.find(CourseEntity.class,attendance.getCourseId()));
        attendanceEntity.setUser(em.find(UserEntity.class,attendance.getUserId()));
        attendanceEntity.setSqlDate(attendance.getSqlDate());
        attendanceEntity.setHasAttended(attendance.isHasAttended());

        // Update attendance
        em.merge(attendanceEntity);

    }

    @Override
    public void removeAttendance(Long attendanceId) {
        // Find attendance to be removed
        AttendanceEntity attendanceEntity = em.find(AttendanceEntity.class,attendanceId);
        em.remove(attendanceEntity);
    }
}
