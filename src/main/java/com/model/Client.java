package com.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;
    @Column
    private String address;

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String pin;

    private List<Count> counts = new ArrayList<>();

    public Client(){}

    public Client(String name, String address, String login, String password, String pin, Count count) {
        this.name = name;
        this.address = address;
        this.login = login;
        this.password = password;
        this.pin = pin;

        counts.add(count);
    }


    public static List<Count> getCounts() { return counts; }
    public static void setCounts(List<Count> counts) { Client.counts = counts; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }


    @Override
    public String toString() {
        StringBuffer allCounts = null;

        for(Count count : counts) {
            allCounts.append(count.toString());
        }

        return name + "\n" + login + "\n" + address + allCounts.toString();
    }
}
