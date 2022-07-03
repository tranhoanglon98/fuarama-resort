package models.booking_contract;

import java.time.LocalDate;

public class Booking {
    private String bookingCode;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String customerCode;
    private String serviceName;
    private String service;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate checkInDate, LocalDate checkOutDate, String customerCode, String serviceName, String service) {
        this.bookingCode = bookingCode;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerCode = customerCode;
        this.serviceName = serviceName;
        this.service = service;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getInfoToCsvFile(){
        return bookingCode+","+ checkInDate +","+ checkOutDate +","+customerCode+","+serviceName+","+service;
    }
}
