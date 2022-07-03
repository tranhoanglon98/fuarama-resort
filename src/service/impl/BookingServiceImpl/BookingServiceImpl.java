package service.impl.BookingServiceImpl;

import models.booking_contract.Booking;
import service.booking_service.BookingService;
import util.ReadAndWriteFile.ReadAndWriteBooking;
import util.enterInformation.bookingInfo.EnterBookingInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public void addNewBooking() {
        String customerCode = EnterBookingInfo.chooseCustomerToBooking();

        String serviceName = EnterBookingInfo.chooseService();

        String bookingCode = EnterBookingInfo.enterBookingCode();

        LocalDate checkInDay = EnterBookingInfo.enterCheckInDay();

        LocalDate checkOutDay = EnterBookingInfo.enterCheckOutDay(checkInDay, serviceName);

        String service;
        if (serviceName.contains("VL")) {
            service = "Villa";
        } else if (serviceName.contains("HO")) {
            service = "House";
        } else {
            service = "Room";
        }

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(bookingCode, checkInDay, checkOutDay, customerCode, serviceName, service));
        ReadAndWriteBooking.writeCustomerDataFile(bookings, true);
    }

    @Override
    public void displayBookingList() {

    }

    @Override
    public void createNewContract() {

    }

    @Override
    public void displayContractList() {

    }

    @Override
    public void editContract() {

    }
}
