package service.impl.facilityServiceImpl;

import models.facility.Facility;
import models.facility.Villa;
import service.facilityService.VillaService;
import util.enterInformation.facilityInfor.EnterFacilityInformation;

public class VillaServiceImpl implements VillaService {

    @Override
    public Facility addFacility() {

        String serviceName = EnterFacilityInformation.enterServiceName();

        double area = EnterFacilityInformation.enterArea("area");

        double price = EnterFacilityInformation.enterPrice();

        int maxPeople = EnterFacilityInformation.enterMaxPeople();

        String rentType = EnterFacilityInformation.chooseRentType();

        String roomStandard = EnterFacilityInformation.chooseRoomStandard();

        double poolArea = EnterFacilityInformation.enterArea("pool area");

        int floors = EnterFacilityInformation.enterFloors();

        return new Villa(serviceName, area, price, maxPeople, rentType, roomStandard, poolArea, floors);
    }

}
