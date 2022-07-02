package util.enterInformation.PersonInfor;

import util.enterInformation.Regex;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EnterPersonInfomation {
    private static Scanner scanner = new Scanner(System.in);

    public static String chooseEducationLevel() {
        String educationLevel = "";
        String choose = "";
        boolean flag = false;
        do {
            flag = false;
            System.out.println("1. Đại Học" +
                    "\n2. Cao đẳng" +
                    "\n3. Trung cấp" +
                    "\n4. Sau đại học" +
                    "\n5. 12/12" +
                    "\nEnter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    educationLevel = "Đại học";
                    break;
                case "2":
                    educationLevel = "Cao đẳng";
                    break;
                case "3":
                    educationLevel = "Trung cấp";
                    break;
                case "4":
                    educationLevel = "Sau đại học";
                    break;
                case "5":
                    educationLevel = "12/12";
                    break;
                default:
                    flag = true;
            }
        } while (flag);

        return educationLevel;

    }

    public static String choosePosition() {
        String position = "";
        String choose = "";
        boolean flag = false;
        do {
            flag = false;
            System.out.println("1. Lễ tân" +
                    "\n2. Phục vụ" +
                    "\n3. Chuyên viên" +
                    "\n4. Giám sát" +
                    "\n5. Quản lý" +
                    "\n6. Giám đốc" +
                    "\nEnter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    position = "Lễ tân";
                    break;
                case "2":
                    position = "Phục vụ";
                    break;
                case "3":
                    position = "Chuyên viên";
                    break;
                case "4":
                    position = "Giám sát";
                    break;
                case "5":
                    position = "Quản lý";
                    break;
                case "6":
                    position = "Giám đốc";
                    break;
                default:
                    flag = true;
            }
        } while (flag);

        return position;
    }

    public static String chooseGender() {
        String choose = "";
        String gender = "";
        boolean flag = false;
        do {
            flag = false;
            System.out.println("Gender:" +
                    "\n1. Male" +
                    "\n2. Female" +
                    "\nEnter your choice:");
            choose = scanner.nextLine();
            if (choose.equals("1")) {
                gender = "Male";
            } else if (choose.equals("2")) {
                gender = "Female";
            } else {
                System.out.println("choose again:");
                flag = true;
            }
        } while (flag);
        return gender;
    }

    public static LocalDate enterDay(String day) {
        boolean flag = false;
        LocalDate localDate = null;
        do {
            flag = false;
            System.out.println("Enter " + day);
            try {
                localDate = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int age = Period.between(localDate, LocalDate.now()).getYears();
                if (age < 18 || age > 100) {
                    throw new Exception("age > 100 or age < 18");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Wrong format, enter again");
                flag = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flag = true;
            }
        } while (flag);
        return localDate;
    }

    public static String enterName() {
        String name;
        do {
            System.out.println("Enter name:");
            name = scanner.nextLine();
            if (!Regex.checkNameFormat(name)) {
                System.out.println("Wrong format, enter again:");
            }
        } while (!Regex.checkNameFormat(name));
        return name;
    }

    public static String enterIdOfEmployee() {
        String id = "";
        do {
            System.out.println("Enter id (12 numbers)");
            id = scanner.nextLine();
            if (!Regex.checkIdFormat(id)) {
                System.out.println("Wrong format, enter again:");
            } else if (CheckPersonInfomation.checkIdOfEmployee(id)) {
                System.out.println("Id already exits, enter again:");
            }
        } while (!Regex.checkIdFormat(id) || CheckPersonInfomation.checkIdOfEmployee(id));
        return id;
    }

    public static String enterIdOfCustomer() {
        String id = "";
        do {
            System.out.println("Enter id (12 numbers)");
            id = scanner.nextLine();
            if (!Regex.checkIdFormat(id)) {
                System.out.println("Wrong format, enter again:");
            } else if (CheckPersonInfomation.checkIdOfCustomer(id)) {
                System.out.println("Id already exits, enter again:");
            }
        } while (!Regex.checkIdFormat(id) || CheckPersonInfomation.checkIdOfCustomer(id));
        return id;
    }

    public static String enterPhoneNumber() {
        String phoneNumber = "";
        do {
            System.out.println("Enter phone number (0xxxxxxxx : 10 numbers)");
            phoneNumber = scanner.nextLine();
            if (!Regex.checkPhoneNumberFormat(phoneNumber)) {
                System.out.println("Wrong format, enter again:");
            }
        } while (!Regex.checkPhoneNumberFormat(phoneNumber));
        return phoneNumber;
    }

    public static String enterEmail() {
        String email = "";
        do {
            System.out.println("Enter email:");
            email = scanner.nextLine();
            if (!Regex.checkEmailFormat(email)) {
                System.out.println("Wrong format, enter again:");
            }
        } while (!Regex.checkEmailFormat(email));
        return email;
    }

    public static String enterEmployeeId() {
        String employeeId = "";
        do {
            System.out.println("Enter employee id (E-123456)");
            employeeId = scanner.nextLine();
            if (!Regex.checkEmployeeIdFormat(employeeId)) {
                System.out.println("Wrong format, enter again:");
            } else if (CheckPersonInfomation.checkEmployeeId(employeeId)) {
                System.out.println("Employee Id already exits, enter again:");
            }
        } while (!Regex.checkEmployeeIdFormat(employeeId) || CheckPersonInfomation.checkEmployeeId(employeeId));
        return employeeId;
    }

    public static Double enterSalary() {
        double salary = 0;
        boolean flag = false;
        do {
            try {
                System.out.println("Enter salary");
                salary = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong format, enter again:");
                flag = true;
            }
        } while (flag);
        return salary;
    }

    public static String enterCustomerId() {
        String customerId = "";
        do {
            System.out.println("Enter customer id (C-123456)");
            customerId = scanner.nextLine();
            if (!Regex.checkCustomerIdFormat(customerId)) {
                System.out.println("Wrong format, enter again:");
            } else if (CheckPersonInfomation.checkCustomerId(customerId)) {
                System.out.println("Customer Id already exits, enter again:");
            }
        } while (!Regex.checkCustomerIdFormat(customerId) || CheckPersonInfomation.checkCustomerId(customerId));
        return customerId;
    }

    public static String enterTypeOfCustomer() {
        String customerType = "";
        String choose = "";
        boolean flag = false;
        do {
            flag = false;
            System.out.println("1. Diamond" +
                    "\n2. Platinum" +
                    "\n3. Gold" +
                    "\n4. Silver" +
                    "\n5. Member" +
                    "\n----Enter your choice----");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    customerType = "Diamond";
                    break;
                case "2":
                    customerType = "Platinum";
                    break;
                case "3":
                    customerType = "Gold";
                    break;
                case "4":
                    customerType = "Silver";
                    break;
                case "5":
                    customerType = "Member";
                    break;
                default: {
                    System.out.println("just choose from 1 to 5, choose again:");
                    flag = true;
                }
            }
        } while (flag);

        return customerType;
    }

}
