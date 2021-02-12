package com.bsuir.labs.mobile.model;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

    private List<Tariff> tariffs;
    private int amountOfUsers;

    public Company(){}

    public int getAmountOfUsers() {
        return amountOfUsers;
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
        for (Tariff tariff : this.tariffs){
            amountOfUsers += tariff.getAmountOfUsers();
        }
    }

    public void setAmountOfUsers(int amountOfUsers) {
        this.amountOfUsers = amountOfUsers;
    }
}
