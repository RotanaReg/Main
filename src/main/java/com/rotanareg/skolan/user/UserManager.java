package com.rotanareg.skolan.user;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserManager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserService userService;

    private User currentUser;

    public boolean isSignedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public String signIn(String username, String password) {
        User user = userService.getUser(username);
        if (user == null || !password.equals(user.getPassword())) {
            return "signIn";
        }
        currentUser = user;
        return "admin";
    }

    public String signOut() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();


        return "first?faces-redirect=true";
    }

    public String save(User user) {
        userService.saveUser(user);
        currentUser = user;
        return "first";
    }
}


