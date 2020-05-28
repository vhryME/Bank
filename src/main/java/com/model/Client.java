package com.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String name;
    private String address;

    private String login;
    private String password;
    private String pin;

    private double count;
    private String currency;

    public Client(String id, String name, String address, String login, String password, String pin, double count, String currency) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.login = login;
        this.password = password;
        this.pin = pin;
        this.count = count;
        this.currency = currency;
    }
}
