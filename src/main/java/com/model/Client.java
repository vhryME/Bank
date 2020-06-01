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


    public Client() { }

    public Client(List<Count> counts) {
        this.counts = counts;
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public List<Count> getCounts() { return counts; }
    public void setCounts(List<Count> counts) { this.counts = counts; }
}
