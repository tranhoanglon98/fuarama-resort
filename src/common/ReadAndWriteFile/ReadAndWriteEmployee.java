package common.ReadAndWriteFile;

import models.person.Employee;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ReadAndWriteEmployee {
    private static final String PATH_FILE = "src/data/employee_data_file.csv";

    public static List<Employee> readEmployeeDataFile() {
        List<Employee> employees = new LinkedList<>();
        List<String> strings = ReadAndWriteFile.readDataFile(PATH_FILE);
        for (String s : strings) {
            String[] array = s.split(",");
            employees.add(new Employee(array[0], LocalDate.parse(array[1]), array[2], array[3], array[4], array[5], array[6], array[7], array[8], Double.parseDouble(array[9])));
        }
        return employees;
    }

    public static void writeEmployeeDataFile(List<Employee> employees, boolean append) {
        List<String> strings = new LinkedList<>();
        for (Employee c : employees) {
            strings.add(c.getInfoToCsvFile());
        }
        ReadAndWriteFile.writeDataFile(strings, PATH_FILE, append);
    }
}
