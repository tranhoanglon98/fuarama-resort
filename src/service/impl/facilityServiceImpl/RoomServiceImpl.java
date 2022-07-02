package service.impl.facilityServiceImpl;

import models.facility.Facility;
import models.facility.Room;
import service.facilityService.RoomService;
import util.enterInformation.facilityInfor.EnterFacilityInformation;

import java.util.Scanner;

public class RoomServiceImpl implements RoomService {

    @Override
    public Facility addFacility() {
        Scanner scanner = new Scanner(System.in);

        String serviceName = EnterFacilityInformation.enterServiceName();

        double area = EnterFacilityInformation.enterArea("area");

        double price = EnterFacilityInformation.enterPrice();

        int maxPeople = EnterFacilityInformation.enterMaxPeople();

        String rentType = EnterFacilityInformation.chooseRentType();

        String freeService = EnterFacilityInformation.chooseFreeService();

        return new Room(serviceName,area,price,maxPeople,rentType,freeService);
    }

}