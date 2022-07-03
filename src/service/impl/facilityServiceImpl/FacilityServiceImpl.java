package service.impl.facilityServiceImpl;

import models.facility.Facility;
import service.facility_service.FacilityService;
import service.facility_service.HouseService;
import service.facility_service.RoomService;
import service.facility_service.VillaService;
import util.ReadAndWriteFile.ReadAndWriteFacility;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private static Scanner scanner = new Scanner(System.in);
    private static HouseService houseService = new HouseServiceImpl();
    private static VillaService villaService = new VillaServiceImpl();
    private static RoomService roomService = new RoomServiceImpl();


    @Override
    public void displayFacilityList() {
        Map<Facility, Integer> facilityMap = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> facilities = new ArrayList<>();
        facilities.addAll(facilityMap.keySet());
        Collections.sort(facilities);
        int i = 1;
        for (Facility f : facilities) {
            System.out.println((i++) + ". " + f.toString() + ", booked: " + facilityMap.get(f));
        }
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void addFacility() {
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        String choose = "";

        do {
            System.out.println("ADD NEW FACILITY\n" +
                    "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "\nEnter your choice");
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    facilityMap.put(villaService.addFacility(), 0);
                    break;
                case "2":
                    facilityMap.put(houseService.addFacility(), 0);
                    break;
                case "3":
                    facilityMap.put(roomService.addFacility(), 0);
                    break;
                case "4":

                    System.out.println("----------Back to menu----------");
                    break;
            }
        } while (!choose.equals("4"));

        ReadAndWriteFacility.writeCustomerDataFile(facilityMap, true);
    }

    @Override
    public void displayFacilityMaintenance() {

    }

}
