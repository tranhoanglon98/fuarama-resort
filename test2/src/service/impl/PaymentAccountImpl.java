package service.impl;

import common.EnterInformation;
import common.ReadAndWriteData;
import model.BankAccount;
import model.PaymentAccount;
import service.AddBankAccountService;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class PaymentAccountImpl implements AddBankAccountService {
    @Override
    public void addBankAccount() {

        int accountId = EnterInformation.getAccountId();

        String accountCode = EnterInformation.enterAccountCode();

        String name = EnterInformation.enterName();

        LocalDate creationDay = EnterInformation.enterDay("tạo tài khoản");

        String cardNumber = EnterInformation.enterCardNumber();

        double amountMoney = EnterInformation.enterMoney("số tiền trong tài khoản");

        List<BankAccount> bankAccountList = new LinkedList<>();
        bankAccountList.add(new PaymentAccount(accountId,accountCode,name,creationDay,cardNumber,amountMoney));
        ReadAndWriteData.writeDataFile(bankAccountList,true);
        System.out.println("đã thêm tài khoản thành công");

    }
}
