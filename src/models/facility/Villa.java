package models.facility;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int floors;

    public Villa() {
    }

    public Villa(String serviceCode, double area, double price, int maxPeople, String rentType, String roomStandard, double poolArea, int floors) {
        super(serviceCode, area, price, maxPeople, rentType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+","+getRoomStandard()+","+getPoolArea()+","+getFloors();
    }

    @Override
    public String toString() {
        return super.toString()+", Room standard: "+roomStandard+", Poole area: "+poolArea+", Floors: "+floors;
    }
}
