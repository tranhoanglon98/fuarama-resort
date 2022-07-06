package util.enterInformation.facilityInfor;

import models.facility.Facility;
import util.ReadAndWriteFile.ReadAndWriteFacility;

import java.util.*;

public class CheckFacilityInfo {
    public static void checkMaintenanceFacility() {
        Map<Facility, Integer> map = ReadAndWriteFacility.readFacilityDataFile();
        List<Facility> keyList = new LinkedList<>(map.keySet());
        Set<Facility> facilityMaintenance = new LinkedHashSet<>();

        for (Facility f : keyList) {
            if (map.get(f) == 5) {
                facilityMaintenance.add(f);
                map.remove(f);
            }
        }

        ReadAndWriteFacility.writeFacilityDataFile(map, false);
        ReadAndWriteFacility.writeFacilityMaintenanceDataFile(facilityMaintenance, true);
    }
}
