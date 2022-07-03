package models.booking_contract;

import java.time.LocalDate;

public class Booking {
    private String bookingCode;
    private LocalDate startDay;
    private LocalDate endDay;
    private String customerCode;
    private String serviceName;
    private String service;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate startDay, LocalDate endDay, String customerCode, String serviceName, String service) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
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

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
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
        return bookingCode+","+startDay+","+ endDay +","+customerCode+","+serviceName+","+service;
    }
}
