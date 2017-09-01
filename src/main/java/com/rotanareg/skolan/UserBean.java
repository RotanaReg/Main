package com.rotanareg.skolan;

import java.util.List;

import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.userPersist.*;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class UserBean {
    private Long id;
    private String name;
    private String lastName;
    private Role role;
    private String passWord;
    @EJB
    UserService userService;

    public String addUser(){
        if (getId()==null)
            userService.addUser(new User(name,lastName,role));
        else
            userService.addUser(new User(getId(),getName(),getLastName(),getRole(),getPassWord()));

        setId(null);
        setName("");
        setLastName("");
        setRole(null);
        setPassWord("");
        return "user";
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    public UserService getUsers(){
        return userService;
    }
} 
