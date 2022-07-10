package common.ReadAndWriteFile;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import java.util.*;

public class ReadAndWriteFacility {
    private static final String FACILITY_PATH_FILE = "src/data/facility_data_file.csv";
    private static final String MAINTENANCE_FACILITY_PATH_FILE = "src/data/facility_maintenance_data.csv";

    public static void writeFacilityDataFile(Map<Facility,Integer> facilityMap, boolean append) {
        List<String> strings = new ArrayList<>();
        Set<Facility> facilities = facilityMap.keySet();
        for (Facility f : facilities) {
            strings.add(f.getInfoToCsvFile()+","+facilityMap.get(f));
        }
        ReadAndWriteFile.writeDataFile(strings, FACILITY_PATH_FILE, append);
    }

    public static Map<Facility,Integer> readFacilityDataFile() {
        Map<Facility,Integer> facilityMap = new LinkedHashMap<>();
        List<String> strings = ReadAndWriteFile.readDataFile(FACILITY_PATH_FILE);
        for (String s : strings) {
            String[] array = s.split(",");
            if (array.length == 7) {
                facilityMap.put(new Room(array[0], Double.parseDouble(array[1]),Double.parseDouble(array[2]),Integer.parseInt(array[3]), array[4], array[5]),Integer.parseInt(array[6]));
            }else if (array.length == 8){
                facilityMap.put(new House(array[0], Double.parseDouble(array[1]),Double.parseDouble(array[2]),Integer.parseInt(array[3]), array[4],array[5],Integer.parseInt(array[6])),Integer.parseInt(array[7]));
            }else if (array.length == 9){
                facilityMap.put(new Villa(array[0], Double.parseDouble(array[1]),Double.parseDouble(array[2]),Integer.parseInt(array[3]), array[4],array[5],Double.parseDouble(array[6]),Integer.parseInt(array[7])),Integer.parseInt(array[8]));
            }
        }
        return facilityMap;
    }

    public static void writeFacilityMaintenanceDataFile(Set<Facility> facilitySet, boolean append) {
        List<String> strings = new ArrayList<>();
        for (Facility f : facilitySet) {
            strings.add(f.getInfoToCsvFile());
        }
        ReadAndWriteFile.writeDataFile(strings, MAINTENANCE_FACILITY_PATH_FILE, append);
    }


    public static List<Facility> readFacilityMaintenanceDataFile() {
        List<Facility> facilitySet = new LinkedList<>();
        List<String> strings = ReadAndWriteFile.readDataFile(MAINTENANCE_FACILITY_PATH_FILE);
        for (String s : strings) {
            String[] array = s.split(",");
            if (array.length == 6) {
                facilitySet.add(new Room(array[0], Double.parseDouble(array[1]),Double.parseDouble(array[2]),Integer.parseInt(array[3]), array[4], array[5]));
            }else if (array.length == 7){
                facilitySet.add(new House(array[0], Double.parseDouble(array[1]),Double.parseDouble(array[2]),Integer.parseInt(array[3]), array[4],array[5],Integer.parseInt(array[6])));
            }else if (array.length == 8){
                facilitySet.add(new Villa(array[0], Double.parseDouble(array[1]),Double.parseDouble(array[2]),Integer.parseInt(array[3]), array[4],array[5],Double.parseDouble(array[6]),Integer.parseInt(array[7])));
            }
        }
        return facilitySet;
    }
}
