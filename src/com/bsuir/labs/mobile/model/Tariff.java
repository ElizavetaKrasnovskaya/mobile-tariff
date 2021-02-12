package com.bsuir.labs.mobile.model;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Tariff {

    private final String name;
    private final BigDecimal price;
    private int amountOfUsers;
    private final String amountOfMinutes;
    private final String amountOfInternet;

    public Tariff(String name, BigDecimal price, int amountOfUsers, String amountOfMinutes, String amountOfMB) {
        this.name = name;
        this.price = price;
        this.amountOfUsers = amountOfUsers;
        this.amountOfMinutes = amountOfMinutes;
        this.amountOfInternet = amountOfMB;
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

    public void setAmountOfUsers(int amountOfUsers) {
        this.amountOfUsers = amountOfUsers;
    }

    public String getAmountOfInternet() {
        return amountOfInternet;
    }

    public String getAmountOfMinutes() {
        return amountOfMinutes;
    }

    @Override
    public String toString() {
        return "Tariff" +
                " name = " + name +
                ", price = " + price +
                ", amountOfUsers = " + amountOfUsers +
                ", amountOfMinutes = " + amountOfMinutes +
                ", amountOfMB = " + amountOfInternet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tariff)) return false;
        Tariff tariff = (Tariff) o;
        return getAmountOfUsers() == tariff.getAmountOfUsers() && Objects.equals(getName(), tariff.getName())
                && Objects.equals(getPrice(), tariff.getPrice())
                && Objects.equals(getAmountOfMinutes(), tariff.getAmountOfMinutes())
                && Objects.equals(getAmountOfInternet(), tariff.getAmountOfInternet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getAmountOfUsers(), getAmountOfMinutes(), getAmountOfInternet());
    }
}
