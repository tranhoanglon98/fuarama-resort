package models.booking_contract;

import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private String bookingCode;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String customerCode;
    private String serviceCode;
    private String serviceName;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate checkInDate, LocalDate checkOutDate, String customerCode, String serviceCode, String serviceName) {
        this.bookingCode = bookingCode;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
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

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getInfoToCsvFile() {
        return bookingCode + "," + checkInDate + "," + checkOutDate + "," + customerCode + "," + serviceCode + "," + serviceName;
    }

    @Override
    public String toString() {
        return bookingCode+", service: " + serviceName+", check-in: "+ checkInDate+", check-out: "+checkOutDate+
                ", customer code: " + customerCode+", service code: " +serviceCode;
    }

    @Override
    public int compareTo(Booking o) {
        if (o.getCheckInDate().isBefore(this.checkInDate)) {
            return 1;
        } else if (o.getCheckInDate().isAfter(this.checkInDate)) {
            return -1;
        } else if (o.getCheckOutDate().isBefore(this.checkOutDate)) {
            return 1;
        } else if (o.getCheckOutDate().isAfter(this.checkOutDate)) {
            return -1;
        } else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(bookingCode, booking.bookingCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingCode);
    }
}
