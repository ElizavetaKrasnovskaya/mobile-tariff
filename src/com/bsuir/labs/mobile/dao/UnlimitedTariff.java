package com.bsuir.labs.mobile.dao;

import java.math.BigDecimal;

public class UnlimitedTariff extends Tariff{

    private static final String name = "unlimited tariff";
    private static final BigDecimal price = BigDecimal.valueOf(25);

    public UnlimitedTariff(int amountOfUsers) {
        super(name, price, amountOfUsers);
    }
}
