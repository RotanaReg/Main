package com.rotanareg.skolan;

import com.rotanareg.skolan.domains.AttendanceDomain;
import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.registeredUserCoursePersist.*;
import com.rotanareg.skolan.domains.RegisteredUserCourseDomain;
import com.rotanareg.skolan.userPersist.UserService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class RegisteredUserCourseBean {
    private Long userId;
    private Long courseId;
    private Boolean isBooked;   // True när elev registrerat/gjort_instresse-anmälan för en kurs.
    private Boolean isAssigned; // True när Admin anslutit en elev/lärare.
    private Boolean isTeacher;  // Om användaren är en elev.

    @EJB
    RegisteredUserCourseService service;

    @EJB
    UserService pService;

    public List<RegisteredUserCourseDomain> getRegisteredUserCourses() {
        return service.getRegisteredUserCourses();
    }

    //public String getUserNameFull(long userId){
    public String getUserNameFull(){
        User personDomain = pService.getUser(userId);
        //setId(personDomain.getId());
        //setFirstname(personDomain.getFirstName());
        return personDomain.getName() + " " + personDomain.getLastName();
    }
/*
    public String addPerson(){
        if (getId()==null)
            personService.addPerson(new PersonDomain(getFirstname(),getLastname()));
        else
            personService.updatePerson(new PersonDomain(getId(),getFirstname(),getLastname()));

        setId(null);
        setFirstname("");
        setLastname("");
        return "assign_user";
    }
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyFilter() {
        return myFilter;
    }

    public void setMyFilter(String myFilter) {
        this.myFilter = myFilter;
    }
    */
}
