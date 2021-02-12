package com.bsuir.labs.mobile.factory;

import com.bsuir.labs.mobile.model.Super25Tariff;
import com.bsuir.labs.mobile.model.Tariff;

public class Super25TariffFactory implements Factory {

    private static Super25TariffFactory INSTANCE;

    private Super25TariffFactory() {
    }

    public static Super25TariffFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Super25TariffFactory();
        }
        return INSTANCE;
    }

    @Override
    public Tariff create(int amountOfUsers) {
        return new Super25Tariff(amountOfUsers);
    }
}
