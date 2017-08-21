package com.rotanareg.skolan.userManager;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class SignIn {

    @Inject
    private UserManager userManager;

    @Pattern(regexp = "[A-Za-z0-9]{2,20}", message = "Användarnamnet skall innehålla bara bokstäver och siffror samt vara långt mellan 2 och 20 tecken.")
    private String username;

    @Size(min = 8, message = "Ditt password måste innehålla minst 8 tecken.")
    private String password;

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

    public String submit() {
        return userManager.signIn(username, password);
    }
}
