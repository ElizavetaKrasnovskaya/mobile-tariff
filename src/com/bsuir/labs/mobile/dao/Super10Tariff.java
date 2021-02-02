package com.bsuir.labs.mobile.dao;

import java.io.Serializable;
import java.math.BigDecimal;

public class Super10Tariff extends Tariff implements Serializable {
    private static final String name = "super 10 tariff";
    private static final BigDecimal price = BigDecimal.valueOf(21.30);
    private static final String amountOfMinutes = "10";
    private static final String amountOfInternet = "400";

    public Super10Tariff(int amountOfUsers) {
        super(name, price, amountOfUsers, amountOfMinutes, amountOfInternet);
    }
}
