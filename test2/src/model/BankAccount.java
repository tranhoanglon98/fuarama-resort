package model;

import java.time.LocalDate;

public abstract class BankAccount {
    private int accountId;
    private String accountCode;
    private String accountName;
    private LocalDate accountCreationDay;

    public BankAccount() {
    }

    public BankAccount(int accountId, String accountCode, String accountName, LocalDate accountCreationDay) {
        this.accountId = accountId;
        this.accountCode = accountCode;
        this.accountName = accountName;
        this.accountCreationDay = accountCreationDay;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDate getAccountCreationDay() {
        return accountCreationDay;
    }

    public void setAccountCreationDay(LocalDate accountCreationDay) {
        this.accountCreationDay = accountCreationDay;
    }

    public String getInfoToCsvFile(){
        return accountId+","+accountCode+","+accountName+","+accountCreationDay;
    }

    @Override
    public String toString() {
        return "id tài khoản: " + accountId +
                ", mã tài khoản'" + accountCode +
                ", tên chủ tài khoản: " + accountName +
                ", ngày tạo tài khoản: " + accountCreationDay;
    }
}
