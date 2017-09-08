package com.rotanareg.skolan.coursePersist;

import com.rotanareg.skolan.AttendanceBean;
import com.rotanareg.skolan.attendancePersist.AttendanceEntity;
import com.rotanareg.skolan.registeredUserCoursePersist.*;
import com.rotanareg.skolan.Role;
import com.rotanareg.skolan.userPersist.UserEntity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "Course")
@NamedQueries({
        @NamedQuery(name="selectCourses",query="SELECT a FROM CourseEntity a"),
        @NamedQuery(name="selectAllCourses",query="SELECT c FROM RegisteredUserCourseEntity c"),
        @NamedQuery(name="selectSomeCourses",query="SELECT t FROM CourseEntity t WHERE LOCATE(:filt,t.courseTitle) >0 "),
        @NamedQuery(name = "selectCourseById",query = "SELECT i FROM CourseEntity i WHERE i.id = :filt")
})
public class CourseEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseTitle;
    @Column(length = 10000)
    private String description;
    private String courseCode;

    @OneToMany(mappedBy="course")
    private List<RegisteredUserCourseEntity> users;

    @OneToMany
    private List<AttendanceEntity> attendedStudent;

    public CourseEntity() {
    }

    public CourseEntity(String courseTitle, String description, String courseCode) {
        this.courseTitle = courseTitle;
        this.description = description;
        this.courseCode = courseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public List<RegisteredUserCourseEntity> getUsers() {
        return users;
    }

    public void addPerson (UserEntity user, boolean isTeacher) {
        RegisteredUserCourseEntity entity = new RegisteredUserCourseEntity();
        if (user.getRole() == Role.ADMIN) {
            System.out.println("Nor TEACHER or STUDENT; not added!");
        } else {
            if (isTeacher && user.getRole() == Role.TEACHER)
                entity.setTeacher(true);
            else if (!isTeacher && user.getRole() != Role.STUDENT)
                entity.setTeacher(false);
            entity.setUser(user);
            entity.setCourse(this);
            entity.setUserId(user.getId());
            entity.setCourseId(this.getId());
            if (this.users == null)
                this.users = new ArrayList<>();
            this.users.add(entity);
        }
    }

}
