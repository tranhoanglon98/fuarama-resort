package common;

import model.BankAccount;

import java.util.List;
import java.util.Scanner;

public class FindAccount {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void findByAccountCode(){
        List<BankAccount> bankAccountList = ReadAndWriteData.readDataFile();
        String accountCode;
        System.out.println("Nhập mã tài khoản bạn muốn tìm");
        accountCode =SCANNER.nextLine();
        boolean isMatch = false;
        for (BankAccount bankAccount:bankAccountList){
            if (bankAccount.getAccountCode().contains(accountCode)){
                System.out.println(bankAccount);
                isMatch = true;
            }
        }
        if (!isMatch){
            System.out.println("không có mã tài khoản nào trùng khớp với mã bạn muốn tìm");
        }
    }

    public static void findByAccountName(){
        List<BankAccount> bankAccountList = ReadAndWriteData.readDataFile();
        String accountName;
        System.out.println("Nhập tên chủ tài khoản bạn muốn tìm");
        accountName =SCANNER.nextLine();
        boolean isMatch = false;
        for (BankAccount bankAccount:bankAccountList){
            if (bankAccount.getAccountName().contains(accountName)){
                System.out.println(bankAccount);
                isMatch = true;
            }
        }
        if (!isMatch){
            System.out.println("không có tên nào trùng khớp với tên bạn muốn tìm");
        }
    }
}
