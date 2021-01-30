package com.bsuir.labs.mobile.service;

import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.fabrica.ComfortTariffFactory;
import com.bsuir.labs.mobile.fabrica.Super10TariffFactory;
import com.bsuir.labs.mobile.fabrica.Super25TariffFactory;
import com.bsuir.labs.mobile.fabrica.UnlimitedTariffFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TariffService implements Service{

//    private final static Logger LOGGER = LogManager.getLogger(TariffService.class);

    public List<Tariff> create(){
        List<Tariff> tariffs = new ArrayList<>();
        tariffs.add(ComfortTariffFactory.getINSTANCE().create(20));
        tariffs.add(Super10TariffFactory.getINSTANCE().create(40));
        tariffs.add(Super25TariffFactory.getINSTANCE().create(100));
        tariffs.add(UnlimitedTariffFactory.getINSTANCE().create(200));
        return tariffs;
    }

    @Override
    public List<Tariff> findAllTariffs() {
        return create();
    }

    @Override
    public List<Tariff> findTariffByAmountOfUsers(int criteria) {
        List<Tariff> tariffs = create();
        return tariffs.stream().filter(tariff -> (
                tariff.getAmountOfUsers() == criteria
                )).collect(Collectors.toList());
    }

    @Override
    public int amountOfUsers() {
        int amount = 0;
        List<Tariff> tariffs = create();
        for(Tariff tariff : tariffs){
            amount += tariff.getAmountOfUsers();
        }
        return amount;
    }

    @Override
    public List<Tariff> sortTariffs() {
        List<Tariff> tariffs = create();
        return tariffs.stream().sorted(Comparator.comparing(Tariff::getPrice))
                .collect(Collectors.toList());
    }
}
