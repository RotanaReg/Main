package com.rotanareg.skolan.domains;

import com.rotanareg.skolan.registeredUserCoursePersist.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Nils Gerstner on 8/20/17.
 */

public class Course implements Serializable{
    private long id;
    private String courseTitle;
    private String description;
    private String courseCode;
    private List<RegisteredUserCourseEntity> persons;


    public Course(String courseTitle, String description, String courseCode){
        this.courseTitle = courseTitle;
        this.description = description;
        this.courseCode = courseCode;
    }

    public Course(long id, String courseTitle, String description, String courseCode){
        this.id = id;
        this.courseTitle = courseTitle;
        this.description = description;
        this.courseCode = courseCode;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setPersons(List<RegisteredUserCourseEntity> persons) {
        this.persons = persons;
    }

    @Override
    public String toString(){
        final StringBuilder sbc = new StringBuilder("CourseEntity{");
        sbc.append("id=").append(id);
        sbc.append(", courseCode='").append(courseCode).append('\'');
        sbc.append(", courseTitle='").append(courseTitle).append('\'');
        sbc.append(", description='").append(description).append('\'');
        sbc.append('}');
        return sbc.toString();
    }
}
