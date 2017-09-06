package com.rotanareg.skolan.userPersist;

import com.rotanareg.skolan.domains.User;

import javax.ejb.Local;
import java.util.List;


@Local
public interface UserService {

    // (C)reate
    void addUser(User user);

    // (R)eade
    User getUser(Long id);
    List<User> getUsers();
    List<User> getUserContaining(String filter);

    // (U)pdate
    void updateUser(User user);

    // (D)elete
    void removeUser(Long id);

}
