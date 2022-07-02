package service.impl.personServiceImpl;

import models.person.Employee;
import service.personService.EmployeeService;
import util.ReadAndWriteFile.ReadAndWriteEmployee;
import util.enterInformation.PersonInfor.EnterPersonInfomation;
import util.enterInformation.Regex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void displayPerson() {
        List<Employee> employees = ReadAndWriteEmployee.readEmployeeDataFile();
        int i = 1;
        for (Employee e : employees) {
            System.out.println((i++) + ". " + e.toString());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    @Override
    public void addPerson() {
        List<Employee> employees = new ArrayList<>();

        String name = EnterPersonInfomation.enterName();

        LocalDate date = EnterPersonInfomation.enterDay("birthDay");

        String gender = EnterPersonInfomation.chooseGender();

        String id = EnterPersonInfomation.enterIdOfEmployee();

        String phoneNumber = EnterPersonInfomation.enterPhoneNumber();

        String email = EnterPersonInfomation.enterEmail();

        String employeeId = EnterPersonInfomation.enterEmployeeId();

        String educationLevel = EnterPersonInfomation.chooseEducationLevel();

        String position = EnterPersonInfomation.choosePosition();

        double salary = EnterPersonInfomation.enterSalary();

        employees.add(new Employee(name, date, gender, id, phoneNumber, email, employeeId, educationLevel, position, salary));
        ReadAndWriteEmployee.writeEmployeeDataFile(employees, true);

    }

    @Override
    public void editPerson() {
        List<Employee> employees = ReadAndWriteEmployee.readEmployeeDataFile();
        String employeeId;
        for (int i = 0; i < employees.size(); i++) {
            System.out.println((i + 1) + ". Employee ID : " + employees.get(i).getEmployeeId() + ", name: " + employees.get(i).getName());
        }
        do {
            System.out.println("Enter employeeID of employee you want to edit");
            employeeId = scanner.nextLine();
            if (!Regex.checkEmployeeIdFormat(employeeId)) {
                System.out.println("Wrong format, enter again:");
            }
        } while (!Regex.checkEmployeeIdFormat(employeeId));

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeId().equals(employeeId)) {
                String choose;
                do {
                    System.out.println("-----EDIT-----" +
                            "\n1.  edit name" +
                            "\n2.  edit day of birth" +
                            "\n3.  edit gender" +
                            "\n4.  edit ID" +
                            "\n5.  edit phone number" +
                            "\n6.  edit email" +
                            "\n7.  edit employee ID " +
                            "\n8.  edit education level" +
                            "\n9.  edit position" +
                            "\n10. edit salary" +
                            "\n11. edit all information" +
                            "\n12. return to Employee Management" +
                            "\nEnter your choice");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            employees.get(i).setName(EnterPersonInfomation.enterName());
                            break;
                        case "2":
                            employees.get(i).setDayOfBirth(EnterPersonInfomation.enterDay("day of birth"));
                            break;
                        case "3":
                            employees.get(i).setGender(EnterPersonInfomation.chooseGender());
                            break;
                        case "4":
                            employees.get(i).setId(EnterPersonInfomation.enterIdOfEmployee());
                            break;
                        case "5":
                            employees.get(i).setPhoneNumber(EnterPersonInfomation.enterPhoneNumber());
                            break;
                        case "6":
                            employees.get(i).setEmail(EnterPersonInfomation.enterEmail());
                            break;
                        case "7":
                            employees.get(i).setEmployeeId(EnterPersonInfomation.enterEmployeeId());
                            break;
                        case "8":
                            employees.get(i).setEducationLevel(EnterPersonInfomation.chooseEducationLevel());
                            break;
                        case "9":
                            employees.get(i).setPosition(EnterPersonInfomation.choosePosition());
                            break;
                        case "10":
                            employees.get(i).setSalary(EnterPersonInfomation.enterSalary());
                            break;
                        case "11": {
                            employees.remove(i);
                            ReadAndWriteEmployee.writeEmployeeDataFile(employees, false);
                            addPerson();
                        }
                        break;
                        case "12": {
                            ReadAndWriteEmployee.writeEmployeeDataFile(employees, false);
                            System.out.println("------Edited------");
                        }
                    }
                } while (!choose.equals("12"));

            }
        }
    }
}
