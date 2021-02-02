package com.bsuir.labs.mobile.view;

import com.bsuir.labs.mobile.dao.Tariff;
import com.bsuir.labs.mobile.dao.User;
import com.bsuir.labs.mobile.service.Service;
import com.bsuir.labs.mobile.service.TariffService;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Menu {

    private final static Service service = new TariffService();
    private static List<Tariff> tariffs;
    private static User user;

    public static void printMenu() {
        while (true) {
            System.out.println("1, 2, 3, 4, 5, 6 ");
            System.out.println("1 - print all tariffs");
            System.out.println("2 - general amount of users");
            System.out.println("3 - sort all tariffs by price");
            System.out.println("4 - search by amount of people");
            System.out.println("5 - create new user");
            System.out.println("6 - subscribe");
            System.out.println("7 - unsubscribe");
            System.out.println("8 - Info about user");
            System.out.println("9 - exit");
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException ex) {
            }
            if (choice > 0 && choice < 9) {
                handleUserInput(choice);
            }
            if (choice == 9) {
                break;
            }
        }
    }

    public static void handleUserInput(int choice) {
        switch (choice) {
            case 1:
                tariffs = service.findAllTariffs();
                for (Tariff tariff : tariffs) {
                    System.out.println(tariff);
                }
                break;
            case 2:
                System.out.println(service.amountOfUsers());
                break;
            case 3:
                tariffs = service.sortTariffs();
                for (Tariff tariff : tariffs) {
                    System.out.println(tariff);
                }
                break;
            case 4:
                tariffs = service.findTariffByAmountOfUsers(fetchAmountOfUsers());
                if (!tariffs.isEmpty()) {
                    for (Tariff tariff : tariffs) {
                        System.out.println(tariff);
                    }
                } else {
                    System.out.println("There is no tariffs with such amount of users");
                }
                break;
            case 5:
                System.out.println("Enter surname");
                String surname = fetchInfoAboutUser();
                System.out.println("Enter name");
                String name = fetchInfoAboutUser();
                System.out.println("Enter middle name");
                String middleName = fetchInfoAboutUser();
                user = service.createNewUser(surname, name, middleName);
                break;
            case 6:
                if (service.subscribe(fetchTariff())) {
                    System.out.println("Successful subscribed!");
                } else {
                    System.out.println("Something went wrong...");
                }
                break;
            case 7:
                if (service.unsubscribe()) {
                    System.out.println("Successful unsubscribed!");
                } else {
                    System.out.println("Something went wrong...");
                }
                break;
            case 8:
                System.out.println(user);
                break;
            default:
                System.out.println("There is no cases");
        }
    }

    public static String fetchInfoAboutUser() {
        String name;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            name = scanner.next();
            if (Pattern.compile("^[a-zA-Z]*$").matcher(name).matches()) {
                break;
            }
        }
        return name;
    }

    public static int fetchAmountOfUsers() {
        int amountOfUsers = 0;
        while (true) {
            System.out.println("Enter amount of users");
            Scanner scanner = new Scanner(System.in);
            try {
                amountOfUsers = Integer.parseInt(scanner.next());
            } catch (NumberFormatException ex) {
            }
            if (amountOfUsers != 0) {
                break;
            }
        }
        return amountOfUsers;
    }

    public static Tariff fetchTariff() {
        List<Tariff> tariffs = service.findAllTariffs();
        int choice = 0;
        while (true) {
            System.out.println("Enter 1, 2, 3, 4 or 5");
            for (int i = 0; i < tariffs.size(); i++) {
                System.out.println((i + 1) + " - " + tariffs.get(i));
            }
            System.out.println("5 - exit");
            Scanner scanner = new Scanner(System.in);

            try {
                choice = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException ex) {
            }
            if (choice == 5) {
                break;
            }
        }
        return tariffs.get(choice - 1);
    }
}
