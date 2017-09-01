package com.rotanareg.skolan.userPersist;

import com.rotanareg.skolan.Role;
import com.rotanareg.skolan.domains.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;



@Stateless
public class UserServiceImpl implements UserService{
    @PersistenceContext
    EntityManager em;

    @Override
    public void addUser(User user) {
        UserEntity u = new UserEntity(user.getName(),user.getLastName(),user.getRole(),user.getPassWord());
        em.persist(u);

    }

    @Override
    public void updateUser(User user) {
        UserEntity u = em.find(UserEntity.class,user.getId());
        u.setName(user.getName());
        u.setLastName(user.getLastName());
        u.setRole(user.getRole());
        em.merge(u);
    }

    @Override
    public void removeUser(Long id) {
        UserEntity u = em.find(UserEntity.class, id);
        em.remove(u);
    }

    @Override
    public User getUser(Long id) {
        UserEntity u = em.find(UserEntity.class, id);
        User ud = new User(u.getId(),u.getName(),u.getLastName(),u.getRole(),u.getPassWord());
        return ud;
    }
    @Override
    public List<User> getUsers() {
       List<UserEntity> userEntityList = em.createNamedQuery("selectAllUsers").getResultList();
       if (userEntityList.isEmpty()){
           UserEntity a = new UserEntity("Nils","Gerstner",Role.STUDENT,"1234");
           em.persist(a);
           UserEntity b = new UserEntity("Jasna","Nilsson-Milkic",Role.STUDENT,"1234");
           em.persist(b);
           UserEntity c = new UserEntity("Moustafa", "Almehyo",Role.TEACHER,"1234");
           em.persist(c);
           UserEntity d = new UserEntity("Marko","Seppänen",Role.ADMIN,"1234");
           em.persist(d);
       }
       return userEntityList.stream().
           map(u->new User(u.getId(),u.getName(),u.getLastName(),u.getRole(),u.getPassWord())).collect(Collectors.toList());
    }

    @Override
    public List<User> getUserContaining(String filter) {
        List<UserEntity> userEntityList = em.createNamedQuery("selectSomeUsers").setParameter("filt",filter).getResultList();

        return userEntityList.stream().
                map(c->new User(c.getId(),c.getName(),c.getLastName(),c.getRole(),c.getPassWord())).
                collect(Collectors.toList());
    }
}
