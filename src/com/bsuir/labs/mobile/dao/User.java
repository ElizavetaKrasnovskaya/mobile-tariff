package com.bsuir.labs.mobile.dao;

import java.util.Objects;

public class User {

    private String surname;
    private String name;
    private String middleName;
    private static Tariff tariff;

    public User() {}

    public User(String surname, String name, String middleName) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public boolean subscribe(Tariff tariff){
        boolean isSubscribed;
        if(this.tariff == null){
            this.tariff = tariff;
            isSubscribed = true;
        }else{
            isSubscribed = false;
        }
        return isSubscribed;
    }

    public boolean unSubscribe(){
        boolean isUnsubscribe;
        if(this.tariff != null){
            tariff = null;
            isUnsubscribe = true;
        }else{
            isUnsubscribe = false;
        }
        return isUnsubscribe;
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
