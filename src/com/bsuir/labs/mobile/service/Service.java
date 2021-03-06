package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.exception.AlreadyHasTariffException;
import com.bsuir.labs.mobile.exception.NoTariffException;
import com.bsuir.labs.mobile.exception.NoUserException;
import com.bsuir.labs.mobile.model.Company;
import com.bsuir.labs.mobile.model.Tariff;
import com.bsuir.labs.mobile.model.User;

import java.util.List;

public interface Service {
    User createNewUser(String surname, String name, String middleName);

    List<Tariff> findAllTariffs();

    List<Tariff> findTariffByAmountOfUsers(int amount);

    int amountOfUsers();

    List<Tariff> sortTariffs();

    void subscribe(Tariff tariff) throws NoUserException, AlreadyHasTariffException;

    void unsubscribe() throws NoUserException, NoTariffException;

    void writeUserInFile();

    void writeCompanyInFile();

    User readUserFromFile();

    Company readCompanyFromFile();
}
