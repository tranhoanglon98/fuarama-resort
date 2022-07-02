package models.facility;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, double area, double price, int maxPeople, String rentType, String freeService) {
        super(serviceName, area, price, maxPeople, rentType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String getInfoToCsvFile() {
        return super.getInfoToCsvFile()+","+getFreeService();
    }

    @Override
    public String toString() {
        return super.toString()+", Free service: "+freeService;
    }
}
