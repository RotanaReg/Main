package com.rotanareg.skolan;

import com.rotanareg.skolan.coursePersist.CourseService;
import com.rotanareg.skolan.domains.Course;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class CoursesBean {
    private Long id;
    private String courseTitle;
    private String description;
    private String courseCode;
    @EJB
    CourseService courseService;


    public String addCourse(){
        if (getId()==null)
            courseService.addCourse(new Course(courseTitle, description, courseCode));
        else
            courseService.updateCourse(new Course(getId(),getCourseTitle(),getDescription(),getCourseCode()));

        setId(null);
        setCourseTitle("");
        setDescription("");
        setCourseCode("");
        return "course";
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

    public CourseService getCourses() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
