package util.enterInformation.bookingInfo;

import models.booking_contract.Booking;
import models.booking_contract.Contract;
import util.ReadAndWriteFile.ReadAndWriteBookingContract;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CheckBookingContractInfo {

    public static void checkBookingDate(){
        Set<Booking> bookings = ReadAndWriteBookingContract.readBookingDataFile();
        for (Booking b:bookings){
            if (b.getCheckOutDate().isBefore(LocalDate.now())){
                bookings.remove(b);
            }
        }
        ReadAndWriteBookingContract.writeBookingDataFile(bookings, ReadAndWriteBookingContract.readMaxBookingCode(),false);
    }

    public static Booking findBookingNeedCreateContract(){
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
                for (Contract c : contracts) {
                    if (c.getBookingCode().equals(bookingCode)) {
                        bookingQueue.poll();
                        flag =true;
                        break;
                    }else {
                        flag =false;
                    }
                }
            }
            
           return bookingQueue.poll();
        }
    }
}
