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
    private Long userId;
    private Long courseId;
    private Date date;
    private boolean hasAttended;

    @EJB
    AttendanceService attendanceService;

    public String addCourse() {
        if (getId()==null)
            attendanceService.addAttendance(new AttendanceDomain(userId,courseId,date,hasAttended));
        else
            attendanceService.addAttendance(new AttendanceDomain(id,userId,courseId,date,hasAttended));
        return "attendance";
    }

    public List<AttendanceDomain> getAttendances() {
        return attendanceService.getAttendance();
    }
    public List<AttendanceDomain> getAttendancesByUser(Long userId){
        return attendanceService.getAttendanceByUser(userId);
    }
    public List<AttendanceDomain> getAttendanceByCourse(Long courseId){
        return attendanceService.getAttendanceByCourse(courseId);
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }
}


