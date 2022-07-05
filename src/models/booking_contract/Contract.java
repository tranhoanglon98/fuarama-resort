package models.booking_contract;

public class Contract {
    private String contractCode;
    private String bookingCode;
    private double deposit;
    private double totalPayment;
    private String customerCode;

    public Contract() {
    }

    public Contract(String contractCode, String bookingCode, double deposit, double totalPayment, String customerCode) {
        this.contractCode = contractCode;
        this.bookingCode = bookingCode;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.customerCode = customerCode;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public  String  getInfoToCsvFile(){
        return contractCode+","+bookingCode+","+deposit+","+totalPayment+","+customerCode;
    }
}
