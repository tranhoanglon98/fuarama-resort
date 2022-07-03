package controller;

import service.facility_service.FacilityService;
import service.impl.facilityServiceImpl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private static FacilityService facilityService = new FacilityServiceImpl();
    public static void facilityManagement() {
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1\tDisplay list facility\n" +
                    "2\tAdd new facility\n" +
                    "3\tDisplay list facility maintenance\n" +
                    "4\tReturn main menu\n");
            System.out.println("Enter your choice:");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":facilityService.displayFacilityList();break;
                case "2":facilityService.addFacility();break;
                case "3":
                case "4":
                    System.out.println("---- Return main menu ----");
                    break;
            }
        } while (!choose.equals("4"));
    }
}
