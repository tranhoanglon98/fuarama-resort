package service.impl.facilityServiceImpl;

import models.facility.Facility;
import models.facility.Room;
import service.facility_service.RoomService;
import common.enterInformation.facilityInfor.EnterFacilityInformation;

import java.util.Scanner;

public class RoomServiceImpl implements RoomService {

    @Override
    public Facility addFacility() {
        Scanner scanner = new Scanner(System.in);

        String serviceCode = EnterFacilityInformation.enterServiceCode("room");

        double area = EnterFacilityInformation.enterArea("area");

        double price = EnterFacilityInformation.enterPrice();

        int maxPeople = EnterFacilityInformation.enterMaxPeople();

        String rentType = EnterFacilityInformation.chooseRentType();

        String freeService = EnterFacilityInformation.chooseFreeService();

        return new Room(serviceCode,area,price,maxPeople,rentType,freeService);
    }

}
