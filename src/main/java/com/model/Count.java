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
    private String currency;
    @Column
    private Integer pin;


    public Count() {}

    public Count(Double money, String currency, Integer pin) {
        this.money = money;
        this.currency = currency;
        this.pin = pin;
    }


    public static double getEuro(Count count) { return count.money *= 1.11; }
    public static double getRub(Count count) { return count.money *= 0.014; }


    public Double getMoney() { return money; }
    public void setMoney(Double money) { this.money = money; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public Integer getPin() { return pin; }
    public void setPin(Integer pin) { this.pin = pin; }


    @Override
    public String toString() {
        return money + " " + currency;
    }
}
