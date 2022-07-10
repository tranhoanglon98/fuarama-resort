package common;

import model.BankAccount;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class EnterInformation {
    private static final Scanner SCANNER = new Scanner(System.in);


    public static int getAccountId() {
        List<BankAccount> bankAccountList = ReadAndWriteData.readDataFile();
        int accountId;
        if (bankAccountList.isEmpty()) {
            accountId = 1;
        } else {
            accountId = bankAccountList.get(bankAccountList.size() - 1).getAccountId() + 1;
        }
        return accountId;
    }

    public static String enterAccountCode() {
        String accountCode;
        do {
            System.out.println("nhập mã tài khoản (9 số)");
            accountCode = SCANNER.nextLine();
            if (Regex.checkAccountCodeFormat(accountCode)) {
                break;
            } else {
                System.err.println("sai định dạng, hãy nhập lại:");
            }
        } while (true);
        return accountCode;
    }

    public static String enterName(){
        String name;
        do {
            System.out.println("nhập tên tài khoản (vd: Trần Văn A)");
            name = SCANNER.nextLine();
            if (Regex.checkNameFormat(name)) {
                break;
            } else {
                System.err.println("sai định dạng, hãy nhập lại:");
            }
        } while (true);
        return name;
    }

    public static String enterCardNumber() {
        String cardNumber;
        do {
            System.out.println("nhập số tài khoản (16 số)");
            cardNumber = SCANNER.nextLine();
            if (Regex.checkCardNumberFormat(cardNumber)) {
                break;
            } else {
                System.err.println("sai định dạng, hãy nhập lại:");
            }
        } while (true);
        return cardNumber;
    }

    public static double enterMoney(String money){
        double returnMoney;
        do {
            System.err.println("nhập "+ money);
            try {
                returnMoney = Double.parseDouble(SCANNER.nextLine());
                if (returnMoney<0){
                    System.err.println(money + " không được nhỏ hơn 0");
                }else break;
            }catch (NumberFormatException e){
                System.err.println("sai định dạng, hãy nhập lại:");
            }
        }while (true);
        return returnMoney;
    }

    public static LocalDate enterDay(String day) {
        LocalDate returnDay;
        do {
            System.out.println("nhập ngày " + day);
            try {
                returnDay = LocalDate.parse(SCANNER.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println(e.getMessage());
                System.err.println("nhập sai định dạng, hãy nhập lại");
            }
        } while (true);
        return returnDay;
    }

    public static LocalDate enterSavingDay(LocalDate creationDay){
        LocalDate savingDay;
        do {
            savingDay = enterDay("gửi tiết kiệm");
            if (savingDay.isBefore(creationDay)){
                System.err.println("ngày gửi tiết kiệm không được sớm hơn ngày tạo tài khoản, hãy nhập lại.");
            }else break;

        }while (true);

        return savingDay;
    }

    public static int enterInterestRate(){
        int interestRate;
        do {
            System.out.println("nhập lãi suất");
            try {
                interestRate = Integer.parseInt(SCANNER.nextLine());
                if (interestRate<0){
                    System.err.println("lãi suất không được nhỏ hơn 0");
                }else break;
            }catch (NumberFormatException e){
                System.err.println(e.getMessage()+", hãy nhập lại.");
            }
        }while (true);
        return interestRate;
    }

    public static int enterSavingTerm(){
        int savingTerm;
        do {
            System.err.println("nhập kì hạn");
            try {
                savingTerm = Integer.parseInt(SCANNER.nextLine());
                if (savingTerm<1){
                    System.err.println("kì hạn không được nhỏ hơn 1 tháng, hãy nhập lại");
                }else break;
            }catch (NumberFormatException e){
                System.err.println(e.getMessage()+", hãy nhập lại");
            }
        }while (true);

        return savingTerm;
    }
}
