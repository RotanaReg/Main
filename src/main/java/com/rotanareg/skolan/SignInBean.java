package com.rotanareg.skolan;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.userPersist.UserService;
import com.rotanareg.skolan.userPersist.UserServiceImpl;

import java.util.List;

/**
 * Created by Nils Gerstner on 2017-09-04.
 */

@ManagedBean
@SessionScoped
public class SignInBean {
    private Long user;
    private String userName;
    private String userPassword;
    private boolean loggedIn;
    private User currentUser;
    @Inject
    private UserService userService;

    public SignInBean() {}
    public SignInBean(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean logIn(){
        List<User> user = userService.getUserContaining(userName);

        if(!user.isEmpty()) {
            if (user.get(0).getPassWord().equals(userPassword)) {
                User tempUser = user.get(0);
                this.user = tempUser.getId();
                System.out.println("USER " + tempUser.getLastName() + " is logged in? " + loggedIn);
                this.currentUser = new User(tempUser.getId(),tempUser.getName(),tempUser.getLastName(),tempUser.getRole(),tempUser.getPassWord());
                this.loggedIn = true;
                return true;
            }
        }
        System.out.println(user.size() + " FALSE !@#$% Penis");
        return false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
