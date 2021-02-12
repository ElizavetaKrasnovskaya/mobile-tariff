package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Dao;
import com.bsuir.labs.mobile.dao.TariffDao;
import com.bsuir.labs.mobile.exception.AlreadyHasTariffException;
import com.bsuir.labs.mobile.exception.NoTariffException;
import com.bsuir.labs.mobile.exception.NoUserException;
import com.bsuir.labs.mobile.model.Company;
import com.bsuir.labs.mobile.model.Tariff;
import com.bsuir.labs.mobile.model.User;

import java.util.List;

public class TariffService implements Service{

    private final Dao dao = new TariffDao();

    @Override
    public User createNewUser(String surname, String name, String middleName) {
        return dao.createNewUser(surname, name, middleName);
    }

    @Override
    public List<Tariff> findAllTariffs() {
        return dao.findAllTariffs();
    }

    @Override
    public List<Tariff> findTariffByAmountOfUsers(int amount) {
        return dao.findTariffByAmountOfUsers(amount);
    }

    @Override
    public int amountOfUsers() {
        return dao.amountOfUsers();
    }

    @Override
    public List<Tariff> sortTariffs() {
        return dao.sortTariffs();
    }

    @Override
    public void subscribe(Tariff tariff) throws NoUserException, AlreadyHasTariffException {
        dao.subscribe(tariff);
    }

    @Override
    public void unsubscribe() throws NoUserException, NoTariffException {
        dao.unsubscribe();
    }

    @Override
    public void writeUserInFile() {
        dao.writeUserInFile();
    }

    @Override
    public void writeCompanyInFile() {
        dao.writeCompanyInFile();
    }

    @Override
    public User readUserFromFile() {
        return dao.readUserFromFile();
    }

    @Override
    public Company readCompanyFromFile() {
        return dao.readCompanyFromFile();
    }
}
