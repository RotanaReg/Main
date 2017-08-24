package com.rotanareg.skolan.userPersist;

import com.rotanareg.skolan.domains.User;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Local
public interface UserService {

    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    User getUser(Long id);
    List<User> getUser();
    public List<User> getUserContaining(String filter);
}
