package com.rotanareg.skolan.course;
import java.util.List;

public interface CourseService {
	List<Course> getMostStudiedCourses ();
	Course getCourse (long id);
}
