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

    public RegisteredUserCourseDomain(){
        ;
    }

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

    //public RegisteredUserCourseDomain(Boolean isAssigned, Boolean isTeacher, UserEntity user, CourseEntity course) {
    //    this(null, null, null, null, isAssigned, isTeacher, user, course);
    //}

    public RegisteredUserCourseDomain(Long userId, Long courseId, Boolean isBooked, Boolean isAssigned, Boolean isTeacher, UserEntity user, CourseEntity course) {
        this(null, userId, courseId, isBooked, isAssigned, isTeacher, user, course);
    }

    public RegisteredUserCourseDomain(Long id, Boolean isBooked, Boolean isAssigned, Boolean isTeacher, UserEntity user, CourseEntity course) {
        this(id, null, null, isBooked, isAssigned, isTeacher, user, course);
    }

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

    public Boolean getBooked() {
        return isBooked;
    }

    public Boolean getAssigned() {
        return isAssigned;
    }

    public Boolean getTeacher() {
        return isTeacher;
    }

    public Boolean isBooked() {
        if (isBooked == null)
            isBooked = false;
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }
    public void setBooked(boolean booked) {
        isBooked = new Boolean(booked);
    }

    public Boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public Boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(Boolean teacher) {
        isTeacher = teacher;
    }
    public void setTeacher(boolean teacher) {
        isTeacher = new Boolean(teacher);
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