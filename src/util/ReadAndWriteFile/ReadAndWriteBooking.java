package util.ReadAndWriteFile;

import models.booking_contract.Booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteBooking {
    private static final String BOOKING_PATH_FILE = "src/data/booking_data_file.csv";
    private static final String CONTRACT_PATH_FILE = "src/data/contract_data_file.csv";

    public static List<Booking> readBookingDataFile() {
        List<Booking> bookings = new ArrayList<>();
        List<String> strings = ReadAndWriteFile.readDataFile(BOOKING_PATH_FILE);
        for (String s : strings) {
            String[] array = s.split(",");
            bookings.add(new Booking(array[0], LocalDate.parse(array[1]),LocalDate.parse(array[2]), array[3], array[4], array[5]));
        }
        return bookings;
    }

    public static void writeCustomerDataFile(List<Booking> bookings, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Booking b : bookings) {
            strings.add(b.getInfoToCsvFile());
        }
        ReadAndWriteFile.writeDataFile(strings, BOOKING_PATH_FILE, append);
    }
}
