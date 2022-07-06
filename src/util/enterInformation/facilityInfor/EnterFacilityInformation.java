package util.enterInformation.facilityInfor;

import models.facility.Facility;
import util.ReadAndWriteFile.ReadAndWriteFacility;
import util.enterInformation.Regex;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EnterFacilityInformation {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String enterServiceCode(String service) {
        Map<Facility, Integer> facilityMap = ReadAndWriteFacility.readFacilityDataFile();
        Set<Facility> facilities = facilityMap.keySet();
        List<Facility> maintenanceFacility = ReadAndWriteFacility.readFacilityMaintenanceDataFile();
        boolean isServiceCodeExist;
        String serviceCode = "";
        do {
            isServiceCodeExist = false;
            switch (service) {
                case "house": {
                    System.out.println("Enter service code(ex: SVHO-0001)");
                    serviceCode = SCANNER.nextLine();
                }
                break;
                case "villa": {
                    System.out.println("Enter service name(ex: SVVL-0001)");
                    serviceCode = SCANNER.nextLine();
                }
                break;
                case "room": {
                    System.out.println("Enter service name(ex: SVRO-0001)");
                    serviceCode = SCANNER.nextLine();
                }
                break;
            }
            if (!Regex.checkServiceCodeFormat(serviceCode, service)) {
                System.out.println("Wrong format, enter again:");
            } else {
                for (Facility f : facilities) {
                    if (f.getServiceCode().equals(serviceCode)) {
                        System.out.println("Service name is already exits, enter again:");
                        isServiceCodeExist = true;
                        break;
                    }
                }
                if (isServiceCodeExist){
                    break;
                 }else {
                    for (Facility f:maintenanceFacility){
                        if (f.getServiceCode().equals(serviceCode)) {
                            System.out.println("Service name is already exits, enter again:");
                            isServiceCodeExist = true;
                            break;
                        }
                    }
                }
            }
        } while (!Regex.checkServiceCodeFormat(serviceCode, service) || isServiceCodeExist);
        return serviceCode;
    }

    public static Double enterArea(String a) {
        double area = 0;
        do {
            try {
                System.out.println("Enter " + a + ":");
                area = Double.parseDouble(SCANNER.nextLine());
                if (area < 30) {
                    System.out.println("area have to > 30m2, enter again");
                }else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format, enter again");
            }
        } while (true);
        return area;
    }

    public static double enterPrice() {
        double price = 0;
        boolean flag;
        do {
            flag = false;
            try {
                System.out.println("Enter price");
                price = Double.parseDouble(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format, enter again");
                flag = true;
            }
        } while (flag);
        return price;
    }

    public static int enterMaxPeople() {
        int maxPeople = 0;
        boolean flag;
        do {
            flag = false;
            try {
                System.out.println("Enter max people");
                maxPeople = Integer.parseInt(SCANNER.nextLine());
                if (maxPeople < 1 || maxPeople > 20) {
                    System.out.println("max people must be in range 1-20, enter again");
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong number format, enter again");
                flag = true;
            }
        } while (flag);
        return maxPeople;
    }

    public static String chooseRentType() {
        boolean flag;
        String choose;
        String rentType = "";
        do {
            flag = false;
            System.out.println("-----CHOOSE RENT TYPE------" +
                    "\n1. year" +
                    "\n2. month" +
                    "\n3. day" +
                    "\n4. hour");
            choose = SCANNER.nextLine();
            switch (choose) {
                case "1":
                    rentType = "year";
                    break;
                case "2":
                    rentType = "month";
                    break;
                case "3":
                    rentType = "day";
                    break;
                case "4":
                    rentType = "hour";
                    break;
                default:
                    System.out.println("just choose form 1 - 4, choose again:");
                    flag = true;
            }
        } while (flag);
        return rentType;
    }

    public static String chooseRoomStandard() {
        String roomStandard = "";
        String choose = "";
        boolean flag;
        do {
            flag = false;
            System.out.println("-----Choose room standard -----" +
                    "\n1. Standard room" +
                    "\n2. Superior  room" +
                    "\n3. Deluxe  room" +
                    "\n4. Suite  room" +
                    "\nEnter your choice:");
            choose = SCANNER.nextLine();
            switch (choose) {
                case "1":
                    roomStandard = "Standard room";
                    break;
                case "2":
                    roomStandard = "Superior room";
                    break;
                case "3":
                    roomStandard = "Deluxe room";
                    break;
                case "4":
                    roomStandard = "Suite room";
                    break;
                default:
                    System.out.println("just choose form 1 - 4, choose again:");
                    flag = true;
            }
        } while (flag);
        return roomStandard;
    }

    public static int enterFloors() {
        int floors = 0;
        boolean flag;
        do {
            flag = false;
            System.out.println("Enter floors:");
            try {
                floors = Integer.parseInt(SCANNER.nextLine());
                if (floors < 0) {
                    System.out.println("floors must be > 0, enter again");
                    flag = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("wrong format, enter again");
                flag = true;
            }
        } while (flag);
        return floors;
    }

    public static String chooseFreeService() {
        String freeService = "";
        String choose = "";
        boolean flag;
        do {
            flag = false;
            System.out.println("------Choose free service------" +
                    "\n1. BreakFast." +
                    "\n2. Gym" +
                    "\n3. Pool" +
                    "\n4. Bar" +
                    "\n5. all service" +
                    "\nEnter your choice");
            choose = SCANNER.nextLine();
            switch (choose) {
                case "1":
                    freeService = "BreakFast";
                    break;
                case "2":
                    freeService = "Gym";
                    break;
                case "3":
                    freeService = "Pool";
                    break;
                case "4":
                    freeService = "Bar";
                    break;
                case "5":
                    freeService = "all service";
                    break;
                default: {
                    System.out.println("Just choose form 1 to 5, choose again");
                    flag = true;
                }
            }
        } while (flag);
        return freeService;
    }

}
