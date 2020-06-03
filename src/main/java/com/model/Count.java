package com.model;


import javax.persistence.*;


@Table
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


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }

    public Currency getCurrency() { return currency; }
    public void setCurrency(Currency currency) { this.currency = currency; }

    public Integer getPin() { return pin; }
    public void setPin(Integer pin) { this.pin = pin; }


    @Override
    public String toString() {
        return money + " " + currency;
    }
}
