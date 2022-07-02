package controller;

import java.util.Scanner;

public class BookingController {
    public static void bookingManagement() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1.\tAdd new booking\n" +
                    "2.\tDisplay list booking\n" +
                    "3.\tCreate new constracts\n" +
                    "4.\tDisplay list contracts\n" +
                    "5.\tEdit contracts\n" +
                    "6.\tReturn main menu\n");
            System.out.println("Enter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    System.out.println("---- Return main menu ----");
                    break;
            }
        } while (!choose.equals("6"));
    }

}
