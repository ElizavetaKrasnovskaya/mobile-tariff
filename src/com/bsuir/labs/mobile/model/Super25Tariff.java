package com.bsuir.labs.mobile.model;

import java.math.BigDecimal;

public class Super25Tariff extends Tariff {

    private static final String name = "super 25 tariff";
    private static final BigDecimal price = BigDecimal.valueOf(30.60);
    private static final String amountOfMinutes = "Infinity";
    private static final String amountOfInternet = "25";

    public Super25Tariff(int amountOfUsers) {
        super(name, price, amountOfUsers, amountOfMinutes, amountOfInternet);
    }
}
