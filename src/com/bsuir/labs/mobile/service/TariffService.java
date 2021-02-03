package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Company;
import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.dao.User;
import com.bsuir.labs.mobile.exception.AlreadyHasTariffException;
import com.bsuir.labs.mobile.exception.NoTariffException;
import com.bsuir.labs.mobile.exception.NoUserException;
import com.bsuir.labs.mobile.factory.ComfortTariffFactory;
import com.bsuir.labs.mobile.factory.Super10TariffFactory;
import com.bsuir.labs.mobile.factory.Super25TariffFactory;
import com.bsuir.labs.mobile.factory.UnlimitedTariffFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TariffService implements Service {

    private User user = null;
    private static Company company = createCompany();

    public static Company createCompany() {
        Company company = new Company();
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
        writeUserInFile();
        return user;
    }

    @Override
    public List<Tariff> findAllTariffs() {
        return readCompanyFromFile().getTariffs();
    }

    @Override
    public List<Tariff> findTariffByAmountOfUsers(int criteria) {
        List<Tariff> tariffs = readCompanyFromFile().getTariffs();
        return tariffs.stream().filter(tariff -> (
                tariff.getAmountOfUsers() == criteria
        )).collect(Collectors.toList());
    }

    @Override
    public int amountOfUsers() {
        int amountOfUsers = 0;
        for (Tariff tariff : company.getTariffs()) {
            amountOfUsers += tariff.getAmountOfUsers();
        }
        readCompanyFromFile().setAmountOfUsers(amountOfUsers);
        return amountOfUsers;
    }

    @Override
    public List<Tariff> sortTariffs() {
        List<Tariff> tariffs = readCompanyFromFile().getTariffs();
        return tariffs.stream().sorted(Comparator.comparing(Tariff::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public void subscribe(Tariff tariffToSubscribe) throws NoUserException {
        if (this.user != null) {
            List<Tariff> tariffs = readCompanyFromFile().getTariffs();
            for (Tariff tariff : tariffs) {
                if (tariff.getName().equals(tariffToSubscribe.getName())) {
                    company.getTariffs().remove(tariffToSubscribe);
                    tariff.setAmountOfUsers(tariff.getAmountOfUsers() + 1);
                    try {
                        user.subscribe(tariff);
                    } catch (AlreadyHasTariffException e) {
                        e.printStackTrace();
                    }
                    company.getTariffs().add(tariff);
                    writeCompanyInFile();
                    break;
                }
            }
        } else {
            throw new NoUserException("Create user!");
        }
        writeUserInFile();
    }

    @Override
    public void unsubscribe() throws NoUserException, NoTariffException {
        if (this.user != null) {
            if (this.user.getTariff() != null) {
                List<Tariff> tariffs = readCompanyFromFile().getTariffs();
                for (Tariff tariff : tariffs) {
                    if (tariff.getName().equals(user.getTariff().getName())) {
                        company.getTariffs().remove(tariff);
                        tariff.setAmountOfUsers(tariff.getAmountOfUsers() - 1);
                        company.getTariffs().add(tariff);
                        writeCompanyInFile();
                        break;
                    }
                }
                user.unsubscribe();
            } else {
                throw new NoTariffException("You have no tariff to unsubscribe from");
            }
        } else {
            throw new NoUserException("Create user!");
        }
        writeUserInFile();
    }

    public void writeUserInFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user.txt"))) {
            outputStream.writeObject(user);
        } catch (IOException exception) {
        }
    }

    public void writeCompanyInFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("company.txt"))) {
            outputStream.writeObject(createCompany());
        } catch (IOException exception) {
        }
    }

    public User readUserFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.txt"))) {
            user = (User) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
        }
        return user;
    }

    public Company readCompanyFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("company.txt"))) {
            company = (Company) inputStream.readObject();
        } catch (IOException | ClassNotFoundException exception) {
        }
        return company;
    }
}
