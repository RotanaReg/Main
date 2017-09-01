package com.rotanareg.skolan.coursePersist;

import com.rotanareg.skolan.domains.Course;

import javax.ejb.Local;
import java.util.List;


@Local
public interface CourseService {

    void addCourse(Course course);
    void updateCourse(Course course);
    void removeCourse(Long id);
    Course getCourse(Long id);
    List<Course> getCourses();
    public List<Course> getCoursesContaining(String filter);
}
