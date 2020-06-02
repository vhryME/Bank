package com.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


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


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Date getEnterTime() { return enterTime; }
    public void setEnterTime(Date enterTime) { this.enterTime = enterTime; }
}
