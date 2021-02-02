package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Company;
import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.dao.User;
import com.bsuir.labs.mobile.fabrica.ComfortTariffFactory;
import com.bsuir.labs.mobile.fabrica.Super10TariffFactory;
import com.bsuir.labs.mobile.fabrica.Super25TariffFactory;
import com.bsuir.labs.mobile.fabrica.UnlimitedTariffFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TariffService implements Service {

    private User user = null;
    private Company company = createCompany();

    public Company createCompany() {

        Company company = Company.getINSTANCE();
        List<Tariff> tariffs = new ArrayList<>();

        tariffs.add(ComfortTariffFactory.getINSTANCE().create(20));
        tariffs.add(Super10TariffFactory.getINSTANCE().create(40));
        tariffs.add(Super25TariffFactory.getINSTANCE().create(100));
        tariffs.add(UnlimitedTariffFactory.getINSTANCE().create(200));

        company.setTariffs(tariffs);

        return company;
    }

    @Override
    public User createNewUser(String surname, String name, String middleName) {
        this.user = new User(surname, name, middleName);
        return user;
    }

    @Override
    public List<Tariff> findAllTariffs() {
        return company.getTariffs();
    }

    @Override
    public List<Tariff> findTariffByAmountOfUsers(int criteria) {
        List<Tariff> tariffs = company.getTariffs();
        return tariffs.stream().filter(tariff -> (
                tariff.getAmountOfUsers() == criteria
        )).collect(Collectors.toList());
    }

    @Override
    public int amountOfUsers() {
        int amountOfUsers = 0;
        for(Tariff tariff : company.getTariffs()){
            amountOfUsers += tariff.getAmountOfUsers();
        }
        company.setAmountOfUsers(amountOfUsers);
        return amountOfUsers;
    }

    @Override
    public List<Tariff> sortTariffs() {
        List<Tariff> tariffs = company.getTariffs();
        return tariffs.stream().sorted(Comparator.comparing(Tariff::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public boolean subscribe(Tariff tariffToSubscribe) {
        boolean isSubscribed;
        if (this.user != null) {

            List<Tariff> tariffs = createCompany().getTariffs();
            for (Tariff tariff : tariffs) {
                if (tariff.getName().equals(tariffToSubscribe.getName())) {
                    company.getTariffs().remove(tariffToSubscribe);
                    tariff.setAmountOfUsers(tariff.getAmountOfUsers() + 1);
                    user.subscribe(tariff);
                    company.getTariffs().add(tariff);
                    break;
                }
            }
            isSubscribed = true;
        } else {
            isSubscribed = false;
        }
        return isSubscribed;
    }

    @Override
    public boolean unsubscribe() {
        boolean isUnsubscribed;
        if (this.user != null) {
            List<Tariff> tariffs = company.getTariffs();
            for (Tariff tariff : tariffs) {
                if (tariff.getName().equals(user.getTariff().getName())) {
                    company.getTariffs().remove(tariff);
                    tariff.setAmountOfUsers(tariff.getAmountOfUsers() - 1);
                    company.getTariffs().add(tariff);
                    break;
                }
            }
            user.unSubscribe();
            isUnsubscribed = true;
        } else {
            isUnsubscribed = false;
        }
        return isUnsubscribed;
    }
}
