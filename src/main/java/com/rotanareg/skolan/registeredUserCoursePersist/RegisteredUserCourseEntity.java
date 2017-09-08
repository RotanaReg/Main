package com.rotanareg.skolan.registeredUserCoursePersist;

import javax.persistence.Entity;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;
//import javax.jdo.annotations.Unique;

@Entity
//@Table(name="COURSE_USER")
@Table(name="REG_COURSE_USER",
        uniqueConstraints={@UniqueConstraint(columnNames = {"ID"})})
@IdClass(RegisteredUserCourseId.class)
@NamedQueries({
        @NamedQuery(name = "selectAllRegisteredUserCourse", query = "SELECT p FROM RegisteredUserCourseEntity p")})
public class RegisteredUserCourseEntity {
    //@UniqueConstraint(id)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Id
    private long courseId;

    @Id
    private long userId;

    @Column(name="IS_BOOKED")
    private boolean isBooked;   // True när elev registrerat/gjort_instresse-anmälan för en kurs.

    @Column(name="IS_ASSIGNED")
    private boolean isAssigned; // True när Admin anslutit en elev/lärare.

	@Column(name="IS_TEACHER")
    private boolean isTeacher;  // Om användaren är en elev.

    @ManyToOne
    @PrimaryKeyJoinColumn(name="COURSEID", referencedColumnName = "ID")
    private CourseEntity course;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="USERID", referencedColumnName = "ID")
    private UserEntity user;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(Long personId) {
        this.userId = userId;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public UserEntity getPerson() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

