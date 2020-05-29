package com.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Data
public class Client {
    static List<Count> counts = new ArrayList<>();

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

    public Client(){}

    public Client(String name, String address, String login, String password, String pin, Count count) {
        this.name = name;
        this.address = address;
        this.login = login;
        this.password = password;
        this.pin = pin;

        counts.add(count);
    }


    @Override
    public String toString() {
        StringBuffer allCounts = null;

        for(Count count : counts) {
            allCounts.append(count.toString());
        }

        return name + "\n" + login + "\n" + allCounts.toString();
    }
}
