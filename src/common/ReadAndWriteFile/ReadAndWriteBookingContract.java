package common.ReadAndWriteFile;

import models.booking_contract.Booking;
import models.booking_contract.Contract;

import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteBookingContract {
    private static final String BOOKING_PATH_FILE = "src/data/booking_data_file.csv";
    private static final String CONTRACT_PATH_FILE = "src/data/contract_data_file.csv";

    public static Set<Booking> readBookingDataFile() {
        Set<Booking> bookings = new TreeSet<>();
        List<String> strings = ReadAndWriteFile.readDataFile(BOOKING_PATH_FILE);
        for (int i = 1; i < strings.size(); i++) {
            String[] array = strings.get(i).split(",");
            bookings.add(new Booking(array[0], LocalDate.parse(array[1]), LocalDate.parse(array[2]), array[3], array[4], array[5]));
        }

        return bookings;
    }

    public static String readMaxBookingCode() {
        List<String> strings = ReadAndWriteFile.readDataFile(BOOKING_PATH_FILE);
        if (strings.isEmpty()) {
            return null;
        } else {
            return strings.get(0);
        }
    }

    public static void writeBookingDataFile(Set<Booking> bookings, String currentlyBookingCode, boolean append) {
        List<String> strings = new ArrayList<>();
        strings.add(currentlyBookingCode);
        for (Booking b : bookings) {
            strings.add(b.getInfoToCsvFile());
        }
        ReadAndWriteFile.writeDataFile(strings, BOOKING_PATH_FILE, append);
    }

    public static List<Contract> ReadContractDataFile() {
        List<String> strings = ReadAndWriteFile.readDataFile(CONTRACT_PATH_FILE);
        List<Contract> contracts = new LinkedList<>();
        for (String s : strings) {
            String[] array = s.split(",");
            contracts.add(new Contract(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), array[4]));
        }
        return contracts;
    }

    public static void WriteContractDataFile(List<Contract> contracts, boolean append) {
        List<String> strings = new LinkedList<>();
        for (Contract c : contracts) {
            strings.add(c.getInfoToCsvFile());
        }
        ReadAndWriteFile.writeDataFile(strings,CONTRACT_PATH_FILE,append);
    }

}
