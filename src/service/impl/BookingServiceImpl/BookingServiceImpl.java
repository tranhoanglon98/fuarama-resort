package service.impl.BookingServiceImpl;

import models.booking_contract.Booking;
import models.booking_contract.Contract;
import models.facility.Facility;
import service.booking_service.BookingService;
import common.ReadAndWriteFile.ReadAndWriteBookingContract;
import common.ReadAndWriteFile.ReadAndWriteFacility;
import common.UserException;
import common.enterInformation.bookingInfo.CheckBookingContractInfo;
import common.enterInformation.bookingInfo.EnterBookingContractInfo;
import java.time.LocalDate;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    @Override
    public void addNewBooking() {
        String customerCode = EnterBookingContractInfo.chooseCustomerToBooking();

        String serviceCode = null;
        try {
            serviceCode = EnterBookingContractInfo.chooseService();
        } catch (UserException e) {
            System.err.println(e.getMessage());
            return;
        }

        String bookingCode = EnterBookingContractInfo.enterBookingCode();

        LocalDate checkInDay = EnterBookingContractInfo.enterCheckInDay(serviceCode);

        LocalDate checkOutDay = EnterBookingContractInfo.enterCheckOutDay(checkInDay, serviceCode);

        String service;
        if (serviceCode.contains("VL")) {
            service = "Villa";
        } else if (serviceCode.contains("HO")) {
            service = "House";
        } else {
            service = "Room";
        }

        Set<Booking> bookings = ReadAndWriteBookingContract.readBookingDataFile();

        bookings.add(new Booking(bookingCode, checkInDay, checkOutDay, customerCode, serviceCode, service));

        ReadAndWriteBookingContract.writeBookingDataFile(bookings,bookingCode,false);

        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readFacilityDataFile();

        Set<Facility> facilityKeyList = facilityIntegerMap.keySet();

        for (Facility f : facilityKeyList) {
            if (f.getServiceCode().equals(serviceCode)) {
                facilityIntegerMap.replace(f, facilityIntegerMap.get(f) + 1);
                break;
            }
        }
        ReadAndWriteFacility.writeFacilityDataFile(facilityIntegerMap, false);
    }

    @Override
    public void displayBookingList() {
        CheckBookingContractInfo.checkBookingDate();
        Set<Booking> bookings = ReadAndWriteBookingContract.readBookingDataFile();
        int index = 1;
        for (Booking b : bookings) {
            System.out.println((index++) + ". " + b);
        }
    }

    @Override
    public void createNewContract() {
        CheckBookingContractInfo.checkBookingDate();
        Booking booking = CheckBookingContractInfo.findBookingNeedCreateContract();
        if (booking == null) {
            System.out.println("There is no 'booking' need to create contract.");
            return;
        }

        String bookingCode = booking.getBookingCode();

        String contractCode = EnterBookingContractInfo.getContractCode(bookingCode);

        double totalPayment = EnterBookingContractInfo.getTotalPayment(booking);

        double deposit = EnterBookingContractInfo.enterDeposit(totalPayment);

        String customerCode = booking.getCustomerCode();

        List<Contract> contracts = new ArrayList<>();
        contracts.add(new Contract(contractCode, bookingCode, deposit, totalPayment, customerCode));
        ReadAndWriteBookingContract.WriteContractDataFile(contracts, true);
    }

    @Override
    public void displayContractList() {
        List<Contract> contracts = ReadAndWriteBookingContract.ReadContractDataFile();
        int index = 1;
        for (Contract c : contracts) {
            System.out.println((index++) + ". " + c);
        }

    }

    @Override
    public void editContract() {
        List<Contract> contracts = ReadAndWriteBookingContract.ReadContractDataFile();
        Contract contractToEdit = EnterBookingContractInfo.chooseContractToEdit();
        for (Contract c : contracts) {
            if (c.getContractCode().equals(contractToEdit.getContractCode())) {
                double deposit = EnterBookingContractInfo.enterDeposit(c.getTotalPayment());
                c.setDeposit(deposit);
                break;
            }
        }
    }
}
