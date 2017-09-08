package com.rotanareg.skolan.domains;



public class RegisteredUserCourseDomain {

    private Long userId;

    private Long courseId;

    private Boolean isBooked;   // True när elev registrerat/gjort_instresse-anmälan för en kurs.

    private Boolean isAssigned; // True när Admin anslutit en elev/lärare.

    private Boolean isTeacher;  // Om användaren är en elev.



    public RegisteredUserCourseDomain(boolean isBooked, boolean isAssigned) {

        this(null, null, isBooked, isAssigned, null);

    }



    public RegisteredUserCourseDomain(boolean isBooked, boolean isAssigned, boolean isTeacher) {

        this(null, null, isBooked, isAssigned, isTeacher);

    }



    public RegisteredUserCourseDomain(Long userId, Long courseId, Boolean isBooked, Boolean isAssigned, Boolean isTeacher) {

        this.userId = userId;

        this.courseId = courseId;

        this.isBooked = isBooked;

        this.isAssigned = isAssigned;

        this.isTeacher = isTeacher;

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



    public boolean isTeacher() {

        return isTeacher;

    }



    public void setTeacher(boolean teacher) {

        isTeacher = teacher;

    }

}