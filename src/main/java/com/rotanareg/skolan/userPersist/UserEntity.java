package com.rotanareg.skolan.userPersist;

import javax.persistence.*;

import com.rotanareg.skolan.attendancePersist.AttendanceEntity;
import com.rotanareg.skolan.registeredUserCoursePersist.*;
import com.rotanareg.skolan.Role;
import com.rotanareg.skolan.coursePersist.CourseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Person")
@NamedQueries({
        @NamedQuery(name="selectAllUsers",query="SELECT u FROM UserEntity u"),
        @NamedQuery(name="selectSomeUsers",query="SELECT t FROM UserEntity t WHERE LOCATE(:filt,t.name) >0 "),
        @NamedQuery(name="selectUserById",query = "SELECT i FROM UserEntity i WHERE i.id = :filt")
})
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING) 
    private Role role; 
    private String name;
    private String lastName;
    private String passWord;

    @OneToMany(mappedBy = "user")
    private List<RegisteredUserCourseEntity> courses;

    @OneToMany
    private List<AttendanceEntity> attendedCourses;

    public UserEntity() {
    }

    public UserEntity(String name, String lastName, Role role, String passWord) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.passWord = passWord;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }

    public List<RegisteredUserCourseEntity> getCourses() {
        return courses;
    }

    public void addCourse (CourseEntity course, boolean isTeacher) {
        RegisteredUserCourseEntity entity = new RegisteredUserCourseEntity();
        if (this.getRole() == Role.ADMIN) {
            System.out.println("Nor TEACHER or STUDENT; not added!");
        } else {
            if (isTeacher && this.getRole() == Role.TEACHER)
                entity.setTeacher(true);
            else if (!isTeacher && this.getRole() != Role.STUDENT)
                entity.setTeacher(false);
            entity.setUser(this);
            entity.setCourse(course);
            entity.setUserId(this.getId());
            entity.setCourseId(course.getId());
            if (this.courses == null)
                this.courses = new ArrayList<>();
            this.courses.add(entity);
        }
    }
}
