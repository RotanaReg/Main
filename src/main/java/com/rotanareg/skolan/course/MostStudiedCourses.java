package com.rotanareg.skolan.course;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class MostStudiedCourses {
	
    @Inject
	 private com.rotanareg.skolan.course.CourseService courseService;
	 
	 private List<Course> courses;
	  
	 @PostConstruct
    public void initialize() {
	courses = courseService.getMostStudiedCourses ();
	}
	
    public List<Course> getCourses() {
	return courses;
    }		 
}
