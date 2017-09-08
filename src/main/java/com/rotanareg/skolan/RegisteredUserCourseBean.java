package com.rotanareg.skolan;

import com.rotanareg.skolan.domains.RegisteredUserCourseDomain;
import com.rotanareg.skolan.registeredUserCoursePersist.RegisteredUserCourseService;

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
    RegisteredUserCourseService rucService;

    public List<RegisteredUserCourseDomain> getRegUserCourses(){
        return rucService.getRegisteredUserCourses();
    }
    public List<RegisteredUserCourseDomain> getRegUserCoursesByUser(Long userId){
        return rucService.byUserId(userId);
    }
    public List<RegisteredUserCourseDomain> getRegUserCoursesByCourse(Long courseId){
        return rucService.byCourseId(courseId);
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

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public Boolean getAssigned() {
        return isAssigned;
    }

    public void setAssigned(Boolean assigned) {
        isAssigned = assigned;
    }

    public Boolean getTeacher() {
        return isTeacher;
    }

    public void setTeacher(Boolean teacher) {
        isTeacher = teacher;
    }
    //    public void add userCourse(){
//            rucService.
//    }

//    @EJB
//    UserService personService;
//
//    public String addPerson(){
//        if (getId()==null)
//            personService.(new PersonDomain(getFirstname(),getLastname()));
//        else
//            personService.updatePerson(new PersonDomain(getId(),getFirstname(),getLastname()));
//
//        setId(null);
//        setFirstname("");
//        setLastname("");
//        return "assign_user";
//    }
//    public String editPerson(Long id){
//        PersonDomain personDomain = personService.getPerson(id);
//        setId(personDomain.getId());
//        setFirstname(personDomain.getFirstName());
//        setLastname(personDomain.getLastName());
//        return "person";
//    }
//    public String removePerson(Long id){
//        personService.removePerson(id);
//        return "person";
//    }
//    public List<PersonDomain> getPersons(){
//        return personService.getPersons();
//    }
//    public List<PersonDomain> getPersonsFilter(){
//        if (myFilter==null || myFilter.equals(""))
//            return personService.getPersons();
//        else
//            return personService.getPersonsFirtsNameContain(myFilter);
//    }
//
//    public String getSubmitButtonLabel(){
//        if (id==null)
//            return "Add";
//        else
//            return "Update";
//    }
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getMyFilter() {
//        return myFilter;
//    }
//
//    public void setMyFilter(String myFilter) {
//        this.myFilter = myFilter;
//    }
//
}
