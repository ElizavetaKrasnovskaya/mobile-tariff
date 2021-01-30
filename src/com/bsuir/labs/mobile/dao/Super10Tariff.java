package com.bsuir.labs.mobile.dao;

import java.math.BigDecimal;

public class Super10Tariff extends Tariff{
    private static final String name = "super 10 tariff";
    private static final BigDecimal price = BigDecimal.valueOf(21.30);

    public Super10Tariff(int amountOfUsers) {
        super(name, price, amountOfUsers);
    }
}
