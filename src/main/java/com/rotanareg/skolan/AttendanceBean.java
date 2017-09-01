/******************************
 * JSF - Managed-Bean, hämta info till/från xhtml filen. (Mellan Back och Front -end.)
 ******************************/

//TODO: inkludera logik

package com.rotanareg.skolan;

import com.rotanareg.skolan.attendancePersist.*;
import com.rotanareg.skolan.domains.*;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Date;
import java.util.List;

/**
 * Created by Marko K. Seppänen.
 */
@ManagedBean
@RequestScoped
public class AttendanceBean {
    private Long id;
    //    private Course course;
//    private User user;
    private Date sqlDate;           //yyyy-mm-dd
    private boolean hasAttended;

    @EJB
    AttendanceService aService;

    public String addCourse() {
        if (getId() == null) {
            aService.addAttendance(new AttendanceDomain(getDate(), isHasAttended()));
        }else {
            // Update
//            aService.updateCourse(new AttendanceDomain(getId(), getDate(), isHasAttended()));
        }

        setId(null);
        setDate(null);
        setHasAttended(false);
        return "stats_test";
    }
/*
    public String editCourse(Long id) {
        CourseDomain courseDomain = courseService.getCourse(id);
        setId(courseDomain.getId());
        setName(courseDomain.getName());
        setCode(courseDomain.getCode());
        return "course";
    }

    public String removeCourse(Long id) {
        courseService.removeCourse(id);
        return "course";
    }
*/
    public List<AttendanceDomain> getAttendances() {
        return aService.getAttendances();
    }
/*
    public List<CourseDomain> getCoursesFilter() {
        if (myFilter == null || myFilter.equals(""))
            return courseService.getCourses();
        else
            return courseService.getCoursesNameContain(myFilter);
    }
*/
    public String getSubmitButton() {
        if (id == null)
            return "Add";
        else
            return "Update";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return sqlDate;
    }

    public void setDate(Date date) {
        this.sqlDate = date;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }

    public AttendanceService getCourseService() {
        return aService;
    }

    public void setCourseService(AttendanceService courseService) {
        this.aService = courseService;
    }
}
