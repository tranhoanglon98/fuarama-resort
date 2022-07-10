package service.impl.facilityServiceImpl;

import models.facility.Facility;
import service.facility_service.FacilityService;
import service.facility_service.HouseService;
import service.facility_service.RoomService;
import service.facility_service.VillaService;
import common.ReadAndWriteFile.ReadAndWriteFacility;
import common.enterInformation.facilityInfor.CheckFacilityInfo;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static  HouseService houseService;
    private static  VillaService villaService;
    private static  RoomService roomService;


    @Override
    public void displayFacilityList() {
        Map<Facility, Integer> facilityMap = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> facilities = new ArrayList<>(facilityMap.keySet());
        Collections.sort(facilities);
        for (int i = 0; i < facilities.size(); i++) {
            System.out.println((i+1) + ". "+facilities.get(i)+", booked: " + facilityMap.get(facilities.get(i)));
        }
        System.out.println("--------------------------------------------------");
    }

    @Override
    public void addFacility() {
        houseService = new HouseServiceImpl();
        villaService = new VillaServiceImpl();
        roomService = new RoomServiceImpl();
        Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
        String choose = "";

        do {
            System.out.println("ADD NEW FACILITY\n" +
                    "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "\nEnter your choice");
            choose = SCANNER.nextLine();
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

        ReadAndWriteFacility.writeFacilityDataFile(facilityMap, true);
    }

    @Override
    public void displayFacilityMaintenance() {
        CheckFacilityInfo.checkMaintenanceFacility();
        List<Facility> facilities = ReadAndWriteFacility.readFacilityMaintenanceDataFile();
        int index=1;
        for (Facility f:facilities){
            System.out.println((index++)+". " + f);
        }
    }
}
