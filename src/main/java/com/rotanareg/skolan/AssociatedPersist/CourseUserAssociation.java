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

