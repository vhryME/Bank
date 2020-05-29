package com.model;


import lombok.Data;


@Data
public class Count {
    //In init = dollars
    private Double money;
    private String currency;


    public Count() {}

    public Count(Double money, String currency) {
        this.money = money;
        this.currency = currency;
    }


    public static double getEuro(Count count) {
        return count.money *= 1.11;
    }

    public static double getRub(Count count) {
        return count.money *= 0.014;
    }


    @Override
    public String toString() {
        return money + " " + currency;
    }
}
