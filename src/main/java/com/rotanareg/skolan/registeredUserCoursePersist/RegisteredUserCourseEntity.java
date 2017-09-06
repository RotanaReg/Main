package com.rotanareg.skolan.registeredUserCoursePersist;

import javax.persistence.Entity;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;


@Entity
//@Table(name="COURSE_USER")
@Table(name="REG_COURSE_USER")
@IdClass(RegisteredUserCourseId.class)
public class RegisteredUserCourseEntity {

    @Id
    private long courseId;

    @Id
    private long personId;

    @Column(name="IS_TEACHER")  // Om användaren är en elev.
    private boolean isTeacher;

    @Column(name="IS_BOOKED")   // True när elev registrerat/gjort_instresse-anmälan för en kurs.
    private boolean isBooked;

    @Column(name="IS_ASSIGNED")
    private boolean isAssigned; // True när Admin anslutit en elev/lärare.

    @ManyToOne
    @PrimaryKeyJoinColumn(name="COURSEID", referencedColumnName = "ID")
    private CourseEntity course;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="PERSONID", referencedColumnName = "ID")
    private UserEntity person;

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
        return person;
    }

    public void setPerson(UserEntity person) {
        this.person = person;
    }
}

