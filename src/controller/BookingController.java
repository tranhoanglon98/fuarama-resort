package controller;

import service.booking_service.BookingService;
import service.impl.BookingServiceImpl.BookingServiceImpl;

import java.util.Scanner;

public class BookingController {
    private static final BookingService BOOKING_SERVICE = new BookingServiceImpl();

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
                case "1":BOOKING_SERVICE.addNewBooking();break;
                case "2":BOOKING_SERVICE.displayBookingList();break;
                case "3":BOOKING_SERVICE.createNewContract();break;
                case "4":BOOKING_SERVICE.displayContractList();break;
                case "5":BOOKING_SERVICE.editContract();break;
                case "6":
                    System.out.println("---- Return main menu ----");
                    break;
            }
        } while (!choose.equals("6"));
    }

}
