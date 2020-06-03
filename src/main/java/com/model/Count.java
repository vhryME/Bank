package com.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Table
@Getter @Setter
public class Count {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //In init = dollars
    @Column
    private Double money;
    @Column
    private Currency currency;
    @Column
    private Integer pin;


    public Count() {
        this.money = 0.0;
        this.currency = Currency.DOLLAR;
        this.pin = 0000;
    }

    public Count(Double money, String currency, Integer pin) {
        this.money = money;
        this.currency = Currency.DOLLAR;
        this.pin = pin;
    }


    public static double getEuro(Count count) { return count.money *= 1.11; }
    public static double getRub(Count count) { return count.money *= 0.014; }


    @Override
    public String toString() {
        return money + " " + currency;
    }
}
