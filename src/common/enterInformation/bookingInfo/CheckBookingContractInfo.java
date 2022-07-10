package common.enterInformation.bookingInfo;

import models.booking_contract.Booking;
import models.booking_contract.Contract;
import common.ReadAndWriteFile.ReadAndWriteBookingContract;

import java.time.LocalDate;
import java.util.*;

public class CheckBookingContractInfo {

    public static void checkBookingDate() {
        Set<Booking> bookings = ReadAndWriteBookingContract.readBookingDataFile();
        List<Booking> bookingList = new ArrayList<>();
        bookingList.addAll(bookings);
        for (int i = 0; i < bookingList.size(); i++) {
            if (bookingList.get(i).getCheckOutDate().isBefore(LocalDate.now())) {
                bookingList.remove(bookingList.get(i));i--;
            }
        }
        ReadAndWriteBookingContract.writeBookingDataFile(bookings, ReadAndWriteBookingContract.readMaxBookingCode(), false);
    }

    public static Booking findBookingNeedCreateContract() {
        Set<Booking> bookings = ReadAndWriteBookingContract.readBookingDataFile();
        Queue<Booking> bookingQueue = new ArrayDeque<>();
        for (Booking b : bookings) {
            if (!b.getServiceCode().contains("RO")) {
                bookingQueue.add(b);
            }
        }

        if (bookingQueue.isEmpty()) {
            return null;
        } else {
            List<Contract> contracts = ReadAndWriteBookingContract.ReadContractDataFile();

            boolean flag = true;
            while (flag) {
                String bookingCode = bookingQueue.peek().getBookingCode();
                if (contracts.isEmpty()) {
                    return bookingQueue.poll();
                } else {
                    for (Contract c : contracts) {
                        if (c.getBookingCode().equals(bookingCode)) {
                            bookingQueue.poll();
                            flag = true;
                            break;
                        } else {
                            flag = false;
                        }
                    }
                }
            }

            return bookingQueue.poll();
        }
    }

}
