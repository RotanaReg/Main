package com.rotanareg.skolan.domains;

import com.rotanareg.skolan.Role;
/**
 * Created by Nils Gerstner on 8/20/17.
 */

public class User {
    private long id;
    private String name;
    private String lastName;
    private Role role;
    private String passWord;

    public User(String name, String lastName, Role role){
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.passWord = null;
    }

    public User(long id, String name, String lastName, Role role, String passWord){
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
        this.passWord = passWord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString(){
        StringBuilder sbc = new StringBuilder("User{");
        sbc.append("id=").append(id);
        sbc.append(", name='").append(name).append('\'');
        sbc.append(", lastName='").append(lastName).append('\'');
        sbc.append(", role='").append(role.toString()).append('\'');
        sbc.append('}');
        return sbc.toString();
    }

}
