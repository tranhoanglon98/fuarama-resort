package util.enterInformation.PersonInfor;

import models.person.Customer;
import models.person.Employee;
import util.ReadAndWriteFile.ReadAndWriteCustomer;
import util.ReadAndWriteFile.ReadAndWriteEmployee;

import java.util.List;

public class CheckPersonInfomation {

    public static boolean checkEmployeeId(String employeeId) {
            List<Employee> employees = ReadAndWriteEmployee.readEmployeeDataFile();
            for (Employee e : employees) {
                if (e.getEmployeeId().equals(employeeId)) {
                    return true;
                }
            }
            return false;
        }

    public static boolean checkCustomerId(String employeeId) {
        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        for (Customer c : customers) {
            if (c.getCustomerId().equals(employeeId)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIdOfEmployee(String id){
        List<Employee> employees = ReadAndWriteEmployee.readEmployeeDataFile();
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkIdOfCustomer(String id) {
        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


}