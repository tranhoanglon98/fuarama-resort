package service.impl.BookingServiceImpl;

import models.booking_contract.Booking;
import models.facility.Facility;
import service.booking_service.BookingService;
import util.ReadAndWriteFile.ReadAndWriteBooking;
import util.ReadAndWriteFile.ReadAndWriteFacility;
import util.enterInformation.bookingInfo.EnterBookingInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingServiceImpl implements BookingService {
    @Override
    public void addNewBooking() {
        String customerCode = EnterBookingInfo.chooseCustomerToBooking();

        String serviceCode = EnterBookingInfo.chooseService();

        String bookingCode = EnterBookingInfo.enterBookingCode();

        LocalDate checkInDay = EnterBookingInfo.enterCheckInDay(serviceCode);

        LocalDate checkOutDay = EnterBookingInfo.enterCheckOutDay(checkInDay, serviceCode);

        String service;
        if (serviceCode.contains("VL")) {
            service = "Villa";
        } else if (serviceCode.contains("HO")) {
            service = "House";
        } else {
            service = "Room";
        }

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(bookingCode, checkInDay, checkOutDay, customerCode, serviceCode, service));
        ReadAndWriteBooking.writeBookingDataFile(bookings, true);

        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> facilityKeyList = new ArrayList<>(facilityIntegerMap.keySet());
        for (Facility f : facilityKeyList) {
            if (f.getServiceCode().equals(serviceCode)) {
                facilityIntegerMap.put(f, facilityIntegerMap.get(f) + 1);
                break;
            }
        }
        ReadAndWriteFacility.writeFacilityDataFile(facilityIntegerMap, false);
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
