package com.bsuir.labs.mobile.factory;

import com.bsuir.labs.mobile.model.ComfortTariff;
import com.bsuir.labs.mobile.model.Tariff;

public class ComfortTariffFactory implements Factory {

    private static ComfortTariffFactory INSTANCE = null;

    private ComfortTariffFactory() {
    }

    public static ComfortTariffFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ComfortTariffFactory();
        }
        return INSTANCE;
    }

    @Override
    public Tariff create(int amountOfUsers) {
        return new ComfortTariff(amountOfUsers);
    }
}
