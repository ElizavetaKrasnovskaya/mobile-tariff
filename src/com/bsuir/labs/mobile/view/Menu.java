package com.bsuir.labs.mobile.view;

import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.service.Service;
import com.bsuir.labs.mobile.service.TariffService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final static Service service = new TariffService();
    private static List<Tariff> tariffs;

    public static void printMenu(){
        while(true) {
            System.out.println("1, 2, 3, 4 or 5");
            System.out.println("1 - print all tariffs");
            System.out.println("2 - general amount of users");
            System.out.println("3 - sort all tariffs by price");
            System.out.println("4 - search by amount of people");
            System.out.println("5 - exit");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            }catch (NumberFormatException ex){
            }
            if(choice>0 && choice <5){
                handleUserInput(choice);
            }
            if(choice == 5){
                break;
            }
        }
    }

    public static void handleUserInput(int choice){
        switch (choice){
            case 1:
                tariffs = service.findAllTariffs();
                for (Tariff tariff : tariffs){
                    System.out.println(tariff);
                }
                break;
            case 2:
                System.out.println(service.amountOfUsers());
                break;
            case 3:
                tariffs = service.sortTariffs();
                for (Tariff tariff : tariffs){
                    System.out.println(tariff);
                }
                break;
            case 4:
                tariffs = service.findTariffByAmountOfUsers(fetchAmountOfUsers());
                if(!tariffs.equals(null)){
                    for(Tariff tariff : tariffs){
                        System.out.println(tariff);
                    }
                }else{
                    System.out.println("There is no tariffs with such amount of users");
                }
                break;
            default:
                System.out.println("There is no cases");
        }
    }

    public static int fetchAmountOfUsers(){
        int amountOfUsers = 0;
        while (true) {
            System.out.println("Enter amount of users");
            Scanner scanner = new Scanner(System.in);
            try {
                amountOfUsers = Integer.parseInt(scanner.next());
            } catch (NumberFormatException ex) {
            }
            if(amountOfUsers != 0){
                break;
            }
        }
        return amountOfUsers;
    }
}
