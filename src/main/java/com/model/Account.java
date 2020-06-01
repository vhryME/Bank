package com.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
//@Getter @Setter
//Make this class -> account, create агрегат Client над this class
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String login;
    @Column
    private String password;


    public Account(){}

    public Account(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }


    public Long getId() { return id; }
    public void Long(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }


    @Override
    public String toString() {
        return name + "\n" + login + "\n";
    }
}
