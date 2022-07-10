package common.enterInformation.PersonInfor;

import models.person.Customer;
import models.person.Employee;
import common.ReadAndWriteFile.ReadAndWriteCustomer;
import common.ReadAndWriteFile.ReadAndWriteEmployee;

import java.util.List;

public class CheckPersonInfomation {

    public static boolean checkEmployeeCode(String employeeId) {
            List<Employee> employees = ReadAndWriteEmployee.readEmployeeDataFile();
            for (Employee e : employees) {
                if (e.getEmployeeCode().equals(employeeId)) {
                    return true;
                }
            }
            return false;
        }

    public static boolean checkCustomerCode(String employeeId) {
        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        for (Customer c : customers) {
            if (c.getCustomerCode().equals(employeeId)) {
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