package com.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Table
@Getter @Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private Date enterTime;


    public User() { }

    public User(String name, String login, String password, Date enterTime) {
        this.login = login;
        this.password = password;
        this.enterTime = enterTime;
    }
}
