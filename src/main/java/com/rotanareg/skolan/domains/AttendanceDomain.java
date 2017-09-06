/******************************
 * POJO - Mellanskikt mellan AttendanceBean (vanlig böna) och EJB (Enterprise-böna), samt JPA (transformerings-klass).
 * Inkapslings-klass (hjälp-klass) för att underlätta transporten av data mellan objekt.
 ******************************/

package com.rotanareg.skolan.domains;

import com.rotanareg.skolan.coursePersist.CourseEntity;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Marko K. Seppänen.
 */
public class AttendanceDomain {

    private Long id;

    private Long userId;

    private Long courseId;

    private Date sqlDate;           //yyyy-mm-dd

    private boolean hasAttended;

    public AttendanceDomain(Long userId, Long courseId, Date sqlDate, boolean hasAttended) {
        this.userId = userId;
        this.courseId = courseId;
        this.sqlDate = sqlDate;
        this.hasAttended = hasAttended;
    }

    public AttendanceDomain(Long id, Long userId, Long courseId, Date sqlDate, boolean hasAttended) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.sqlDate = sqlDate;
        this.hasAttended = hasAttended;
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

    public Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public boolean isHasAttended() {
        return hasAttended;
    }

    public void setHasAttended(boolean hasAttended) {
        this.hasAttended = hasAttended;
    }
}
