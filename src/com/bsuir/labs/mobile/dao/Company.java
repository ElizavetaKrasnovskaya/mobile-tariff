package com.bsuir.labs.mobile.dao;

import java.util.List;

public class Company {

    private List<Tariff> tariffs;
    private int amountOfUsers;
    private static Company INSTANCE = null;

    private Company(){}

    public static Company getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new Company();
        }
        return INSTANCE;
    }

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
