/******************************
 * POJO - Mellanskikt mellan AttendanceBean (vanlig böna) och EJB (Enterprise-böna), samt JPA (transformerings-klass).
 * Inkapslings-klass (hjälp-klass) för att underlätta transporten av data mellan objekt.
 ******************************/

package com.rotanareg.skolan.domains;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.userPersist.UserEntity;

import java.sql.Date;

/**
 * Created by Marko K. Seppänen.
 */
public class AttendanceDomain {
    private Long id;
    //    private Course course;
//    private User user;
    private String courseNr;
    private String courseName;
    private String userNameFull;
    private Date sqlDate;           //yyyy-mm-dd
    private boolean hasAttended;

    public AttendanceDomain(Date date, boolean hasAttended) {
        this.sqlDate = date;
        this.hasAttended = hasAttended;
    }

    public AttendanceDomain(Long id, Date date, boolean hasAttended) {
        this.id = id;
        this.sqlDate = date;
        this.hasAttended = hasAttended;
    }

    public AttendanceDomain(Long id, Course course, User user, Date date, boolean hasAttended) {
        this.id = id;
        this.courseName = course.getName();
        this.courseNr = course.getCourseNr();
        this.userNameFull = user.getName() + " " + user.getLastName();  // TODO: perhaps move this part to be handled in the User class.
        this.sqlDate = date;
        this.hasAttended = hasAttended;
    }

    public AttendanceDomain(Long id, CourseEntity eCourse, UserEntity eUser, Date date, boolean hasAttended) {
        this.id = id;
        this.courseName = eCourse.getName();
        this.courseNr = eCourse.getCourseNr();
        this.userNameFull = eUser.getName() + " " + eUser.getLastName();    // TODO: perhaps move this part to be handled in the User class.
        this.sqlDate = date;
        this.hasAttended = hasAttended;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*    public Course getCourse() {
            return course;
        }

        public void setCourse(Course course) {
            this.course = course;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    */
    public Date getDate() {
        return sqlDate;
    }

    public void setDate(Date date) {
        this.sqlDate = sqlDate;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }

    public String getCourseNr() {
        return courseNr;
    }

    public void setCourseNr(String courseNr) {
        this.courseNr = courseNr;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUserNameFull() {
        return userNameFull;
    }

    public void setUserNameFull(String userNameFull) {
        this.userNameFull = userNameFull;
    }
}
