package com.rotanareg.skolan.AssociatedPersist;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;

/**
 * Created by Nils Gerstner on 2017-08-31.
 */

@Entity
@Table(name="COURSE_USER")
@IdClass(CourseUserAssociationId.class)
public class CourseUserAssociation {

    @Id
    private long courseId;
    @Id
    private long personId;
    @Column(name="IS_TEACHER")
    private boolean isTeacher;
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




//@Entity
//@Table(name="PROJ_EMP")
//@IdClass(ProjectAssociationId.class)
//public class ProjectAssociation {
//    @Id
//    private long employeeId;
//    @Id
//    private long projectId;
//    @Column(name="IS_PROJECT_LEAD")
//    private boolean isProjectLead;
//    @ManyToOne
//    @PrimaryKeyJoinColumn(name="EMPLOYEEID", referencedColumnName="ID")
//  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
//  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
//  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
//  * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
//  */
//    private Employee employee;
//    @ManyToOne
//    @PrimaryKeyJoinColumn(name="PROJECTID", referencedColumnName="ID")
//  /* the same goes here:
//  *  if this JPA model doesn't create a table for the "PROJ_EMP" entity,
//  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
//  *  @JoinColumn(name = "projectId", updatable = false, insertable = false)
//  * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
//  */
//    private Project project;
//  ...
//}
//
//
