package com.rotanareg.skolan.user;

import com.rotanareg.skolan.Role;

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
        System.out.println("signIn(..) >>>>>" + user.getRole() + "<<<");

        switch (user.getRole()){
            case STUDENT:
                //System.out.println("**********STU");
                return "student";   // xhtml-page to redirect to when signed in
            case TEACHER:
                //System.out.println("**********TEA");
                return "teacher";   // xhtml-page to redirect to when signed in
            case ADMIN:
                //System.out.println("**********ADM");
                return "admin";     // xhtml-page to redirect to when signed in
        }
        return "";                  // should never happen, but redirects to the default xhtml-page
    }

    public String signOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        //return "index?faces-redirect=true";
        return "";
    }

    public String save(User user) {
        userService.saveUser(user);
        currentUser = user;

        //System.out.println("save(..) >>>>>"+user.getRole()+"<<<");

        return "index";
    }
}


