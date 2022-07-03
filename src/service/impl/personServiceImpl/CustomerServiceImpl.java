package service.impl.personServiceImpl;

import models.person.Customer;
import service.person_service.CustomerService;
import util.enterInformation.PersonInfor.EnterPersonInfomation;
import util.ReadAndWriteFile.ReadAndWriteCustomer;
import util.enterInformation.Regex;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static Scanner scanner = new Scanner(System.in);
    @Override
    public void displayPerson() {
        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        int i = 1;
        for (Customer c : customers) {
            System.out.println((i++) + ". " + c.toString());
        }
        System.out.println("--------------------------------------------------------------------");
    }

    @Override
    public void addPerson() {
        List<Customer> customers = new LinkedList<>();

        String name = EnterPersonInfomation.enterName();

        LocalDate date = EnterPersonInfomation.enterDay("birthDay");

        String gender = EnterPersonInfomation.chooseGender();

        String id = EnterPersonInfomation.enterIdOfCustomer();

        String phoneNumber = EnterPersonInfomation.enterPhoneNumber();

        String email = EnterPersonInfomation.enterEmail();

        String customerId = EnterPersonInfomation.enterCustomerId();

        String customerType = EnterPersonInfomation.enterTypeOfCustomer();

        System.out.println("Enter address");
        String address = scanner.nextLine();

        customers.add(new Customer(name,date,gender,id,phoneNumber,email,customerId,customerType,address));

        ReadAndWriteCustomer.writeCustomerDataFile(customers,true);

    }

    @Override
    public void editPerson() {
        List<Customer> customers = ReadAndWriteCustomer.readCustomerDataFile();
        String customer = "";
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". Customer code : " + customers.get(i).getCustomerCode() + ", name: " + customers.get(i).getName());
        }
        do {
            System.out.println("Enter customer code of customer you want to edit");
            customer = scanner.nextLine();
            if (!Regex.checkCustomerIdFormat(customer)) {
                System.err.println("Wrong format, enter again:");
            }
        } while (!Regex.checkCustomerIdFormat(customer));

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerCode().equals(customer)) {
                String choose = "";
                do {
                    System.out.println("-----EDIT-----" +
                            "\n1.  edit name" +
                            "\n2.  edit day of birth" +
                            "\n3.  edit gender" +
                            "\n4.  edit ID" +
                            "\n5.  edit phone number" +
                            "\n6.  edit email" +
                            "\n7.  edit customer ID " +
                            "\n8.  edit customer type" +
                            "\n9.  edit address" +
                            "\n10. edit all information" +
                            "\n11. return to Employee Management" +
                            "\nEnter your choice");
                    choose = scanner.nextLine();
                    switch (choose) {
                        case "1":
                            customers.get(i).setName(EnterPersonInfomation.enterName());
                            break;
                        case "2":
                            customers.get(i).setDayOfBirth(EnterPersonInfomation.enterDay("day of birth"));
                            break;
                        case "3":
                            customers.get(i).setGender(EnterPersonInfomation.chooseGender());
                            break;
                        case "4":
                            customers.get(i).setId(EnterPersonInfomation.enterIdOfEmployee());
                            break;
                        case "5":
                            customers.get(i).setPhoneNumber(EnterPersonInfomation.enterPhoneNumber());
                            break;
                        case "6":
                            customers.get(i).setEmail(EnterPersonInfomation.enterEmail());
                            break;
                        case "7":
                            customers.get(i).setCustomerCode(EnterPersonInfomation.enterCustomerId());
                            break;
                        case "8":
                            customers.get(i).setCustomerType(EnterPersonInfomation.enterTypeOfCustomer());
                            break;
                        case "9":
                            customers.get(i).setAddress(scanner.nextLine());
                            break;
                        case "10": {
                            customers.remove(i);
                            ReadAndWriteCustomer.writeCustomerDataFile(customers,false);
                            addPerson();
                        }
                        break;
                        case "11": {
                            ReadAndWriteCustomer.writeCustomerDataFile(customers, false);
                            System.out.println("------Edited------");
                        }
                    }
                } while (!choose.equals("11"));

            }
        }
    }
}
