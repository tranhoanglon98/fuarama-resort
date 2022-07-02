package models.facility;

import java.util.Objects;

public abstract class Facility implements Comparable<Facility>{
    private String serviceName;
    private double area;
    private double price;
    private int maxPeople;
    private String rentType;

    public Facility() {
    }

    public Facility(String serviceName, double area, double price, int maxPeople, String rentType) {
        this.serviceName = serviceName;
        this.area = area;
        this.price = price;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getInfoToCsvFile(){
        return getServiceName()+","+getArea()+","+getPrice()+","+getMaxPeople()+","+getRentType();
    }

    @Override
    public String toString() {
        return "service name : "+serviceName+", Area: "+area+", Price: "+price+", Max people: "+maxPeople+", Rent type: "+rentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Facility)) return false;
        Facility facility = (Facility) o;
        return Objects.equals(serviceName, facility.serviceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName);
    }

    @Override
    public int compareTo(Facility o) {
        return this.serviceName.compareTo(o.serviceName);
    }
}
