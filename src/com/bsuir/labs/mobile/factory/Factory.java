package com.bsuir.labs.mobile.factory;

import com.bsuir.labs.mobile.dao.Tariff;

public interface Factory {
    Tariff create(int amountOfUsers);
}
