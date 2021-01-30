package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Tariff;

import java.util.List;

public interface Service {
    List<Tariff> findAllTariffs();
    List<Tariff> findTariffByAmountOfUsers(int amount);
    int amountOfUsers();
    List<Tariff> sortTariffs();
}
