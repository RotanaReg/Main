/******************************
 * POJO - Mellanskikt mellan AttendanceBean (vanlig böna) och EJB (Enterprise-böna), samt JPA (transformerings-klass).
 * Inkapslings-klass (hjälp-klass) för att underlätta transporten av data mellan objekt.
 ******************************/

package com.rotanareg.skolan.domains;

import java.sql.Date;

/**
 * Created by Marko K. Seppänen.
 */
public class AttendanceDomain {
    private Long id;
//    private Course course;
//    private User user;
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

 /*   public AttendanceDomain(Long id, Course course, User user, Date date, boolean hasAttended) {
        this.id = id;
        this.courseId = courseId;
        this.userId = userId;
        this.sqlDate = date;
        this.hasAttended = hasAttended;
    }
*/

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

}
