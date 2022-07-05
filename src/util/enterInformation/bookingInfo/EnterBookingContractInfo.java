package util.enterInformation.bookingInfo;

import models.booking_contract.Booking;
import models.facility.Facility;
import models.person.Customer;
import util.ReadAndWriteFile.ReadAndWriteBookingContract;
import util.ReadAndWriteFile.ReadAndWriteCustomer;
import util.ReadAndWriteFile.ReadAndWriteFacility;
import util.UserException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class EnterBookingContractInfo {
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
        String bookingCode = ReadAndWriteBookingContract.readMaxBookingCode();
        if (bookingCode == null) {
            bookingCode = "BK-1";
        } else {
            String[] array = bookingCode.split("-");
            bookingCode = array[0] + "-" + (Integer.parseInt(array[1]) + 1);
        }
        return bookingCode;
    }

    public static LocalDate enterCheckInDay(String serviceCode) {
        LocalDate checkInDay = null;
        boolean flag;
        do {
            flag = false;
            try {
                System.out.println("Enter check-in day:");
                checkInDay = LocalDate.parse(SCANNER.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (checkInDay.isBefore(LocalDate.now())) {
                    System.err.println("Check-in day cannot be earlier than today");
                    flag = true;
                } else {
                    Set<Booking> bookingList = ReadAndWriteBookingContract.readBookingDataFile();
                    for (Booking b : bookingList) {
                        if (b.getServiceCode().equals(serviceCode)) {
                            if (!checkInDay.isBefore(b.getCheckInDate()) && !checkInDay.isAfter(b.getCheckOutDate())) {
                                flag = true;
                                System.err.println("Room was booked for this day, enter check-in day again:");
                                break;
                            }
                        }
                    }
                }
            } catch (DateTimeParseException e) {
                System.err.println("Wrong format, enter again.");
                flag = true;
            }
        } while (flag);
        return checkInDay;
    }

    public static LocalDate enterCheckOutDay(LocalDate checkInDay, String serviceCode) {
        LocalDate checkOutDay = null;
        boolean flag;
        do {
            flag = false;
            try {
                System.out.println("Enter check-out day:");
                checkOutDay = LocalDate.parse(SCANNER.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (!checkOutDay.isBefore(checkInDay)) {
                    Set<Booking> bookingList = ReadAndWriteBookingContract.readBookingDataFile();
                    for (Booking b : bookingList) {
                        if (b.getServiceCode().equals(serviceCode)) {
                            if ((checkInDay.isBefore(b.getCheckInDate()) && checkOutDay.isBefore(b.getCheckInDate())) || checkInDay.isAfter(b.getCheckOutDate())) {
                                flag = false;
                            } else {
                                System.err.println("Room was booked for this day, enter check-out day again:");
                                flag = true;
                            }
                        }
                    }
                } else {
                    System.err.println("Check-out day has to be later than check-in day");
                    flag = true;
                }
            } catch (DateTimeParseException e) {
                System.err.println("Wrong format, enter again.");
                flag = true;
            }
        } while (flag);
        return checkOutDay;
    }

    public static String chooseService() throws UserException {
        Map<Facility, Integer> map = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> keyList = new LinkedList<>(map.keySet());
        Set<Facility> facilityMaintenance = new LinkedHashSet<>();
        for (int i = 0; i < keyList.size(); i++) {
            if (map.get(keyList.get(i)) == 5) {
                facilityMaintenance.add(keyList.get(i));
                map.remove(keyList.get(i));
                keyList.remove(keyList.get(i));
                i--;
            }
        }
        ReadAndWriteFacility.writeFacilityDataFile(map, false);
        ReadAndWriteFacility.writeFacilityMaintenanceDataFile(facilityMaintenance, true);
        if (keyList.isEmpty()) {
            throw new UserException("There is no blank facility");
        } else {
            for (int i = 0; i < keyList.size(); i++) {
                System.out.println((i + 1) + ". " + keyList.get(i).getServiceCode());
            }
        }

        int choose;
        do {
            System.out.println("Choose service");
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
                if (choose < 1 || choose > keyList.size()) {
                    System.err.println("just choose from 1 to " + keyList.size());
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Wrong format, enter again");
            }
        } while (true);

        return keyList.get(choose - 1).getServiceCode();
    }

    public static String getContractCode(String bookingCode) {
        String[] array = bookingCode.split("-");
        return "CT-" + array[1];
    }

    public static Double enterDeposit(Booking booking) {
        Scanner scanner = new Scanner(System.in);

        Map<Facility, Integer> facilityMap = ReadAndWriteFacility.readFacilityDataFile();

        Set<Facility> facilitySet = facilityMap.keySet();

        double deposit = 0d;
        for (Facility f : facilitySet) {
            if (f.getServiceCode().equals(booking.getServiceCode())) {
                System.out.println("Total payment: " + f.getPrice());
                do {
                    try {
                        System.out.println("Enter deposit:");
                        deposit = Double.parseDouble(scanner.nextLine());
                        if (deposit < 0) {
                            throw new UserException("deposit < 0");
                        } else if (deposit > f.getPrice()) {
                            throw new UserException("deposit > total payment");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Wrong format, enter again:");
                    } catch (UserException e) {
                        System.err.println(e.getMessage());
                    }
                } while (true);
            }
        }
        return deposit;
    }

//    public static Double getTotalPayment(Booking booking){
//        Map<Facility,Integer> facilityIntegerMap = ReadAndWriteFacility.readFacilityDataFile();
//        Set<Facility> facilitySet = facilityIntegerMap.keySet();
//        for (Facility f:facilitySet){
//            if (booking.getServiceCode().equals(f.getServiceCode())){
//
//            }
//        }
//
//
//    }
}
