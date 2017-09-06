/******************************
 * EJB - Interface för våran tjänst ("kontrakt" för varje EJB att följa om den vill stödja tjänsten för Attendance)
 ******************************/

package com.rotanareg.skolan.attendancePersist;

import com.rotanareg.skolan.domains.*;

import javax.ejb.Local;
import java.util.List;


@Local
public interface AttendanceService {

    // (C)reate / add.
    void addAttendance(AttendanceDomain attendance);

    // (R)eade
    List<AttendanceDomain> getAttendanceByUser(Long userId);
    List<AttendanceDomain> getAttendanceByCourse(Long courseId);
    List<AttendanceDomain> getAttendance();

    // (U)pdate
    void updateAttendance(AttendanceDomain attendance);

    // (D)elete
    void removeAttendance(Long attendanceId);

}
