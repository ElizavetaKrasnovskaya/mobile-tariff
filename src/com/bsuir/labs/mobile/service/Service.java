package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.dao.User;
import com.bsuir.labs.mobile.exception.AlreadyHasTariffException;
import com.bsuir.labs.mobile.exception.NoTariffException;
import com.bsuir.labs.mobile.exception.NoUserException;

import java.util.List;

public interface Service {
    User createNewUser(String surname, String name, String middleName);
    List<Tariff> findAllTariffs();
    List<Tariff> findTariffByAmountOfUsers(int amount);
    int amountOfUsers();
    List<Tariff> sortTariffs();
    void subscribe(Tariff tariff) throws NoUserException;
    void unsubscribe() throws NoUserException, NoTariffException;
}
