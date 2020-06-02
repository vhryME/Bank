package com.model;


import javax.persistence.*;
import java.util.List;


@Table
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


    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<Count> getCounts() { return counts; }
    public void setCounts(List<Count> counts) { this.counts = counts; }
}
