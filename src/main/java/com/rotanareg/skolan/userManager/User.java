package com.rotanareg.skolan.userManager;

import com.rotanareg.skolan.Role;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private Role role;
    private List<Role> rolesList;

    public User() {
        rolesList = new ArrayList();
        rolesList.add(Role.STUDENT);
        rolesList.add(Role.TEACHER);
        rolesList.add(Role.ADMIN);
        role = Role.STUDENT;     // set the first role as default
    }

    @Pattern(regexp = "[A-Za-z0-9]{2,20}", message = "Skriv in ditt användarnamn mellan 2 och 20 tecken långt, innehållande bokstäver och siffror")
    private String username;

    @Size(min = 8, message = "Ditt pasword måste innehålla minst 8 tecken")
    private String password;

    @Size(min = 1, max = 30, message = "Skriv in ditt Förnamn mellan 1 och 30 tecken långt.")
    private String firstName;

    @Size(min = 1, max = 30, message = "Skriv in ditt Efternamn mellan 1 och 30 tecken långt.")
    private String lastName;

    @ValidEmailAddress
    private String emailAddress;

    private PhoneNumber phoneNumber;

    @Past(message = "Ditt födelsedatum måste vara i dåtid .")
    private Date birthDate;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Role> getRolesList() {
        return rolesList;
    }

}


