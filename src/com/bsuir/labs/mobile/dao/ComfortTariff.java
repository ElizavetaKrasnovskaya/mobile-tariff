package com.bsuir.labs.mobile.dao;

import java.math.BigDecimal;

public class ComfortTariff extends Tariff{

    private static final String name = "comfort tariff";
    private static final BigDecimal price = BigDecimal.valueOf(21);

    public ComfortTariff(int amountOfUsers) {
        super(name, price, amountOfUsers);
    }
}
