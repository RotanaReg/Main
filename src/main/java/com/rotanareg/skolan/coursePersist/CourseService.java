package com.rotanareg.skolan.coursePersist;

import java.util.List;
import javax.ejb.Local;
import com.rotanareg.skolan.domains.Course;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Local
public interface CourseService {

    void addCourse(Course course);
    void updateCourse(Course course);
    void removeCourse(Long id);
    Course getCourse(Long id);
    List<Course> getCourses();
    public List<Course> getCoursesContaining(String filter);
}
