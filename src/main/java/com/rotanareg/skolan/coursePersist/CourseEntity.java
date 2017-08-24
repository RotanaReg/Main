package com.rotanareg.skolan.coursePersist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Created by Solidbeans on 2017-03-20.
 */
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
}
