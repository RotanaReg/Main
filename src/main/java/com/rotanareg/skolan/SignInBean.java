package com.rotanareg.skolan;

import com.rotanareg.skolan.domains.User;
import com.rotanareg.skolan.userPersist.UserService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Nils Gerstner on 2017-09-04.
 */

@ManagedBean
@SessionScoped
public class SignInBean {

    private String userName;
    private String userPassword;
    private User currentUser = null;
    @Inject
    private UserService userService;

    public SignInBean() {}

    public String logIn(){
        userService.getUsers();
        List<User> user = userService.getUserContaining(userName);

        if(!user.isEmpty()) {
            if (user.get(0).getPassWord().equals(userPassword)) {
                User tempUser = user.get(0);
                System.out.println("USER " + tempUser.getLastName() + " is logged in? " + this.isLoggedIn());
                this.currentUser = new User(tempUser.getId(),tempUser.getName(),tempUser.getLastName(),tempUser.getRole(),tempUser.getPassWord());
                return this.currentUser.getRole().toString();
            }
        }
        System.out.println(user.size() + " FALSE !@#$% Penis");
        return "false";
    }

    public String logOut(){
        userName = null;
        userPassword = null;
        currentUser = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "index?faces-redirect=true";
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

    public boolean isLoggedIn() {
        if (currentUser != null)
            return true;
        else
            return false;
    }
}
