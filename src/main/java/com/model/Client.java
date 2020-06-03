package com.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table
@Getter @Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @ManyToMany
    private List<Count> counts;

    @Column
    @OneToOne()
    private User user;


    public Client() { }

    public Client(User user, List<Count> counts) {
        this.user = user;
        this.counts = counts;
    }
}
