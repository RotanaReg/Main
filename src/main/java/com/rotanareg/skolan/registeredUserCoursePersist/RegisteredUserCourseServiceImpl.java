package com.rotanareg.skolan.registeredUserCoursePersist;

import com.rotanareg.skolan.coursePersist.CourseServiceImpl;
import com.rotanareg.skolan.domains.Course;
import com.rotanareg.skolan.domains.RegisteredUserCourseDomain;
import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.userPersist.UserServiceImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Stateless
public class RegisteredUserCourseServiceImpl implements RegisteredUserCourseService {
    @PersistenceContext
    EntityManager em;

    List<RegisteredUserCourseDomain> rucd;

    private List<RegisteredUserCourseDomain> populateList() {
        if (rucd.isEmpty()) {
            rucd = new ArrayList<>();
            List<Course> courses = new CourseServiceImpl().getCourses();
            List<User> users = new UserServiceImpl().getUsers();
            new UserServiceImpl().getUsers();
            for (Course c : courses) {
                for (User u : users) {
                    RegisteredUserCourseDomain ruc = new RegisteredUserCourseDomain(u.getId(), u.getId(), c.getId(), true, new Random().nextBoolean(), null, null, null);
                    rucd.add(ruc);
                }
            }
        }
        return rucd;
    }

        /*
    @Override
    public List<AttendanceDomain> getAttendance() {
        // get list for all courses and users
        List<AttendanceEntity> attendance = em.createNamedQuery("selectAllAttendance").getResultList();

        // test so the list is not empty
        if (!attendance.isEmpty()) {
            // return new list of AttendanceDomain objects
            return attendance.stream().
                    map(u -> new AttendanceDomain(
                            u.getId(), u.getUser().getId(), u.getCourse().getId(), u.getSqlDate(), u.isHasAttended())).
                    collect(Collectors.toList());
        } else {
            // If attendance was empty, return an empty AttendanceDomain List
            return new ArrayList<AttendanceDomain>();
        }
    }
    */

    @Override
    public List<RegisteredUserCourseDomain> getRegisteredUserCourses() {
        //return populateList();
        List<RegisteredUserCourseEntity> entityList = em.createNamedQuery("selectAllRegisteredUserCourse").getResultList();

        // test so the list is not empty
        if (!entityList.isEmpty()) {
            return entityList.stream().
                    map(u -> new RegisteredUserCourseDomain(
                            //RegisteredUserCourseDomain(Long id, Long userId, Long courseId, Boolean isBooked, Boolean isAssigned, Boolean isTeacher)
                            u.getId(), u.getUserId(), u.getCourseId(), u.isBooked(), u.isAssigned(), u.isTeacher(), u.getPerson(), u.getCourse())).
                            collect(Collectors.toList());
        }

        return new ArrayList<RegisteredUserCourseDomain>();
    }

    @Override
    public List<RegisteredUserCourseDomain> byUserId(Long userId) {
        // return a list of RegisteredUserCourses for one user
        List<RegisteredUserCourseDomain> reguc = new ArrayList<>();
        for (RegisteredUserCourseDomain r : populateList())
            if (r.getUserId()==userId)
                reguc.add(r);
        return reguc;
    }

    @Override
    public List<RegisteredUserCourseDomain> byCourseId(Long courseId) {
        // return a list of RegisteredUserCourses for one course
        List<RegisteredUserCourseDomain> reguc = new ArrayList<>();
        for (RegisteredUserCourseDomain r : populateList())
            if (r.getCourseId()==courseId)
                reguc.add(r);
        return reguc;
    }
}
