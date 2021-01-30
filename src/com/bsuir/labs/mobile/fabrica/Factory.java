package com.bsuir.labs.mobile.fabrica;

import com.bsuir.labs.mobile.dao.Tariff;

public interface Factory {
    Tariff create(int amountOfUsers);
}
