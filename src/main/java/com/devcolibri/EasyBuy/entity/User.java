package com.devcolibri.EasyBuy.entity;

import com.devcolibri.EasyBuy.entity.enums.UserRole;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String login;
    @Column
    private String password;

    @Column
    @Enumerated
    private UserRole userRole;



    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {

    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
