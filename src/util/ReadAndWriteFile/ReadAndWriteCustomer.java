package util.ReadAndWriteFile;

import models.person.Customer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteCustomer {
    private static final String PATH_FILE = "src/data/customer_data_file.csv";

    public static List<Customer> readCustomerDataFile() {
        List<Customer> customers = new LinkedList<>();
        List<String> strings = ReadAndWriteFile.readDataFile(PATH_FILE);
        for (String s : strings) {
            String[] array = s.split(",");
            customers.add(new Customer(array[0], LocalDate.parse(array[1]), array[2], array[3], array[4], array[5], array[6], array[7], array[8]));
        }
        return customers;
    }

    public static void writeCustomerDataFile(List<Customer> customers, boolean append) {
        List<String> strings = new LinkedList<>();
        for (Customer c : customers) {
            strings.add(c.getInfoToCsvFile());
        }
        ReadAndWriteFile.writeDataFile(strings, PATH_FILE, append);
    }
}
