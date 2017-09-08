package com.rotanareg.skolan.domains;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.userPersist.UserEntity;

public class RegisteredUserCourseDomain {
    private Long id;
    private Long userId;
    private Long courseId;
    private Boolean isBooked;   // True när elev registrerat/gjort_instresse-anmälan för en kurs.
    private Boolean isAssigned; // True när Admin anslutit en elev/lärare.
    private Boolean isTeacher;  // Om användaren är en elev.

    //private User user;
    //private Course course;
    private UserEntity user;
    private CourseEntity course;

    public RegisteredUserCourseDomain(boolean isBooked, boolean isAssigned) {
        this(null, null, null, isBooked, isAssigned, null, null, null);
    }

    public RegisteredUserCourseDomain(boolean isBooked, boolean isAssigned, boolean isTeacher) {
        //this(null, null, null, isBooked, isAssigned, isTeacher);
        this(null, null, null, isBooked, isAssigned, isTeacher, null, null);
    }

    //public RegisteredUserCourseDomain(Long id, Long userId, Long courseId, Boolean isBooked, Boolean isAssigned, Boolean isTeacher) {
    //    this(null, null, null, isBooked, isAssigned, isTeacher, null, null);
    //}

    public RegisteredUserCourseDomain(Long id, Long userId, Long courseId, Boolean isBooked, Boolean isAssigned, Boolean isTeacher, UserEntity user, CourseEntity course) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.isBooked = isBooked;
        this.isAssigned = isAssigned;
        this.isTeacher = isTeacher;
        this.user = user;
        this.course = course;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Boolean getTeacher() {
        return isTeacher;
    }

    public void setTeacher(Boolean teacher) {
        isTeacher = teacher;
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

    public String getUserNameFull() {
        return user.getName() + " " + user.getLastName();
    }
}