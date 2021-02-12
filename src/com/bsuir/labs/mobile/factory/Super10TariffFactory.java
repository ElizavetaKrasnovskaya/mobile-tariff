package com.bsuir.labs.mobile.factory;

import com.bsuir.labs.mobile.model.Super10Tariff;
import com.bsuir.labs.mobile.model.Tariff;

public class Super10TariffFactory implements Factory {

    private static Super10TariffFactory INSTANCE;

    private Super10TariffFactory() {
    }

    public static Super10TariffFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Super10TariffFactory();
        }
        return INSTANCE;
    }

    @Override
    public Tariff create(int amountOfUsers) {
        return new Super10Tariff(amountOfUsers);
    }
}
