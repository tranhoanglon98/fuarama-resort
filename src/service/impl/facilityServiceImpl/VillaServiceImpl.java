package service.impl.facilityServiceImpl;

import models.facility.Facility;
import models.facility.Villa;
import service.facility_service.VillaService;
import common.enterInformation.facilityInfor.EnterFacilityInformation;

public class VillaServiceImpl implements VillaService {

    @Override
    public Facility addFacility() {

        String serviceCode = EnterFacilityInformation.enterServiceCode("villa");

        double area = EnterFacilityInformation.enterArea("area");

        double price = EnterFacilityInformation.enterPrice();

        int maxPeople = EnterFacilityInformation.enterMaxPeople();

        String rentType = EnterFacilityInformation.chooseRentType();

        String roomStandard = EnterFacilityInformation.chooseRoomStandard();

        double poolArea = EnterFacilityInformation.enterArea("pool area");

        int floors = EnterFacilityInformation.enterFloors();

        return new Villa(serviceCode, area, price, maxPeople, rentType, roomStandard, poolArea, floors);
    }

}
