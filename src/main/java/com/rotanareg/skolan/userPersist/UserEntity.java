package com.rotanareg.skolan.userPersist;

import javax.persistence.*;
import com.rotanareg.skolan.Role;

/**
 * Created by Solidbeans on 2017-03-20.
 */
@Entity
@Table(name = "Person")
@NamedQueries({
        @NamedQuery(name="selectAllUsers",query="SELECT u FROM UserEntity u"),
        @NamedQuery(name="selectSomeUsers",query="SELECT t FROM UserEntity t WHERE LOCATE(:filt,t.name) >0 ")
})
public class UserEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING) 
    private Role role; 
    private String name;
    private String lastName;
    private String passWord;

    public UserEntity() {
    }

    public UserEntity(String name, String lastName, Role role, String passWord) {
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.passWord = passWord;
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

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPassWord() {
        return passWord;
    }
}
