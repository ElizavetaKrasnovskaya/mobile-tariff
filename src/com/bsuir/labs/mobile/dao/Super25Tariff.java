package com.bsuir.labs.mobile.dao;

import java.math.BigDecimal;

public class Super25Tariff extends Tariff{
    private static final String name = "super 25 tariff";
    private static final BigDecimal price = BigDecimal.valueOf(30.60);

    public Super25Tariff(int amountOfUsers) {
        super(name, price, amountOfUsers);
    }
}
