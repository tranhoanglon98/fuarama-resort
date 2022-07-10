package service.impl;

import common.FindAccount;
import common.NotFoundBankAccountException;
import common.ReadAndWriteData;
import common.Regex;
import model.BankAccount;
import service.AddBankAccountService;
import service.BankAccountService;

import java.util.List;
import java.util.Scanner;

public class BankAccountServiceImpl implements BankAccountService {
    private final Scanner SCANNER = new Scanner(System.in);
    private final AddBankAccountService paymentAccount = new PaymentAccountImpl();
    private final AddBankAccountService savingAccount = new SavingAccountServiceImpl();

    @Override
    public void addBankAccount() {
        String choose;
        do {
            System.out.println("---CHỨC NĂNG THÊM MỚI TÀI KHOẢN---" +
                    "\n1. Thêm mới tài khoản tiết kiệm." +
                    "\n2. Thêm mới tài khoản thanh toán." +
                    "\n3. Trở lại." +
                    "\nNhập lựa chọn của bạn");
            choose = SCANNER.nextLine();
            switch (choose){
                case "1":savingAccount.addBankAccount();break;
                case "2":paymentAccount.addBankAccount();break;
                case "3":
                    System.out.println("---TRỞ LẠI---");
            }
        }while (!choose.equals("3"));
    }

    @Override
    public void deleteByAccountCode() {
        List<BankAccount> bankAccountList = ReadAndWriteData.readDataFile();
        String accountCode;
        boolean isAccountExist = false;
        do {
            System.out.println("nhập mã tài khoản bạn muốn xóa");
            accountCode = SCANNER.nextLine();
           try {
               if (Regex.checkAccountCodeFormat(accountCode)){
                   break;
               }else {
                   throw new NotFoundBankAccountException("Tài khoản không tồn tại");
               }
           }catch (NotFoundBankAccountException e){
               System.err.println(e.getMessage()+", hãy nhập lại");
           }
        }while (true);

        for (int i = 0; i <bankAccountList.size() ; i++) {

            if (bankAccountList.get(i).getAccountCode().equals(accountCode)){
                String choose;
                isAccountExist = true;
                do {
                    System.out.println("nhập 'yes' nếu bạn muốn xóa, nhập 'no' nếu bạn không muốn xóa");
                    choose = SCANNER.nextLine();
                    if (!choose.equalsIgnoreCase("yes")&&!choose.equalsIgnoreCase("no")){
                        System.err.println("chỉ nhập 'yes' hoặc 'no', hãy nhập lại");
                    }else {
                        if (choose.equals("yes")){
                            bankAccountList.remove(bankAccountList.get(i));
                            System.out.println("xóa thành công");
                        }
                        break;
                    }
                }while (!choose.equalsIgnoreCase("yes")&&!choose.equalsIgnoreCase("no"));
            }else isAccountExist =false;

        }
        if (!isAccountExist){
            System.out.println("không có mã tài khoản bạn vừa nhập trong dữ liệu");
        }
        ReadAndWriteData.writeDataFile(bankAccountList,false);
    }

    @Override
    public void displayBankAccount() {
        List<BankAccount> bankAccounts = ReadAndWriteData.readDataFile();
        if (bankAccounts.isEmpty()){
            System.out.println("hiện không có tài khoản nào để hiển thị");
        }else {
            for (BankAccount bankAccount:bankAccounts){
                System.out.println(bankAccount);
            }
        }
    }

    @Override
    public void findByAccountCodeOrName() {
        String choose;
        do {
            System.out.println("---CHỨC NĂNG TÌM KIẾM---" +
                    "\n1. Tìm theo mã tài khoản." +
                    "\n2. Tìm theo tên." +
                    "\n3. Trở lại." +
                    "\nNhập lựa chọn của bạn");
            choose = SCANNER.nextLine();
            switch (choose){
                case "1":
                    FindAccount.findByAccountCode();break;
                case "2":FindAccount.findByAccountName();break;
                case "3":
                    System.out.println("---TRỞ LẠI---");break;
            }
        }while (!choose.equals("3"));



    }
}
