/******************************
 * JPA Entity class defines whose instances can be stored in the database.
 * The Entity represents your Data Object Model.
 ******************************/

package com.rotanareg.skolan.attendancePersist;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import java.util.*;
import java.sql.Date;
import java.text.DateFormat.*;
import java.text.*;

/**
 * Created by Marko K. Seppänen.
 */
/*@NamedQueries({
        @NamedQuery(name = "selectAll", query = "SELECT p FROM Course p"),
        @NamedQuery(name = "selectSome", query = "SELECT t FROM Course t WHERE LOCATE(:filt,t.name) >0 ")
})*/
@Entity
@Table(name = "Attendance")
@NamedQueries({
        @NamedQuery(name = "selectAll", query = "SELECT p FROM AttendanceEntity p"),
        //@NamedQuery(name = "selectSome", query = "SELECT t FROM AttendanceEntity t WHERE LOCATE(:filt,t.name) >0 ")
})
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@NotNull
    //private Long courseId;
/*    private CourseEntity course;

    //@NotNull
    //private Long userId;
    private UserEntity user;
*/
    ////@Temporal(TemporalType.DATE)
    ////@DateFormat(format = "yyyy-MM-dd")
    //@NotNull
    private Date sqlDate;           //yyyy-mm-dd
    private boolean hasAttended;

    public AttendanceEntity() {
    }

    public AttendanceEntity(Date date, boolean hasAttended) {
        this.sqlDate = date;
        this.hasAttended = hasAttended;
    }

 /*   public AttendanceEntity(CourseEntity course, UserEntity user, Date sqlDate, boolean hasAttended) {
        this.course = course;
        this.user = user;
        this.sqlDate = sqlDate;
        this.hasAttended = hasAttended;
    }
*/
    public Long getId() {
        return id;
    }

/*    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
*/
    public Date getDate() {
        return sqlDate;
    }

    public void setDate(Date date) {
        this.sqlDate = date;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }
}
