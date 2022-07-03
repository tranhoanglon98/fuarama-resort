package util.enterInformation.bookingInfo;

import models.booking_contract.Booking;
import models.facility.Facility;
import models.person.Customer;
import util.ReadAndWriteFile.ReadAndWriteBooking;
import util.ReadAndWriteFile.ReadAndWriteCustomer;
import util.ReadAndWriteFile.ReadAndWriteFacility;
import util.enterInformation.Regex;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class EnterBookingInfo {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String chooseCustomerToBooking() {

        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        int index = 1;
        for (Customer c : customers) {
            System.out.println((index++) + ". Customer coed: " + c.getCustomerCode() + " - name: " + c.getName());
        }
        int choose;
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
            System.out.println("Enter booking code(ex: BK-0001)");
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

    public static LocalDate enterCheckInDay() {
        LocalDate checkInDay;
        do {
            try {
                System.out.println("Enter start day:");
                checkInDay = LocalDate.parse(SCANNER.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (checkInDay.isBefore(LocalDate.now())){
                    System.err.println("Check-in day cannot be earlier than today");
                }else {
                    break;
                }
            } catch (DateTimeParseException e) {
                System.err.println("Wrong format, enter again.");
            }
        } while (true);
        return checkInDay;
    }

    public static LocalDate enterCheckOutDay(LocalDate checkInDay, String serviceName){
        Map<Facility,Integer> facilityIntegerMap = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> facilityList = new LinkedList<>(facilityIntegerMap.keySet());
        boolean isRentByHours = false;
        for (Facility f:facilityList){
            if (f.getServiceName().equals(serviceName) && f.getRentType().equals("hours")) {
                isRentByHours = true;
                break;
            }
        }
        LocalDate checkOutDay;
        do {
            try {
                if (isRentByHours){
                    checkOutDay = checkInDay;
                }else {
                    System.out.println("Enter check-out day:");
                    checkOutDay = LocalDate.parse(SCANNER.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    if (checkOutDay.isAfter(checkInDay)){
                        break;
                    }else {
                        System.err.println("Check-out day has to be later than check-in day");
                    }
                }
            }catch (DateTimeParseException e){
                System.err.println("Wrong format, enter again.");
            }
        }while (true);
        return checkOutDay;
    }

    public static String chooseService() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> facilityList = new LinkedList<>(facilityIntegerMap.keySet());
        Set<Facility> facilityMaintenance = new LinkedHashSet<>();
        for (Facility f : facilityList) {
            if (facilityIntegerMap.get(f) == 5) {
                facilityMaintenance.add(f);
                facilityList.remove(f);
            }
        }
        ReadAndWriteFacility.writeFacilityMaintenanceDataFile(facilityMaintenance, true);
        for (int i = 0; i < facilityList.size(); i++) {
            System.out.println((i + 1) + ". " + facilityList.get(i).getServiceName());
        }
        int choose;
        do {
            System.out.println("Choose service");
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
                if (choose < 1 || choose > facilityList.size()) {
                    System.err.println("just choose from 1 to " + facilityList.size());
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, enter again");
            }
        } while (true);
        return facilityList.get(choose - 1).getServiceName();
    }
}
