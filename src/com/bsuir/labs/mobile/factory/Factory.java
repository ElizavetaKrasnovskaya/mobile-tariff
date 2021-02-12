package com.bsuir.labs.mobile.factory;

import com.bsuir.labs.mobile.model.Tariff;

public interface Factory {
    Tariff create(int amountOfUsers);
}
