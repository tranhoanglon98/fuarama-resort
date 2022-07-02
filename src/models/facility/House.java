package models.facility;

public class House extends Facility{
    private String roomStandard;
    private int floors;

    public House() {
    }

    public House(String serviceName, double area, double price, int maxPeople, String rentType, String roomStandard, int floors) {
        super(serviceName, area, price, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+","+getRoomStandard()+","+getFloors();
    }

    @Override
    public String toString() {
        return super.toString()+", Room standard: "+roomStandard+", Floors: "+floors;
    }
}
