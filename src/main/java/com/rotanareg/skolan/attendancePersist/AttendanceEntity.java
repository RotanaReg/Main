/******************************
 * JPA Entity class defines whose instances can be stored in the database.
 * The Entity represents your Data Object Model.
 ******************************/

package com.rotanareg.skolan.attendancePersist;

import com.rotanareg.skolan.coursePersist.*;
import com.rotanareg.skolan.userPersist.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import java.util.*;
import java.sql.Date;
import java.text.DateFormat.*;
import java.text.*;


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

    //private long courseId;
    //private long userId;

    //@NotNull
    //private Long courseId;
//    @PrimaryKeyJoinColumn(name="COURSEID", referencedColumnName = "ID")
    private CourseEntity course;

    //@NotNull
    //private Long userId;
//    @PrimaryKeyJoinColumn(name="USERID", referencedColumnName = "ID")
    private UserEntity user;

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

<<<<<<< HEAD
   public AttendanceEntity(CourseEntity course, UserEntity user, Date sqlDate, boolean hasAttended) {
=======
    public AttendanceEntity(CourseEntity course, UserEntity user, Date sqlDate, boolean hasAttended) {
>>>>>>> d5672be5db46db5d1c4bbfd509e8c977cbb48c1f
        this.course = course;
        this.user = user;
        this.sqlDate = sqlDate;
        this.hasAttended = hasAttended;
    }

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

    public CourseEntity getCourse() {
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
}
