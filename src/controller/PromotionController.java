package controller;

import java.util.Scanner;

public class PromotionController {
    public static void promotionManagement() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1.\tDisplay list customers use service\n" +
                    "2.\tDisplay list customers get voucher\n" +
                    "3.\tReturn main menu\n");
            System.out.println("Enter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                case "2":
                case "3":
                    System.out.println("---- Return main menu ----");
                    break;
            }
        } while (!choose.equals("3"));
    }
}
