package com.rotanareg.skolan.coursePersist;

import com.rotanareg.skolan.AssociatedPersist.CourseUserAssociation;
import com.rotanareg.skolan.Role;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "Course")
@NamedQueries({
        @NamedQuery(name="selectAllCourses",query="SELECT c FROM CourseEntity c"),
        @NamedQuery(name="selectSomeCourses",query="SELECT t FROM CourseEntity t WHERE LOCATE(:filt,t.name) >0 ")
})
public class CourseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @Column(length = 10000)
    private String description;
    private String courseNr;

    @OneToMany(mappedBy="course")
    private List<CourseUserAssociation> persons;

    public CourseEntity() {
    }

    public CourseEntity(String name, String description, String courseNr) {
        this.name = name;
        this.description = description;
        this.courseNr = courseNr;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseNr() {
        return courseNr;
    }

    public void setCourseNr(String courseNr) {
        this.courseNr = courseNr;
    }

    public List<CourseUserAssociation> getPersons() {
        return persons;
    }
    public void addPerson (UserEntity person, boolean isTeacher) {
        CourseUserAssociation courseUserAssociation = new CourseUserAssociation();
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
