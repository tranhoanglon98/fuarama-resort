package util.enterInformation.bookingInfo;

import models.booking_contract.Booking;
import models.person.Customer;
import util.ReadAndWriteFile.ReadAndWriteBooking;
import util.ReadAndWriteFile.ReadAndWriteCustomer;
import util.enterInformation.Regex;

import java.util.List;
import java.util.Scanner;

public class EnterBookingInfo {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String chooseCustomerToBooking() {

        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        int index = 1;
        for (Customer c : customers) {
            System.out.println((index++) + ". Customer coed: " + c.getCustomerCode() + " - name: " + c.getName());
        }
        int choose = 0;
        do {
            try {
                System.out.println("-----Choose customer------");
                choose = Integer.parseInt(SCANNER.nextLine());
                if (choose < 1 || choose > customers.size()) {
                    System.err.println("just choose from 1 to " + customers.size());
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, enter again");
            }
        } while (true);

        return customers.get(choose - 1).getCustomerCode();
    }

    public static String enterBookingCode() {
        String bookingCode;
        boolean flag;
        List<Booking> bookings = ReadAndWriteBooking.readBookingDataFile();
        do {
            flag = false;
            System.out.println("Enter booking code");
            bookingCode = SCANNER.nextLine();
            if (!Regex.checkBookingCodeFormat(bookingCode)) {
                System.err.println("Wrong format, enter again.");
                flag = true;
            } else {
                for (Booking b : bookings) {
                    if (b.getBookingCode().equals(bookingCode)) {
                        System.err.println("Booking code is already exits, enter again.");
                        flag = true;
                    }
                }
            }
        } while (flag);

        return bookingCode;
    }
}
