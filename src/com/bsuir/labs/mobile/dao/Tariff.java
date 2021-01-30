package com.bsuir.labs.mobile.dao;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Tariff {
    private final String name;
    private final BigDecimal price;
    private final int amountOfUsers;

    public Tariff(String name, BigDecimal price, int amountOfUsers) {
        this.name = name;
        this.price = price;
        this.amountOfUsers = amountOfUsers;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getAmountOfUsers() {
        return amountOfUsers;
    }

    @Override
    public String toString() {
        return "Tariff " +
                "name = '" + name + '\'' +
                ", price = " + price +
                ", amountOfUsers = " + amountOfUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return amountOfUsers == tariff.amountOfUsers && Objects.equals(name, tariff.name) && Objects.equals(price, tariff.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, amountOfUsers);
    }
}
