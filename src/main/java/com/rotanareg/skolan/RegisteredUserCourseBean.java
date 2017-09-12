package com.rotanareg.skolan;

import com.rotanareg.skolan.domains.AttendanceDomain;
import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.registeredUserCoursePersist.*;
import com.rotanareg.skolan.domains.RegisteredUserCourseDomain;
import com.rotanareg.skolan.userPersist.UserEntity;
import com.rotanareg.skolan.userPersist.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class RegisteredUserCourseBean {
    private Long id;
    private Long userId;
    private Long courseId;
    private Boolean isBooked;   // True när elev registrerat/gjort_instresse-anmälan för en kurs.
    private Boolean isAssigned; // True när Admin anslutit en elev/lärare.
    private Boolean isTeacher;  // Om användaren är en elev.

    @EJB
    RegisteredUserCourseService service;

    @EJB
    UserService userService;

    public RegisteredUserCourseBean(){
        ;
    }

    public List<RegisteredUserCourseDomain> getRegisteredUserCourses() {
        return service.getRegisteredUserCourses();
    }

    //public String getUserNameFull(long userId){
    public String getUserNameFull(){
        User personDomain = userService.getUser(userId);
        //setId(personDomain.getId());
        //setFirstname(personDomain.getFirstName());
        return personDomain.getName() + " " + personDomain.getLastName();
    }

    public String addRegisteredUserCourse(){
        if (getId()==null) {
            //(Long id, Boolean isBooked, Boolean isAssigned, Boolean isTeacher, UserEntity user, CourseEntity course)
            //service.addPerson(new RegisteredUserCourseDomain(getFirstname(), getLastname()));
            service.addItem(new RegisteredUserCourseDomain(getUserId(), getCourseId(), getBooked(), getAssigned(), getTeacher(), null, null));               // NOTE: two last args null at the moment???
        }else {
            service.updateItem(new RegisteredUserCourseDomain(getId(), getBooked(), getAssigned(), getTeacher(), null, null));  // NOTE: two last args null at the moment???
        }

        setId(null);
        //setFirstname("");
        //setLastname("");
        return "admin";
    }

    /*
    public String editPerson(Long id){
        PersonDomain personDomain = personService.getPerson(id);
        setId(personDomain.getId());
        setFirstname(personDomain.getFirstName());
        setLastname(personDomain.getLastName());
        return "person";
    }
    public String removePerson(Long id){
        personService.removePerson(id);
        return "person";
    }
    public List<PersonDomain> getPersons(){
        return personService.getPersons();
    }
    public List<PersonDomain> getPersonsFilter(){
        if (myFilter==null || myFilter.equals(""))
            return personService.getPersons();
        else
            return personService.getPersonsFirtsNameContain(myFilter);
    }

    public String getSubmitButtonLabel(){
        if (id==null)
            return "Add";
        else
            return "Update";
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public boolean getBooked() {
        if(isBooked==null) return false;
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public boolean getAssigned() {
        if(isAssigned==null) return false;
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    public boolean getTeacher() {
        if(isTeacher==null) return false;
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }

    //public UserEntity getUser(){
   //     return userService.getUser(userId).;
   // }

/*
    public String getMyFilter() {
        return myFilter;
    }

    public void setMyFilter(String myFilter) {
        this.myFilter = myFilter;
    }
    */
}
