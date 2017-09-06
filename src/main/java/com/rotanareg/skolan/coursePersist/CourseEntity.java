package com.rotanareg.skolan.coursePersist;

import com.rotanareg.skolan.AttendanceBean;
import com.rotanareg.skolan.attendancePersist.AttendanceEntity;
import com.rotanareg.skolan.registeredUserCoursePersist.*;
import com.rotanareg.skolan.Role;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "Course")
@NamedQueries({
        @NamedQuery(name="selectCourses",query="SELECT a FROM CourseEntity a"),
        @NamedQuery(name="selectAllCourses",query="SELECT c FROM RegisteredUserCourseEntity c"),
        @NamedQuery(name="selectSomeCourses",query="SELECT t FROM CourseEntity t WHERE LOCATE(:filt,t.courseTitle) >0 "),
        @NamedQuery(name = "selectCourseById",query = "SELECT i FROM CourseEntity i WHERE i.id = :filt")
})
public class CourseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseTitle;
    @Column(length = 10000)
    private String description;
    private String courseCode;

    @OneToMany(mappedBy="course")
    private List<RegisteredUserCourseEntity> persons;

    @OneToMany
    private List<AttendanceEntity> attendedStudent;

    public CourseEntity() {
    }

    public CourseEntity(String courseTitle, String description, String courseCode) {
        this.courseTitle = courseTitle;
        this.description = description;
        this.courseCode = courseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<RegisteredUserCourseEntity> getPersons() {
        return persons;
    }

    public void addPerson (UserEntity person, boolean isTeacher) {
        RegisteredUserCourseEntity courseUserAssociation = new RegisteredUserCourseEntity();
        if (person.getRole() == Role.ADMIN) {
            System.out.println("Nor TEACHER or STUDENT; not added!");
        } else {
            if (isTeacher && person.getRole() == Role.TEACHER)
                courseUserAssociation.setTeacher(true);
            else if (!isTeacher && person.getRole() != Role.STUDENT)
                courseUserAssociation.setTeacher(false);
            courseUserAssociation.setPerson(person);
            courseUserAssociation.setCourse(this);
            courseUserAssociation.setPersonId(person.getId());
            courseUserAssociation.setCourseId(this.getId());
            if (this.persons == null)
                this.persons = new ArrayList<>();
            this.persons.add(courseUserAssociation);
        }
    }

}
