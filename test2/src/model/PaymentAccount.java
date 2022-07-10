package model;

import java.time.LocalDate;

public class PaymentAccount extends BankAccount {
    private String cardNumber;
    private double amountMoneyInAccount;

    public PaymentAccount() {
    }

    public PaymentAccount(int accountId, String accountCode, String accountName, LocalDate accountCreationDay, String cardNumber, double amountMoneyInAccount) {
        super(accountId, accountCode, accountName, accountCreationDay);
        this.cardNumber = cardNumber;
        this.amountMoneyInAccount = amountMoneyInAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmountMoneyInAccount() {
        return amountMoneyInAccount;
    }

    public void setAmountMoneyInAccount(double amountMoneyInAccount) {
        this.amountMoneyInAccount = amountMoneyInAccount;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+","+cardNumber+","+amountMoneyInAccount;
    }

    @Override
    public String toString() {
        return super.toString() + ", số thẻ: "+ cardNumber+", số tiền trong tài khoản: " +amountMoneyInAccount;
    }
}
