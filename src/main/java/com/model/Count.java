package com.model;


import lombok.Data;


@Data
public class Count {
    private Double money;
    private String currency;


    public Count() {}

    public Count(Double money, String currency) {
        this.money = money;
        this.currency = currency;
    }


    public void setCurrency() {
        switch (currency) {
            case "DOLLAR":
                currency = "$";

            case "EURO":
                currency = "€";

            case "RUB":
                currency = "RUB";

            default:
                return;
        }
    }

    @Override
    public String toString() {
        return money + " " + currency;
    }
}
