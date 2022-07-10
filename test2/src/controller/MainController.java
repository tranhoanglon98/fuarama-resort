package controller;

import service.BankAccountService;
import service.impl.BankAccountServiceImpl;

import java.util.Scanner;

public class MainController {
    private static BankAccountService bankAccountService;

    public static void displayMainMenu(){
        bankAccountService = new BankAccountServiceImpl();
        Scanner scanner =new Scanner(System.in);
        String choose;
        do {
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG –\n" +
                    "Chọn chức năng theo số (để tiếp tục):\n" +
                    "1. Thêm mới\n" +
                    "2. Xóa\n" +
                    "3. Xem danh sách các tài khoản ngân hàng\n" +
                    "4. Tìm kiếm\n" +
                    "5. Thoát\n" +
                    "\nChọn chức năng.");
            choose = scanner.nextLine();
            switch (choose){
                case "1":bankAccountService.addBankAccount();break;
                case "2":bankAccountService.deleteByAccountCode();break;
                case "3":bankAccountService.displayBankAccount();break;
                case "4":bankAccountService.findByAccountCodeOrName();break;
                case "5":
                    System.out.println("---Thoát---");
            }
        }while (!choose.equals("5"));
    }
}
