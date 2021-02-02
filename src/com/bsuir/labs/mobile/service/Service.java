package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.dao.User;

import java.util.List;

public interface Service {
    User createNewUser(String surname, String name, String middleName);
    List<Tariff> findAllTariffs();
    List<Tariff> findTariffByAmountOfUsers(int amount);
    int amountOfUsers();
    List<Tariff> sortTariffs();
    boolean subscribe(Tariff tariff);
    boolean unsubscribe();
}
