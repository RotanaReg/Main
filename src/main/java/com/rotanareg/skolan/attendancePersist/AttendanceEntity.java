/******************************
 * JPA Entity class defines whose instances can be stored in the database.
 * The Entity represents your Data Object Model.
 ******************************/

package com.rotanareg.skolan.attendancePersist;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.domains.Course;
import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "Attendance",
        uniqueConstraints={@UniqueConstraint(columnNames = {"USER_ID", "COURSE_ID", "DATE"})})
@NamedQueries({
        @NamedQuery(name = "selectAllAttendance", query = "SELECT p FROM AttendanceEntity p"),
        @NamedQuery(name = "selectAttendanceByUserId", query = "SELECT u FROM AttendanceEntity u WHERE u.user.id = :filt"),
        @NamedQuery(name = "selectAttendanceByCourseId", query = "SELECT c FROM AttendanceEntity c WHERE c.course.id = :filt")})

public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    private UserEntity user;

    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    private CourseEntity course;

    @NotNull
    @Column(name = "DATE")
    private Date sqlDate;           //yyyy-mm-dd

    @Column(name = "ATTENDED")
    private boolean hasAttended;

    public AttendanceEntity() {
    }

    public AttendanceEntity(UserEntity user, CourseEntity course, Date sqlDate, boolean hasAttended) {
        this.user = new UserEntity();
        this.course = course;
        this.sqlDate = sqlDate;
        this.hasAttended = hasAttended;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }
}
