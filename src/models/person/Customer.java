package models.person;

import java.time.LocalDate;

public class Customer extends Person{
    private String customerId;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, LocalDate dayOfBirth, String gender, String id, String phoneNumber, String email, String customerId, String customerType, String address) {
        super(name, dayOfBirth, gender, id, phoneNumber, email);
        this.customerId = customerId;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+ "," +getCustomerId()+ "," +getCustomerType()+ "," +getAddress();
    }

    @Override
    public String toString() {
        return super.toString() + ", Customer ID = " + customerId + ", Customer Type = " + customerType + ", Address = " + address;
    }
}
