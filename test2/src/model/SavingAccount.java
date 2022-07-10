package model;

import java.time.LocalDate;

public class SavingAccount extends BankAccount{
    private double savingsDepositAmount;
    private LocalDate savingDay;
    private int interestRate;
    private int savingTerm;

    public SavingAccount() {
    }

    public SavingAccount(int accountId, String accountCode, String accountName, LocalDate accountCreationDay, double savingsDepositAmount, LocalDate savingDay, int interestRate, int savingTerm) {
        super(accountId, accountCode, accountName, accountCreationDay);
        this.savingsDepositAmount = savingsDepositAmount;
        this.savingDay = savingDay;
        this.interestRate = interestRate;
        this.savingTerm = savingTerm;
    }

    public double getSavingsDepositAmount() {
        return savingsDepositAmount;
    }

    public void setSavingsDepositAmount(double savingsDepositAmount) {
        this.savingsDepositAmount = savingsDepositAmount;
    }

    public LocalDate getSavingDay() {
        return savingDay;
    }

    public void setSavingDay(LocalDate savingDay) {
        this.savingDay = savingDay;
    }

    public int getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }

    public int getSavingTerm() {
        return savingTerm;
    }

    public void setSavingTerm(int savingTerm) {
        this.savingTerm = savingTerm;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+","+savingsDepositAmount+","+savingDay+","+interestRate+","+savingTerm;
    }

    @Override
    public String toString() {
        return super.toString()+",số tiền tiết kiệm:"+savingsDepositAmount+", ngày gửi tiết kiệm"+savingDay+", lãi suất " +interestRate+", kì hạn " + savingTerm;
    }
}
