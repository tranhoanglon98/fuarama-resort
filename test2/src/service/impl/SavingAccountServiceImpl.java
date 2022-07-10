package service.impl;

import common.EnterInformation;
import common.ReadAndWriteData;
import model.BankAccount;
import model.PaymentAccount;
import model.SavingAccount;
import service.AddBankAccountService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class SavingAccountServiceImpl implements AddBankAccountService {
    @Override
    public void addBankAccount() {
        int accountId = EnterInformation.getAccountId();

        String accountCode = EnterInformation.enterAccountCode();

        String name = EnterInformation.enterName();

        LocalDate creationDay = EnterInformation.enterDay("tạo tài khoản");

        double savingsDepositAmount = EnterInformation.enterMoney("tiền tiết kiệm");

        LocalDate savingDay = EnterInformation.enterSavingDay(creationDay);

        int interestRate = EnterInformation.enterInterestRate();

        int savingTerm = EnterInformation.enterSavingTerm();


        List<BankAccount> bankAccountList = new LinkedList<>();
        bankAccountList.add(new SavingAccount(accountId,accountCode,name,creationDay,savingsDepositAmount,savingDay,interestRate,savingTerm));
        ReadAndWriteData.writeDataFile(bankAccountList,true);
        System.out.println("đã thêm tài khoản thành công");
    }
}
