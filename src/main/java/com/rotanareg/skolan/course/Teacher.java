package com.rotanareg.skolan.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name= "T_TEACHER")
public class Teacher {

   // Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column (name = "e-mail_address", length = 100)
    private String eMail;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column (name = "phone_number", length = 100)
    private String phoneNumber;


   // Constructors,

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String eMail, Date dateOfBirth, String phoneNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
    }

   // Getters och Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String geteMail () {return eMail;}

    public void seteMail (String eMail) {this.eMail = eMail;}

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    //hashcode, equals & toString

    @Override
    public String toString() {
        final StringBuilder sbt = new StringBuilder("Teacher{");
        sbt.append("id=").append(id);
        sbt.append(", firstName='").append(firstName).append('\'');
        sbt.append(", lastName='").append(lastName).append('\'');
        sbt.append(", eMail='").append(eMail).append('\'');
        sbt.append(", dateOfBirth=").append(dateOfBirth);
        sbt.append(", phoneNumber=").append(phoneNumber);
        sbt.append('}');
        return sbt.toString();

    }
}
