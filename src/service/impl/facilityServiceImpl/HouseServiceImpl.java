package service.impl.facilityServiceImpl;

import models.facility.Facility;
import models.facility.House;
import service.facility_service.HouseService;
import common.enterInformation.facilityInfor.EnterFacilityInformation;

public class HouseServiceImpl implements HouseService {


    @Override
    public Facility addFacility() {
        String serviceCode = EnterFacilityInformation.enterServiceCode("house");

        double area = EnterFacilityInformation.enterArea("area");

        double price = EnterFacilityInformation.enterPrice();

        int maxPeople = EnterFacilityInformation.enterMaxPeople();

        String rentType = EnterFacilityInformation.chooseRentType();

        String roomStandard = EnterFacilityInformation.chooseRoomStandard();

        int floors = EnterFacilityInformation.enterFloors();

        return new House(serviceCode, area, price, maxPeople, rentType, roomStandard, floors);
    }
}
