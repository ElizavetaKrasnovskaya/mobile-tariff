package com.bsuir.labs.mobile.fabrica;

import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.dao.UnlimitedTariff;

public class UnlimitedTariffFactory implements Factory{
    private static UnlimitedTariffFactory INSTANCE;

    private UnlimitedTariffFactory(){}

    public static UnlimitedTariffFactory getINSTANCE() {
        if(INSTANCE == null){
            INSTANCE = new UnlimitedTariffFactory();
        }
        return INSTANCE;
    }

    @Override
    public Tariff create(int amountOfUsers) {
        return new UnlimitedTariff(amountOfUsers);
    }
}
