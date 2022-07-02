package util.ReadAndWriteFile;

import models.facility.Facility;
import models.facility.House;
import models.facility.Room;
import models.facility.Villa;
import java.util.*;

public class ReadAndWriteFacility {
    private static final String PATH_FILE = "src/data/facility_data_file.csv";

    public static void writeCustomerDataFile(Map<Facility,Integer> facilityMap, boolean append) {
        List<String> strings = new ArrayList<>();
        Set<Facility> facilities = facilityMap.keySet();
        for (Facility f : facilities) {
            strings.add(f.getInfoToCsvFile()+","+facilityMap.get(f));
        }
        ReadAndWriteFile.writeDataFile(strings, PATH_FILE, append);
    }

    public static Map<Facility,Integer> readFacilityDataFile() {
        Map<Facility,Integer> facilityMap = new LinkedHashMap<>();
        List<String> strings = ReadAndWriteFile.readDataFile(PATH_FILE);
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
}
