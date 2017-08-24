package com.rotanareg.skolan;

import javax.ejb.EJB;

        import com.rotanareg.skolan.domains.Course;
        import com.rotanareg.skolan.coursePersist.*;

        import javax.faces.bean.ManagedBean;
        import javax.faces.bean.RequestScoped;
        import java.util.List;


@ManagedBean
@RequestScoped
public class CoursesBean {
    private Long id;
    private String name;
    private String description;
    private String courseNr;
    @EJB
    CourseService courseService;


    public String addCourse(){
        if (getId()==null)
            courseService.addCourse(new Course(name, description, courseNr));
        else
            courseService.updateCourse(new Course(getId(),getName(),getDescription(),getCourseNr()));

        setId(null);
        setName("");
        setDescription("");
        setCourseNr("");
        return "course";
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

    public CourseService getCourses() {
        return courseService;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }
}
