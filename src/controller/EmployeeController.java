package controller;

import service.impl.personServiceImpl.EmployeeServiceImpl;
import service.personService.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    private static EmployeeService employeeService = new EmployeeServiceImpl();

    public static void employeeManagement() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1\tDisplay list employees\n" +
                    "2\tAdd new employee\n" +
                    "3\tEdit employee\n" +
                    "4\tReturn main menu\n");
            System.out.println("Enter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    employeeService.displayPerson();
                    break;
                case "2":
                    employeeService.addPerson();
                    break;
                case "3":
                    employeeService.editPerson();
                    break;
                case "4":
                    System.out.println("---- Return main menu ----");
                    break;
            }
        } while (!choose.equals("4"));
    }
}
