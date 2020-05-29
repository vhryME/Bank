package com.model;


import lombok.Data;

import javax.persistence.*;


@Entity
@Table
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String address;

    private String login;
    private String password;
    private String pin;

    private double count;
    private String currency;


    public Client(){}

    //Count = 0 because that will be filed only after registred
    public Client(String name, String address, String login, String password, String pin, String currency) {
        this.name = name;
        this.address = address;
        this.login = login;
        this.password = password;
        this.pin = pin;
        this.currency = currency;
    }
}
