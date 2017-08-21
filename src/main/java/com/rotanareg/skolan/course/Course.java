package com.rotanareg.skolan.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "T_COURSE")
public class Course {

//attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String courseCode;

    @Column(name = "course_title", length = 500)
    private String courseTitle;

    @Column(name = "course_description",length = 10000)
    private String description;

    @Column(name = "teacher_first_name",length = 50)
    private String teacherFirstName;

    @Column(name = "teacher_last_name",length = 50)
    private String teacherLastName;


    //constructors
    public Course() {
    }
        public Course (Long id) {
        this.id = id;
        }
        public Course (Long id, String courseCode, String courseTitle, String description, String teacherFirstName, String teacherLastName ){
        this.id = id;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.description = description;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
    }

        //getters och setters
            public Long getId() {
                return id;
            }

            public void setId(Long id) {
                this.id = id;
            }

            public String getCourseCode() {
                return courseCode;
            }

            public void setCourseCode(String courseCode) {
                this.courseCode = courseCode;
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

            public String getTeacherFirstName() {
                return teacherFirstName;
            }

            public void setTeacherFirstName(String teacherFirstName) {
                this.teacherFirstName = teacherFirstName;
            }

            public String getTeacherLastName () {return teacherLastName;}

            public void setTeacherLastName (String teacherLastName) {this.teacherLastName = teacherLastName;}
// hashcode, equals och toString
    @Override
    public String toString(){
            final StringBuilder sbc = new StringBuilder("Course{");
            sbc.append("id=").append(id);
            sbc.append(", courseCode='").append(courseCode).append('\'');
            sbc.append(", courseTitle='").append(courseTitle).append('\'');
        sbc.append(", description='").append(description).append('\'');
        sbc.append(", teacherFirstName='").append(teacherFirstName).append('\'');
        sbc.append(", teacherLastName='").append(teacherLastName).append('\'');
        sbc.append('}');
        return sbc.toString();
    }
    }



