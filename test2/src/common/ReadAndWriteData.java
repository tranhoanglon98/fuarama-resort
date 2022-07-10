package common;

import model.BankAccount;
import model.PaymentAccount;
import model.SavingAccount;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteData {
    private static final String PATH_FILE = "src/data/bank_account_data_file.csv";

    //
    public static List<BankAccount> readDataFile() {
        List<BankAccount> products = new LinkedList<>();
        File file = new File(PATH_FILE);
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader(file);
            br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                String[] array = line.split(",");
                if (array.length == 6) {
                    products.add(new PaymentAccount(Integer.parseInt(array[0]), array[1], array[2], LocalDate.parse(array[3]), array[4], Double.parseDouble(array[5])));
                } else if (array.length == 8) {
                    products.add(new SavingAccount(Integer.parseInt(array[0]), array[1], array[2], LocalDate.parse(array[3]), Double.parseDouble(array[4]),
                            LocalDate.parse(array[5]), Integer.parseInt(array[6]), Integer.parseInt(array[7])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return products;
    }


    public static void writeDataFile(List<BankAccount> bankAccounts, boolean append) {
        File file = new File(PATH_FILE);
        FileWriter fileWriter = null;
        BufferedWriter bw = null;
        try {
            fileWriter = new FileWriter(file, append);
            bw = new BufferedWriter(fileWriter);
            for (BankAccount bankAccount : bankAccounts) {
                bw.write(bankAccount.getInfoToCsvFile());
                bw.newLine();
            }
            bw.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}