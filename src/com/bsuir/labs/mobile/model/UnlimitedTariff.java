package com.bsuir.labs.mobile.model;

import java.math.BigDecimal;

public class UnlimitedTariff extends Tariff {

    private static final String name = "unlimited tariff";
    private static final BigDecimal price = BigDecimal.valueOf(25);
    private static final String amountOfMinutes = "Infinity";
    private static final String amountOfInternet = "Infinity";

    public UnlimitedTariff(int amountOfUsers) {
        super(name, price, amountOfUsers, amountOfMinutes, amountOfInternet);
    }
}
