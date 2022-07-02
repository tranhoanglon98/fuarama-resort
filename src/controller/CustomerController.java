package controller;

import service.impl.personServiceImpl.CustomerServiceImpl;
import service.personService.CustomerService;

import java.util.Scanner;

public class CustomerController {
    private static CustomerService customerService = new CustomerServiceImpl();


    public static void customerManagement() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1.\tDisplay list customers\n" +
                    "2.\tAdd new customer\n" +
                    "3.\tEdit customer\n" +
                    "4.\tReturn main menu\n");
            System.out.println("Enter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    customerService.displayPerson();
                    break;
                case "2":
                    customerService.addPerson();
                    break;
                case "3":
                    customerService.editPerson();
                    break;
                case "4":
                    System.out.println("---- Return main menu ----");
                    break;
            }
        } while (!choose.equals("4"));
    }
}
