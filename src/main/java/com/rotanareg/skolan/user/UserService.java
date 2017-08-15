package com.rotanareg.skolan.user;

public interface UserService {
    // get information om användare
    User getUser(String username);

    // spara information om användare
    void saveUser(User user);
}
