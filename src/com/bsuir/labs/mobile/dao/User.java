package com.bsuir.labs.mobile.dao;

import com.bsuir.labs.mobile.exception.AlreadyHasTariffException;
import com.bsuir.labs.mobile.exception.NoTariffException;

import java.util.Objects;

public class User {

    private final String surname;
    private final String name;
    private final String middleName;
    private static Tariff tariff;

    public User(String surname, String name, String middleName) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void subscribe(Tariff tariff) throws AlreadyHasTariffException {
        if(User.tariff == null){
            User.tariff = tariff;
        }else{
            throw new AlreadyHasTariffException("You are already subscribed to the tariff");
        }
    }

    public void unSubscribe() throws NoTariffException {
        if(!tariff.equals(null)){
            tariff = null;
        }else{
            throw new NoTariffException("You have no tariff to unsubscribe from");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getName(), user.getName()) && Objects.equals(getMiddleName(), user.getMiddleName()) && Objects.equals(getTariff(), user.getTariff());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getName(), getMiddleName(), getTariff());
    }

    @Override
    public String toString() {
        return "User " +
                "surname = '" + surname + '\'' +
                ", name = '" + name + '\'' +
                ", middleName = '" + middleName + '\'' +
                ", tariff = " + tariff;
    }
}
