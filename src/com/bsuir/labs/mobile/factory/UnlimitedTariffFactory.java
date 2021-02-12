package com.bsuir.labs.mobile.factory;

import com.bsuir.labs.mobile.model.Tariff;
import com.bsuir.labs.mobile.model.UnlimitedTariff;

public class UnlimitedTariffFactory implements Factory {

    private static UnlimitedTariffFactory INSTANCE;

    private UnlimitedTariffFactory() {
    }

    public static UnlimitedTariffFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new UnlimitedTariffFactory();
        }
        return INSTANCE;
    }

    @Override
    public Tariff create(int amountOfUsers) {
        return new UnlimitedTariff(amountOfUsers);
    }
}
