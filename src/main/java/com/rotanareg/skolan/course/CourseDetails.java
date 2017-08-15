package com.rotanareg.skolan.course;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CourseDetails implements Serializable{
	 private static final long serialVersionUID = 1L;
	 
	  @Inject
	   private CourseService courseService;
	   
	    private long courseId;
		
		private Course course;
		
	public long getCourseId() {
			return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public void onload() {
        course = courseService.getCourse(courseId);
    }

    //public course getCourse() {
    //    return course;
    //}
}