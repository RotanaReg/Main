package com.rotanareg.skolan.userPersist;

import javax.persistence.*;
import com.rotanareg.skolan.AssociatedPersist.CourseUserAssociation;
import com.rotanareg.skolan.Role;
import com.rotanareg.skolan.coursePersist.CourseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Entity
@Table(name = "Person")
@NamedQueries({
        @NamedQuery(name="selectAllUsers",query="SELECT u FROM UserEntity u"),
        @NamedQuery(name="selectSomeUsers",query="SELECT t FROM UserEntity t WHERE LOCATE(:filt,t.name) >0 ")
})
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING) 
    private Role role; 
    private String name;
    private String lastName;
    private String passWord;

    @OneToMany(mappedBy = "person")
    private List<CourseUserAssociation> courses;

    public UserEntity() {
    }

    public UserEntity(String name, String lastName, Role role, String passWord) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.passWord = passWord;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public List<CourseUserAssociation> getCourses() {
        return courses;
    }

    public void addCourse (CourseEntity course, boolean isTeacher) {
        CourseUserAssociation courseUserAssociation = new CourseUserAssociation();
        if (this.getRole() == Role.ADMIN) {
            System.out.println("Nor TEACHER or STUDENT; not added!");
        } else {
            if (isTeacher && this.getRole() == Role.TEACHER)
                courseUserAssociation.setTeacher(true);
            else if (!isTeacher && this.getRole() != Role.STUDENT)
                courseUserAssociation.setTeacher(false);
            courseUserAssociation.setPerson(this);
            courseUserAssociation.setCourse(course);
            courseUserAssociation.setPersonId(this.getId());
            courseUserAssociation.setCourseId(course.getId());
            if (this.courses == null)
                this.courses = new ArrayList<>();
            this.courses.add(courseUserAssociation);
        }
    }


//    public List<CourseUserAssociation> getPersons() {
//        return persons;
//    }
//
//    public void addPerson (UserEntity person, boolean isTeacher){
//        CourseUserAssociation courseUserAssociation = new CourseUserAssociation();
//        courseUserAssociation.setPerson(person);
//        courseUserAssociation.setCourse(this);
//        courseUserAssociation.setPersonId(person.getId());
//        courseUserAssociation.setCourseId(this.getId());
//        courseUserAssociation.setTeacher(isTeacher);
//        if(this.persons == null)
//            this.persons = new ArrayList<>();
//        this.persons.add(courseUserAssociation);
//        person.getCourses().add(courseUserAssociation);
//    }
}
