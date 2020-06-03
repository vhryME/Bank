package com.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Table
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private List<Count> counts;

    @Column
    private User user;


    public Client() { }

    public Client(User user, List<Count> counts) {
        this.user = user;
        this.counts = counts;
    }
}
