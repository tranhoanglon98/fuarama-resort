package models.person;

import java.time.LocalDate;

public class Customer extends Person{
    private String customerCode;
    private String customerType;
    private String address;

    public Customer() {
    }

    public Customer(String name, LocalDate dayOfBirth, String gender, String id, String phoneNumber, String email, String customerCode, String customerType, String address) {
        super(name, dayOfBirth, gender, id, phoneNumber, email);
        this.customerCode = customerCode;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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
        return super.getInfoToCsvFile()+ "," + getCustomerCode()+ "," +getCustomerType()+ "," +getAddress();
    }

    @Override
    public String toString() {
        return super.toString() + ", Customer ID = " + customerCode + ", Customer Type = " + customerType + ", Address = " + address;
    }
}
