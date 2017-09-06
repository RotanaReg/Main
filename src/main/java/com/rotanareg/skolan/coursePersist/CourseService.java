package com.rotanareg.skolan.coursePersist;

import com.rotanareg.skolan.domains.Course;

import javax.ejb.Local;
import java.util.List;


@Local
public interface CourseService {

    // (C)reate
    void addCourse(Course course);

    // (R)eade
    Course getCourse(Long id);
    List<Course> getCourses();
    List<Course> getCoursesContaining(String filter);

    // (U)pdate
    void updateCourse(Course course);

    // (D)elete
    void removeCourse(Long id);

}
