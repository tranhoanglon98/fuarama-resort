package controller;

import java.util.Scanner;

public class FuramaController {

    public static void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            System.out.println("Enter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    EmployeeController.employeeManagement();
                    break;
                case "2":
                    CustomerController.customerManagement();
                    break;
                case "3":
                    FacilityController.facilityManagement();
                    break;
                case "4":
                    BookingController.bookingManagement();
                    break;
                case "5":
                    PromotionController.promotionManagement();
                    break;
                case "6":
                    System.out.println("---------- Exit ----------");
            }
        } while (!choose.equals("6"));
    }









}
