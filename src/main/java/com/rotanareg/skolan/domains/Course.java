package com.rotanareg.skolan.domains;

import com.rotanareg.skolan.AssociatedPersist.CourseUserAssociation;
import com.rotanareg.skolan.userPersist.UserEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nils Gerstner on 8/20/17.
 */

public class Course implements Serializable{
    private long id;
    private String name;
    private String description;
    private String courseNr;
    private List<CourseUserAssociation> persons;

    public Course(String name, String description, String courseNr){
        this.name = name;
        this.description = description;
        this.courseNr = courseNr;
    }

    public Course(long id, String name, String description, String courseNr){
        this.id = id;
        this.name = name;
        this.description = description;
        this.courseNr = courseNr;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setPersons(List<CourseUserAssociation> persons) {
        this.persons = persons;
    }

    @Override
    public String toString(){
        final StringBuilder sbc = new StringBuilder("CourseEntity{");
        sbc.append("id=").append(id);
        sbc.append(", courseCode='").append(courseNr).append('\'');
        sbc.append(", courseTitle='").append(name).append('\'');
        sbc.append(", description='").append(description).append('\'');
        sbc.append('}');
        return sbc.toString();
    }
}
