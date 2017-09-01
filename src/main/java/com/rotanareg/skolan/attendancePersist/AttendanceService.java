/******************************
 * EJB - Interface för våran tjänst ("kontrakt" för varje EJB att följa om den vill stödja tjänsten för Attendance)
 ******************************/

package com.rotanareg.skolan.attendancePersist;

import com.rotanareg.skolan.domains.*;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Marko K. Seppänen.
 */
@Local
public interface AttendanceService {

    // (C)reate / add.
    void addAttendance(AttendanceDomain attendance);
/*
    // (R)ead / get.
    AttendanceDomain getAttendance(Long id);

    // (U)pdate.
    void updateAttendance(AttendanceDomain attendance);

    // (D)elete.
    void deleteAttendance(Long id);
*/

    List<AttendanceDomain> getAttendances();
/*
    public List<CourseDomain> getCoursesNameContain(String filter);
    */
}
