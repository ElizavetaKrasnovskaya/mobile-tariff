package com.bsuir.labs.mobile.model;

import java.math.BigDecimal;

public class ComfortTariff extends Tariff {

    private static final String name = "comfort tariff";
    private static final BigDecimal price = BigDecimal.valueOf(21);
    private static final String amountOfMinutes = "10";
    private static final String amountOfInternet = "120";

    public ComfortTariff(int amountOfUsers) {
        super(name, price, amountOfUsers, amountOfMinutes, amountOfInternet);
    }
}
